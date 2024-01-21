package com.tutormatching.dotommorow.dto.order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderDto {

        private Integer orderId;
        private Integer classId;
        private Integer studentId;
        private Integer teacherId;
        private String firstDate;
        private String progress;
        private String lessonDate;
        private String lessonName;
}
