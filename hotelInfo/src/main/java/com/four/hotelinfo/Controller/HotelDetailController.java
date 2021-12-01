package com.four.hotelinfo.Controller;

import com.four.hotelinfo.model.HotelDetail;
import com.four.hotelinfo.model.HotelMain;
import com.four.hotelinfo.model.HotelRoomInfo;
import com.four.hotelinfo.service.HotelDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/detail")
public class HotelDetailController {

    private final HotelDetailService service;

    public HotelDetailController(HotelDetailService service) {
        this.service = service;
    }

    @GetMapping("/{hotelid}")
    public ResponseEntity<HotelDetail> getAllRoomInfo(@PathVariable("hotelid") Integer hotelid) {
        HotelDetail roomInfos = service.findAllHotelRoomInfo(hotelid);
        return new ResponseEntity<>(roomInfos, HttpStatus.OK);
    }
}
