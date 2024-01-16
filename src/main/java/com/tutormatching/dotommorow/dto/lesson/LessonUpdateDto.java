package com.tutormatching.dotommorow.dto.lesson;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LessonUpdateDto {
    private Integer classId;
    private String description;
    private String ftf;
    private Integer peopleNumber;
}
