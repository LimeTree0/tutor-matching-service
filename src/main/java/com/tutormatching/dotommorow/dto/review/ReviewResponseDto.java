package com.tutormatching.dotommorow.dto.review;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class ReviewResponseDto {
    private Integer reviewId;
    private Integer studentId;
    private String userId;
    private Integer classId;
    private String review;
    private Integer grade;
    private LocalDateTime reviewDate;
}
