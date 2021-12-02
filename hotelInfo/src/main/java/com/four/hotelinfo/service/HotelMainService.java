package com.four.hotelinfo.service;

import com.four.hotelinfo.model.HotelMain;
import com.four.hotelinfo.repo.HotelMainRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelMainService {

    private final HotelMainRepo hotelMainRepo;

    public HotelMainService(HotelMainRepo hotelMainRepo) {
        this.hotelMainRepo = hotelMainRepo;
    }

    public List<HotelMain> findAllHotel() {
        return hotelMainRepo.findAll();
    }

    public Page<HotelMain> findPagingHotel(Pageable pageable) {
//        System.out.println(pageable.getPageNumber());
        hotelMainRepo.hotelSetScore(pageable.getOffset());
        return hotelMainRepo.findAll(pageable);
    }
    
    //keyword1개로 hotelname or address 검색하는 메소드
    public Page<HotelMain> findByName(Pageable pageable, String Keyword1, String Keyword2) {
        hotelMainRepo.hotelSearchName(Keyword1, Keyword2, pageable.getOffset());
        return hotelMainRepo.findAllByHotelnameLikeOrAddressLike(Keyword1, Keyword2, pageable);
    }
    
    //마지막에 추가된 검색 메소드
    public Page<HotelMain> findBytwoKeyword(Pageable pageable, String Keyword1, String Keyword2) {
        hotelMainRepo.hotelSearchName(Keyword1, Keyword2, pageable.getOffset());
        return hotelMainRepo.find( Keyword1, Keyword2, pageable);
    }

    public HotelMain findHotel(Long hotel){
        return hotelMainRepo.findByHotelid(hotel);
    }



}
