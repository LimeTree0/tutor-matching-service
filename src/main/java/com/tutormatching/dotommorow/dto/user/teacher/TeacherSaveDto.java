package com.tutormatching.dotommorow.dto.user.teacher;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalTime;
import java.util.List;

// 선생님 등록 정보를 받아오는 DTO

@Getter
@Setter
@ToString
public class TeacherSaveDto {
    private String userId;
    private Integer regionId;
    private String yail;
    private LocalTime time;
    private String comment;
    private String classLevel;
    @Setter(AccessLevel.NONE)
    private String category;
    private String academic;

    public void setCategory(List<String> category) {
        this.category = String.join(", ", category);
    }
}
