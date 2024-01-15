package com.tutormatching.dotommorow.dto.user.student;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.LocalTime;


// 학생 조회 정보를 받아오는 DTO
@Getter
@Setter
@ToString
public class StudentDto {
    private Integer studentId;
    private String userId;
    private Integer regionId;
    private String range;
    private String yail;
    private LocalTime time;
    private String category;
    private String classLevel;
    private String academic;
}
