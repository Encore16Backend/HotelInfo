package com.four.hotelinfo.repo;

import com.four.hotelinfo.model.Hotel_Main;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelMainRepo extends JpaRepository<Hotel_Main, Long> {

}
