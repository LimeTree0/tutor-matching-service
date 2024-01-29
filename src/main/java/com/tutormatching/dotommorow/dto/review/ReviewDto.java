package com.tutormatching.dotommorow.dto.review;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class ReviewDto {
    private Integer reviewId;
    private Integer studentId;
    private Integer classId;
    private String review;
    private Integer grade;
    private LocalDateTime reviewDate;

    public void setReviewRequestDto( ReviewRequestDto reviewRequestDto) {
        this.classId = reviewRequestDto.getClassId();
        this.review = reviewRequestDto.getReview();
        this.grade = reviewRequestDto.getGrade();
    }
}
