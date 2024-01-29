package com.tutormatching.dotommorow.dto.review;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReviewRequestDto {
    private Integer classId;
    private String review;
    private Integer grade;
}
