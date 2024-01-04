package com.tutormatching.dotommorow.dto.user;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

// 선생님 수정 정보를 받아오는 DTO

@Getter
@Setter
public class TeacherUpdateDto {

    private Integer regionId;
    private LocalDateTime yail;
    private LocalDateTime time;
    private String comment;
    private String category;
    private String classLevel;
    private String academic;

    public TeacherUpdateDto(Integer regionId,
                            LocalDateTime yail, LocalDateTime time, String comment,
                            String category, String classLevel, String academic) {

        this.regionId = regionId;
        this.yail = yail;
        this.time = time;
        this.comment = comment;
        this.category = category;
        this.classLevel = classLevel;
        this.academic = academic;
    }
}
