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

    Page<HotelMain> findAllByHotelnameLike(String Keyword, Pageable pageable);

    @Modifying
    @Transactional
    @Query(value="MERGE INTO hotel_main_tbl H\r\n" +
            "USING (SELECT h.hotelid hotelid, nvl(round(avg(r.review_score),1),0) score from HOTEL_MAIN_TBL h, review_tbl r where (h.hotelname like :=keyword) and (h.hotelid = r.hotelid(+)) group by h.hotelid order by h.hotelid) S\r\n" +
            "ON (H.hotelid = S.hotelid)\r\n" +
            "WHEN MATCHED THEN\r\n" +
            "UPDATE SET H.SCORE = S.SCORE", nativeQuery=true)
    void hotelSearchName(@Param("keyword") String keyword);

    @Modifying
    @Transactional
    @Query(value="MERGE INTO hotel_main_tbl H\r\n" +
            "USING (SELECT h.hotelid hotelid, nvl(round(avg(r.review_score),1),0) score from HOTEL_MAIN_TBL h, review_tbl r where (h.hotelid between :cnt and :cnt + 12) and (h.hotelid = r.hotelid(+)) group by h.hotelid order by h.hotelid) S\r\n" +
            "ON (H.hotelid = S.hotelid)\r\n" +
            "WHEN MATCHED THEN\r\n" +
            "UPDATE SET H.SCORE = S.SCORE", nativeQuery=true)
    void hotelSetScore(@Param("cnt") Long cnt);
}
