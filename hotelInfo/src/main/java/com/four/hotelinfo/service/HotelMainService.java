package com.four.hotelinfo.service;

import com.four.hotelinfo.model.Hotel_Main;
import com.four.hotelinfo.repo.HotelMainRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class HotelMainService {

    private final HotelMainRepo hotelMainRepo;

    public HotelMainService(HotelMainRepo hotelMainRepo) {
        this.hotelMainRepo = hotelMainRepo;
    }

    public List<Hotel_Main> findAllHotel() {
        return hotelMainRepo.findAll(Sort.by(Sort.Direction.ASC, "hotelid"));
    }

    public Page<Hotel_Main> findPagingHotel(Pageable pageable) {
//        System.out.println(pageable.getPageNumber());
        return hotelMainRepo.findAll(pageable);
    }






}
