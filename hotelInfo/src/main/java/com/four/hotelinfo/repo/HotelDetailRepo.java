package com.four.hotelinfo.repo;

import com.four.hotelinfo.model.HotelDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelDetailRepo extends JpaRepository<HotelDetail, Integer> {

    HotelDetail findByHotelid(int hotelid);

    //Page<HotelDetail> findAllByHotelid(int hotelid, Pageable pageable);

    /*TRUE인것만 사우나:Y 같은 식으로 표현하기
     *        => 프론트엔드 파트에서
     *     private String seminar; //이하 FALSE or TRUE
     *     private String sports;
     *     private String sauna;
     *     private String beauty;
     *     private String karaoke;
     *     private String BBQ;
     *     private String bicycle;
     *     private String fitness;
     *     private String publicpc;
     *     private String publicshower;*/


}
