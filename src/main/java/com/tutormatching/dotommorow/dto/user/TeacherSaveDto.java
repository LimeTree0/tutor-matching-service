package com.tutormatching.dotommorow.dto.user;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

// 선생님 등록 정보를 받아오는 DTO

@Getter
@Setter
public class TeacherSaveDto {
    private String userId;
    private Integer regionId;
    private LocalDateTime yail;
    private LocalDateTime time;
    private String comment;
    private String category;
    private String classLevel;
    private String academic;

    public TeacherSaveDto(String userId, Integer regionId,
                          LocalDateTime yail, LocalDateTime time, String comment,
                          String category, String classLevel, String academic) {

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
