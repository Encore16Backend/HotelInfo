package com.four.hotelinfo.service;

import com.four.hotelinfo.model.HotelDetail;
import com.four.hotelinfo.repo.HotelDetailRepo;
import org.springframework.stereotype.Service;

@Service
public class HotelDetailService {

    private final HotelDetailRepo hotelDetailRepo;

    public HotelDetailService(HotelDetailRepo hotelDetailRepo) {
        this.hotelDetailRepo = hotelDetailRepo;
    }

    public HotelDetail findHotelInfo(int hotelid) {
        return hotelDetailRepo.findByHotelid(hotelid);
    }


}
