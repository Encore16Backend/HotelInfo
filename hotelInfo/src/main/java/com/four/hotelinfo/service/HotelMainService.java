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
    
    public Page<HotelMain> findByName(Pageable pageable, String Keyword) {
        System.out.println(Keyword);
        String Keyword1 = Keyword;
        String Keyword2 = Keyword;
        hotelMainRepo.hotelSearchName(Keyword,pageable.getOffset());
        return hotelMainRepo.findAllByHotelnameLikeOrAddressLike(Keyword1, Keyword2, pageable);
    }



}
