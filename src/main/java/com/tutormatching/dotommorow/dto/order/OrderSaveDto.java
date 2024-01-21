package com.tutormatching.dotommorow.dto.order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class OrderSaveDto {

    private Integer classId;
    private Integer studentId;
    private Integer teacherId;
    private LocalDateTime firstDate;
    private String progress;
    private String lessonDate;
    private String lessonName;
    private Integer price;

}