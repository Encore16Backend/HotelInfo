package com.four.hotelinfo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Review_TBL")
public class Review implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long seq; //리뷰 번호 (리뷰 조회시 시간순서별 정렬 기준)
    @Column(nullable = false, updatable = false)
    private String userId; // 작성한 유저ID
    @Column(nullable = false, updatable = false)
    private Long hotelId; // 호텔 구분번호
    @Column(nullable = false)
    private String reviewContent; //리뷰 내용
    @Column(nullable = false)
    private int reviewScore; //리뷰 점수

    public Review(){
    }

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    @Override
    public String toString() {
        return "Review{" +
                "seq=" + seq +
                ", userId='" + userId + '\'' +
                ", hotelId=" + hotelId +
                ", reviewContent='" + reviewContent + '\'' +
                ", reviewScore=" + reviewScore +
                '}';
    }
}
