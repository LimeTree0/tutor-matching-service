package com.tutormatching.dotommorow.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TeacherDto {
    private Integer teacherId;
    private String userId;
    private Integer regionId;
    private LocalDateTime yail;
    private LocalDateTime time;
    private String comment;
    private String category;
    private String classLevel;
    private String academic;

    public TeacherDto(Integer teacherId, String userId, Integer regionId,
                      LocalDateTime yail, LocalDateTime time, String comment,
                      String category, String classLevel, String academic) {
        this.teacherId = teacherId;
        this.userId = userId;
        this.regionId = regionId;
        this.yail = yail;
        this.time = time;
        this.comment = comment;
        this.category = category;
        this.classLevel = classLevel;
        this.academic = academic;
    }
}
