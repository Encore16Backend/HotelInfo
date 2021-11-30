package com.four.hotelinfo.repo;

import com.four.hotelinfo.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ReviewRepo extends JpaRepository<Review, Long> {

	// 호텔 리뷰 평점
	
	@Query(value="SELECT avg(review_score) FROM review_tbl WHERE hotel_id = :Id group by hotel_id", nativeQuery=true)
	String getReviewScore(@Param("Id") Long HotelId);

    // 1개 조회 - seq
    Optional<Review> findBySeq(Long seq);

    // 1개 조회 - userId
    Review findByUserId(String UserId);

    // 1개 조회 - seq, userId
    Optional<Review> findBySeqAndUserId(Long seq,String userId);

    // 전체 조회 - userId
    List<Review> findAllByUserId(String userId);

    // 전체 조회 - hotelId
    List<Review> findByHotelId(Long hotelId);

    // 리뷰 삭제 - seq, userId
    @Transactional
    void deleteReviewBySeqAndUserId(Long seq,String userId);
}
