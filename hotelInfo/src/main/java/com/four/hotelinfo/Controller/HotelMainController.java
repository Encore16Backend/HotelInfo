package com.four.hotelinfo.Controller;

import com.four.hotelinfo.model.Hotel_Main;
import com.four.hotelinfo.service.HotelMainService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/main")
public class HotelMainController {

    private final HotelMainService service;

    public HotelMainController(HotelMainService service) {
        this.service = service;
    }

    @GetMapping("/allhotel")
    public ResponseEntity<List<Hotel_Main>> getAllHotels() {
        List<Hotel_Main> hotels = service.findAllHotel();
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @GetMapping("/hotel")
    public ResponseEntity<Page<Hotel_Main>> getHotels(@RequestParam(required = false, defaultValue = "1", value = "page") int page){
        Pageable pageable = PageRequest.of(page-1, 12, Sort.by(Sort.Direction.ASC, "hotelid"));
//        System.out.println("페이지 넘버 : "+pageable.getPageNumber());
//        System.out.println("Offset : "+pageable.getOffset());
        Page<Hotel_Main> hotels = service.findPagingHotel(pageable);
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }













}
