package com.four.hotelinfo.repo;

import com.four.hotelinfo.model.HotelMain;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface HotelMainRepo extends JpaRepository<HotelMain, Long> {

    Page<HotelMain> findAllByHotelnameLikeOrAddressLike(String Keyword1, String Keyword2, Pageable pageable);

    @Query(value="select * from hotel_main_tbl where (hotelname like :keyword1 or address like :keyword1) and address like :keyword2 order by hotelid", nativeQuery=true )
    Page<HotelMain> find(@Param("keyword1") String keyword1, @Param("keyword2") String keyword2,Pageable pageable);
    
    @Modifying
    @Transactional
    @Query(value="MERGE INTO hotel_main_tbl H\r\n" + 
    		"USING (\r\n" + 
    		"SELECT h.hotelid hotelid, nvl(round(avg(r.review_score),1),0) score\r\n" + 
    		"from HOTEL_MAIN_TBL h, review_tbl r, ( SELECT hotelid\r\n" + 
    		"FROM (SELECT ROWNUM r, h1.*\r\n" + 
    		"FROM (select hotelid from hotel_main_tbl where (hotelname like :keyword1 or address like :keyword1) and address like :keyword2 order by hotelid) h1)\r\n" +
    		"WHERE r between :cnt and :cnt + 12) h2\r\n" + 
    		"where  (h.hotelid = h2.hotelid) and (h.hotelid = r.hotelid(+))\r\n" + 
    		"group by h.hotelid\r\n" + 
    		"order by h.hotelid) S\r\n" + 
    		"ON (H.hotelid = S.hotelid)\r\n" + 
    		"WHEN MATCHED THEN\r\n" + 
    		"UPDATE SET H.SCORE = S.SCORE", nativeQuery=true)
    void hotelSearchName(@Param("keyword1") String keyword1, @Param("keyword2") String keyword2, @Param("cnt") Long cnt);

    @Modifying
    @Transactional
    @Query(value="MERGE INTO hotel_main_tbl H\r\n" +
            "USING (SELECT h.hotelid hotelid, nvl(round(avg(r.review_score),1),0) score from HOTEL_MAIN_TBL h, review_tbl r where (h.hotelid between :cnt and :cnt + 12) and (h.hotelid = r.hotelid(+)) group by h.hotelid order by h.hotelid) S\r\n" +
            "ON (H.hotelid = S.hotelid)\r\n" +
            "WHEN MATCHED THEN\r\n" +
            "UPDATE SET H.SCORE = S.SCORE", nativeQuery=true)
    void hotelSetScore(@Param("cnt") Long cnt);

	HotelMain findByHotelid(Long hotelid);
}
