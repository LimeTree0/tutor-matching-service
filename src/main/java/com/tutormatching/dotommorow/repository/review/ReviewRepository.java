package com.tutormatching.dotommorow.repository.review;

import com.tutormatching.dotommorow.dto.review.ReviewDto;
import com.tutormatching.dotommorow.dto.review.ReviewResponseDto;
import com.tutormatching.dotommorow.repository.mapper.review.ReviewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewRepository {

    private final ReviewMapper reviewMapper;

    // 리뷰 등록
    public void save(ReviewDto reviewDto) {
        reviewMapper.save(reviewDto);
    }

    // 강의 아이디 기반 리뷰 조회
    public List<ReviewResponseDto> findByClassId(Integer classId) {
        return reviewMapper.findByClassId(classId);
    }

    // 리뷰 삭제
    public void deleteByReviewId(Integer reviewId) {
        reviewMapper.deleteByReviewId(reviewId);
    }

}
