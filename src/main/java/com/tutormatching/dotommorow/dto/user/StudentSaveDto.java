package com.tutormatching.dotommorow.dto.user;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

// 학생 등록 정보를 받아오는 DTO
@Getter
@Setter
public class StudentSaveDto {
    private String userId;
    private Integer regionId;
    private String range;
    private LocalDateTime yail;
    private LocalDateTime time;
    private String category;
    private String classLevel;
    private String academic;

    public StudentSaveDto(String userId, Integer regionId, String range, LocalDateTime yail,
                          LocalDateTime time, String category, String classLevel, String academic) {
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
