package com.tutormatching.dotommorow.dto.user.student;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

// 학생 정보를 받아오는 DTO
@Getter
@Setter
@ToString
public class StudentUpdateDto {

    private String userId;
    private Integer regionId;
    private String range;
    private String yail;
    private LocalTime time;
    @Setter(AccessLevel.NONE)
    private String category;
    private String classLevel;
    private String academic;

    public void setCategory(List<String> category) {
        this.category = String.join(", ", category);
    }
}
