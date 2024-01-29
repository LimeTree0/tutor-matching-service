package com.tutormatching.dotommorow.service.review;

import com.tutormatching.dotommorow.dto.review.ReviewDto;
import com.tutormatching.dotommorow.dto.review.ReviewResponseDto;
import com.tutormatching.dotommorow.repository.review.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    // 리뷰 등록
    public void save(ReviewDto reviewDto) {
        reviewRepository.save(reviewDto);
    }

    public List<ReviewResponseDto> findByClassId(Integer classId) {
        return reviewRepository.findByClassId(classId);
    }

    public void deleteByReviewId(Integer reviewId) {
        reviewRepository.deleteByReviewId(reviewId);
    }

}
