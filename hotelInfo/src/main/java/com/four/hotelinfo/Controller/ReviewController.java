package com.four.hotelinfo.Controller;

import com.four.hotelinfo.model.Review;
import com.four.hotelinfo.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {
    private final ReviewService service;

    public ReviewController(ReviewService service) {
        this.service = service;
    }

    //리뷰 쓰기
    @PostMapping("/write")
    public ResponseEntity<?> writeReview(@RequestBody Review review) {
        //프론트에서 Long hotelId, String userId 받을것
        boolean result = service.insertReview(review);
        if (result) {
            return new ResponseEntity<>("SUCCESS", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("FAIL", HttpStatus.CONFLICT);
        }
    }

    //리뷰 삭제 - seq, userId
    @DeleteMapping("/delete/{seq},{userid}")
    public ResponseEntity<?> deleteMember(@PathVariable("seq") Long seq, @PathVariable("userid") String Userid) {
        boolean result = service.deleteReview(seq,Userid);
        if(result){
            return new ResponseEntity<>("SUCCESS",HttpStatus.OK);
        }
        return new ResponseEntity<>("FAIL", HttpStatus.OK);
    }

    // 리뷰 1개 보기 - userId
    @GetMapping("/myAllReview/{userid}")
    public ResponseEntity<List<Review>> getMyAllReview(@PathVariable("userid") String userId){
        List<Review> reviews = service.findAllMyReview(userId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    // 리뷰 전체보기 - userId
    @GetMapping("/myReview/{userid}")
    public ResponseEntity<Review> getMyOneReview(@PathVariable("userid") String userId){
        Review review = service.findMyReview(userId);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }


    // 리뷰 전체보기 - hotelId
    @GetMapping("/hotelAllReview/{hotelid}")
    public ResponseEntity<List<Review>> getHotelAllReview(@PathVariable("hotelid") Long hotelId){
        List<Review> review = service.findReviewByHotelId(hotelId);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    // 리뷰 전체보기 (조건X)
    @GetMapping("/allReview")
    public ResponseEntity<List<Review>> getAllReview(){
        List<Review> reviews = service.findAllReview();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }
}
