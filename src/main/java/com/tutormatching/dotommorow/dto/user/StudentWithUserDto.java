package com.tutormatching.dotommorow.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


// 학생 조회 정보를 받아오는 DTO
@Getter
@Setter
public class StudentWithUserDto {
    private Integer studentId;
    private Integer regionId;
    private String range;
    private LocalDateTime yail;
    private LocalDateTime time;
    private String category;
    private String classLevel;
    private String academic;
    private UserDto userDto;
}
