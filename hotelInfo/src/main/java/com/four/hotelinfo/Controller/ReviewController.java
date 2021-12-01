package com.four.hotelinfo.Controller;

import com.four.hotelinfo.model.Review;
import com.four.hotelinfo.service.ReviewService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteReview(
            @RequestParam(required = true, value="seq") Long seq,
            @RequestParam(required = true, value="userid") String Userid) {
        boolean result = service.deleteReview(seq,Userid);
        if(result){
            return new ResponseEntity<>("SUCCESS",HttpStatus.OK);
        }
        return new ResponseEntity<>("FAIL", HttpStatus.OK);
    }

    // 리뷰 전체보기 - userId - MyPage(127.0.0.1:9000/review/myReview/유저아이디?page=n)
    @GetMapping("/myReview/{userid}")
    public ResponseEntity<Page<Review>> getMyOneReview(
            @PathVariable("userid") String userId,
            @RequestParam(required = false, defaultValue = "1", value = "page") int page){
        Pageable pageable = PageRequest.of(page-1, 10, Sort.by(Sort.Direction.ASC, "seq"));
        Page<Review> review = service.findReviewByUserId(pageable, userId);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    // 리뷰 전체보기 - hotelId - Hotel Detail(127.0.0.1:9000/review/hotelAllReview/호텔명?page=n)
    //리뷰 평균 점수 보기
    @GetMapping("/hotelReviewScore/{hotelid}")
    public ResponseEntity<String> getHotelReviewScore(@PathVariable("hotelid") Long hotelId){
        String score = service.getReviewScore(hotelId);
        if(score==null)score="0"; // null 일 경우 0을 리턴
        return new ResponseEntity<>(score, HttpStatus.OK);
    }

    // 리뷰 전체보기 - hotelId
//    @GetMapping("/hotelAllReview/{hotelid}")
//    public ResponseEntity<Page<Review>> getHotelAllReview(
//            @PathVariable("hotelid") Long hotelId,
//            @RequestParam(required = false, defaultValue = "1", value = "page") int page){
//        Pageable pageable = PageRequest.of(page-1, 10, Sort.by(Sort.Direction.ASC, "seq"));
//        Page<Review> review = service.findReviewByHotelId(pageable, hotelId);
//        return new ResponseEntity<>(review, HttpStatus.OK);
//    }

    // 리뷰 전체보기 (조건X) - Admin
    @GetMapping("/allReview")
    public ResponseEntity<List<Review>> getAllReview(){
        List<Review> reviews = service.findAllReview();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }
}
