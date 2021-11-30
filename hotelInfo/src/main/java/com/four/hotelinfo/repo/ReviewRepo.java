package com.four.hotelinfo.repo;

import com.four.hotelinfo.model.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ReviewRepo extends JpaRepository<Review, Long> {

    // 1개 조회 - seq
    Optional<Review> findBySeq(Long seq);

    // 1개 조회 - userId
    Review findByUserId(String UserId);

    // 1개 조회 - seq, userId
    Optional<Review> findBySeqAndUserId(Long seq,String userId);

    // 전체 조회 - userId
    // List<Review> findAllByUserId(String userId);
    Page<Review> findAllByUserId(String userId, Pageable pageable);

    // 전체 조회 - hotelId - paging
    Page<Review> findAllByHotelId(Long hotelId, Pageable pageable);

    // 리뷰 삭제 - seq, userId
    @Transactional
    void deleteReviewBySeqAndUserId(Long seq,String userId);
}
