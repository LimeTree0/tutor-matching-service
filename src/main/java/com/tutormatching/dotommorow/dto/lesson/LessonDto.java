package com.tutormatching.dotommorow.dto.lesson;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LessonDto {
    private Integer classId;
    private Integer teacherId;
    private String teacherName;
    private String userProfileImageName;
    private String filePath;
    private String category;
    private String location;
    private String description;
    private String ftf;
    private Integer peopleNumber;
}

