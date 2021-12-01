package com.four.hotelinfo.Controller;

import com.four.hotelinfo.model.HotelDetail;
import com.four.hotelinfo.model.HotelMain;
import com.four.hotelinfo.model.HotelRoomInfo;
import com.four.hotelinfo.model.Review;
import com.four.hotelinfo.service.HotelDetailService;
import com.four.hotelinfo.service.HotelMainService;
import com.four.hotelinfo.service.ReviewService;
import com.four.hotelinfo.service.RoomInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detail")
public class DetailController {

    private final HotelDetailService hotelService;
    private final RoomInfoService roomService;
    private final ReviewService reviewService;
    private final HotelMainService mainService;

    public DetailController(HotelDetailService hotelService, RoomInfoService roomService, ReviewService reviewService, HotelMainService mainService) {
        this.hotelService = hotelService;
        this.roomService = roomService;
        this.reviewService = reviewService;
        this.mainService = mainService;
    }

    @GetMapping("/hotel/{hotelid}")
    public ResponseEntity<HotelDetail> getHotelInfo(@PathVariable("hotelid") int hotelid){
        HotelDetail roomInfos = hotelService.findHotelInfo(hotelid);
        return new ResponseEntity<>(roomInfos, HttpStatus.OK);
    }

    @GetMapping("/room/{hotelid}")
    public ResponseEntity<List<HotelRoomInfo>> getAllRoom(@PathVariable("hotelid") Long hotels) {
        List<HotelRoomInfo> room = roomService.findAllHotelRoomInfoList(hotels);
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @GetMapping("/review/{hotelid}")
    public ResponseEntity<Page<Review>> getHotelAllReview(
            @PathVariable("hotelid") Long hotelId,
            @RequestParam(required = false, defaultValue = "1", value = "page") int page){
        Pageable pageable = PageRequest.of(page-1, 5, Sort.by(Sort.Direction.ASC, "seq"));
        Page<Review> review = reviewService.findReviewByHotelId(pageable, hotelId);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @GetMapping("/adhotel/{hotelid}")
    public ResponseEntity<HotelMain> getHotelBasic(@PathVariable("hotelid") Long hotelid){
        HotelMain hotel = mainService.findHotel(hotelid);
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }

}
