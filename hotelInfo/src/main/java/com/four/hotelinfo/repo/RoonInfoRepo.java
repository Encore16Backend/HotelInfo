package com.four.hotelinfo.repo;

import com.four.hotelinfo.model.HotelRoomInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoonInfoRepo extends JpaRepository<HotelRoomInfo, Long> {
    List<HotelRoomInfo> findAllByHotelid(Long hotelid);
}
