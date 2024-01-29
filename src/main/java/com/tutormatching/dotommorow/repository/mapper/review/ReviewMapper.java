package com.tutormatching.dotommorow.repository.mapper.review;

import com.tutormatching.dotommorow.dto.review.ReviewDto;
import com.tutormatching.dotommorow.dto.review.ReviewResponseDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jdbc.repository.query.Query;

import java.util.List;

@Mapper
public interface ReviewMapper {

    // 리뷰 등록
    public void save(ReviewDto reviewDto);

    // 리뷰 조회
    public List<ReviewResponseDto> findByClassId(Integer classId);

    // 리뷰 삭제
    public void deleteByReviewId(Integer reviewId);
}
