package com.four.hotelinfo.Controller;

import com.four.hotelinfo.model.HotelRoomInfo;
import com.four.hotelinfo.service.RoomInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/detail")
public class RoomInfoController {

    private final RoomInfoService service;

    public RoomInfoController(RoomInfoService service) {
        this.service = service;
    }

    @GetMapping("/getRoom")
    public ResponseEntity<List<HotelRoomInfo>> getAllRoom(Long hotels) {
        List<HotelRoomInfo> room = service.findAllHotelRoomInfoList(hotels);
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

}
