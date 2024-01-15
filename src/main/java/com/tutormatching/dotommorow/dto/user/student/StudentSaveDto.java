package com.tutormatching.dotommorow.dto.user.student;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.list;

// 학생 등록 정보를 받아오는 DTO
@Getter
@Setter
@ToString
public class StudentSaveDto {
    private String userId;
    private Integer regionId;
    private String range;
    private String yail;
    private LocalTime time;
    private String category;
    private String classLevel;
    private String academic;

    public void setCategory(List<String> category) {
        this.category = listToString(category);
    }

    public String listToString(List<String> categories) {
        return String.join(", ", categories);
    }
}
