package com.tutormatching.dotommorow.dto.user.teacher;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

// 선생님 수정 정보를 받아오는 DTO

@Getter
@Setter
public class TeacherUpdateDto {
    private Integer teacherId;
    private String userId;
    private Integer regionId;
    private String range;
    private String yail;
    private LocalTime time;
    private String comment;
    @Setter(AccessLevel.NONE)
    private String category;
    private String classLevel;
    private String academic;

    public void setCategory(List<String> category) {
        this.category = String.join(", ", category);
    }
}

