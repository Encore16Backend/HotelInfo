package com.four.hotelinfo.Controller;

import com.four.hotelinfo.service.HotelDetailService;
import com.four.hotelinfo.service.ReviewService;
import com.four.hotelinfo.service.RoomInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/detail")
public class DetailController {

    private final HotelDetailService hotelService;
    private final RoomInfoService roomService;
    private final ReviewService reviewService;

    public DetailController(HotelDetailService hotelService, RoomInfoService roomService, ReviewService reviewService) {
        this.hotelService = hotelService;
        this.roomService = roomService;
        this.reviewService = reviewService;
    }

//    @GetMapping("/{hotelid}")
//    public ResponseEntity


}
