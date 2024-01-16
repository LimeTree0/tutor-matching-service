package com.tutormatching.dotommorow.dto.lesson;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LessonSaveDto {
    private Integer classId;
    private Integer teacherId;
    private String category;
    private String location;
    private String description;
    private String ftf;
    private Integer peopleNumber;
}
