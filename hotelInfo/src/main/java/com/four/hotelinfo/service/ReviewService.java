package com.four.hotelinfo.service;

import com.four.hotelinfo.model.Review;
import com.four.hotelinfo.repo.ReviewRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        if(!exist.isPresent() || userid.equals("admin")){
            return false;
        }
        reviewRepo.deleteReviewBySeqAndUserId(seq,userid);
        return true;
    }

    // 호텔 리뷰 평점
    public String getReviewScore(Long hotelId) {
    	return reviewRepo.getReviewScore(hotelId);
    }
    
    // 리뷰 1개 조회 - userId
//    public Review findMyReview(String userId) {
//        return reviewRepo.findByUserId(userId);
//    }

    // 리뷰 전체조회 - userId 10개씩
    public Page<Review> findReviewByUserId(Pageable pageable, String userId){
        return reviewRepo.findAllByUserId(userId, pageable);
    }

    // 리뷰 전체조회 - hotelId
    /*public List<Review> findReviewByHotelId(Long hotelId){
        return reviewRepo.findByHotelId(hotelId);
    }*/

    // 리뷰 전체 조회 - hotelId 10개씩
    public Page<Review> findReviewByHotelId(Pageable pages, Long hotelId){
        return reviewRepo.findAllByHotelid(hotelId, pages);
    }

    //리뷰 전체 조회 - 조건없이 전부
    public List<Review> findAllReview(){
        return reviewRepo.findAll();
    }


}
