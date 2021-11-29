package com.four.hotelinfo.service;

import com.four.hotelinfo.model.Review;
import com.four.hotelinfo.repo.ReviewRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepo reviewRepo;

    public ReviewService(ReviewRepo reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    // 리뷰 쓰기
    public Boolean insertReview(Review review) {
        reviewRepo.save(review);
        return true;
    }

    // 리뷰 삭제 - Long seq, String userId
    public Boolean deleteReview(Long seq,String userid) {
        Optional<Review> exist = reviewRepo.findBySeqAndUserId(seq,userid);
        if(!exist.isPresent()){
            return false;
        }
        reviewRepo.deleteReviewBySeqAndUserId(seq,userid);
        return true;
    }

    // 리뷰 1개 조회 - userId
    public Review findMyReview(String userId) {
        return reviewRepo.findByUserId(userId);
    }

    // 리뷰 전체조회 - userId
    public List<Review> findAllMyReview(String userId){
        return reviewRepo.findAllByUserId(userId);
    }

    // 리뷰 전체조회 - hotelId
    public List<Review> findReviewByHotelId(Long hotelId){
        return reviewRepo.findByHotelId(hotelId);
    }

    //리뷰 전체 조회 - 조건없이 전부
    public List<Review> findAllReview(){
        return reviewRepo.findAll();
    }


}
