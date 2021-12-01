package com.four.hotelinfo.service;

import com.four.hotelinfo.model.HotelRoomInfo;
import com.four.hotelinfo.repo.RoonInfoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomInfoService {
    private final RoonInfoRepo roonInfoRepo;

    public RoomInfoService(RoonInfoRepo roonInfoRepo) {
        this.roonInfoRepo = roonInfoRepo;
    }

    public List<HotelRoomInfo> findAllHotelRoomInfoList(Long hotelid){
        return roonInfoRepo.findAllByHotelid(hotelid);
    }


}
