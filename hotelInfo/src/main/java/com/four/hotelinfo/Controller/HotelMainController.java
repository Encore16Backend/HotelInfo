package com.four.hotelinfo.Controller;

import com.four.hotelinfo.model.HotelMain;
import com.four.hotelinfo.service.HotelMainService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public ResponseEntity<List<HotelMain>> getAllHotels() {
        List<HotelMain> hotels = service.findAllHotel();
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @GetMapping("/hotel")
    public ResponseEntity<Page<HotelMain>> getHotels(
            @RequestParam(required = false, defaultValue = "1", value = "page") int page){
        Pageable pageable = PageRequest.of(page-1, 12, Sort.by(Sort.Direction.ASC, "hotelid"));
//        System.out.println("페이지 넘버 : "+pageable.getPageNumber());
//        System.out.println("Offset : "+pageable.getOffset());
        Page<HotelMain> hotels = service.findPagingHotel(pageable);
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }
//    @PathVariable("keyword") String keyword
    @GetMapping("/search")
    public ResponseEntity<Page<HotelMain>> searchHotel(
            @RequestParam(required = false, defaultValue = "", value = "keyword1") String keyword1,
            @RequestParam(required = false, defaultValue = "", value = "keyword2") String keyword2,
            @RequestParam(required = false, defaultValue = "1", value = "page") int page){
        Pageable pagealbe = PageRequest.of(page-1, 12, Sort.by(Sort.Direction.ASC, "hotelid"));
        Page<HotelMain> hotels = service.findBytwoKeyword(pagealbe, "%"+keyword1+"%", "%"+keyword2+"%");
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }













}
