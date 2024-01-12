package com.tutormatching.dotommorow.dto.user;

import com.tutormatching.dotommorow.dto.region.RegionDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 유저 수정 정보를 받아오는 DTO

@Getter
@Setter
@ToString
public class UserUpdateDto {

    private String userId;
    private String si;
    private String gun;
    private String gu;
    private String gender;
    private Integer age;
    private String userName;
    private String profileImage;
    private String phoneNumber;
}
