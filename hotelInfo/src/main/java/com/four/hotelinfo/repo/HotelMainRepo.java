package com.four.hotelinfo.repo;

import com.four.hotelinfo.model.HotelMain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelMainRepo extends JpaRepository<HotelMain, Long> {

    Page<HotelMain> findAllByHotelnameContains(String Keyword, Pageable pageable);
    
    // 호텔별 평균 평점
    // SELECT h.*, avg(r.reviewScore)
    // from HOTEL_MAIN_TBL h, Review_TBL r
    // where h.hotelid = r.hotelId(+)
    // group by h.hotelid

}
