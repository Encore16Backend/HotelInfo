package com.four.hotelinfo.repo;

import com.four.hotelinfo.model.HotelMain;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HotelMainRepo extends JpaRepository<HotelMain, Long> {

    Page<HotelMain> findAllByHotelnameContains(String Keyword, Pageable pageable);
    
    @Query(value="SELECT h.*, avg(r.review_score) score from HOTEL_MAIN_TBL h, review_tbl r where h.hotelid = r.hotelid(+) group by h.hotelid, h.hotelimage, h.address,h.hotelname order by h.hotelid", nativeQuery=true)
	List<HotelMain> findAllwithScore();
    
    // 호텔별 평균 평점
    // SELECT h.*, avg(r.reviewScore)
    // from HOTEL_MAIN_TBL h, Review_TBL r
    // where h.hotelid = r.hotelId(+)
    // group by h.hotelid

}
