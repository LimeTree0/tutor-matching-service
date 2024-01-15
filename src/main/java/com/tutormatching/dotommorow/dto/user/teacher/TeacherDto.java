package com.tutormatching.dotommorow.dto.user.teacher;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

// 선생님 조회 정보를 받아오는 DTO

@Getter
@Setter
@ToString
public class TeacherDto {
    private Integer teacherId;
    private String userId;
    private Integer regionId;
    private String yail;
    private LocalTime time;
    private String comment;
    @Setter(AccessLevel.NONE)
    private String category;
    private String classLevel;
    private String academic;
}
