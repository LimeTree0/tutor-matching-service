package com.tutormatching.dotommorow.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class StudentDto {
    private Integer studentId;
    private String userId;
    private Integer regionId;
    private String range;
    private LocalDateTime yail;
    private LocalDateTime time;
    private String category;
    private String classLevel;
    private String academic;

    public StudentDto(Integer studentId, String userId, Integer regionId,
                      String range, LocalDateTime yail, LocalDateTime time,
                      String category, String classLevel, String academic) {
        this.studentId = studentId;
        this.userId = userId;
        this.regionId = regionId;
        this.range = range;
        this.yail = yail;
        this.time = time;
        this.category = category;
        this.classLevel = classLevel;
        this.academic = academic;
    }
}
