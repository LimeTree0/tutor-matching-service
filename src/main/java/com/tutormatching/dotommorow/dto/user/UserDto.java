package com.tutormatching.dotommorow.dto.user;

import com.tutormatching.dotommorow.dto.region.RegionDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

// 유저 조회 정보를 받아오는 DTO

@Getter
@Setter
public class UserDto {
    private String userId;
    private Long regionId;
    private String password;
    private String gender;
    private Integer age;
    private String userName;
    private String profileImage;
    private String phoneNumber;
    private LocalDateTime signUpDate;
    private RegionDto region;

    public UserDto(String userId, Long regionId, String password, String gender, Integer age,
                   String userName, String profileImage, String phoneNumber, LocalDateTime signUpDate) {
        this.userId = userId;
        this.regionId = regionId;
        this.password = password;
        this.gender = gender;
        this.age = age;
        this.userName = userName;
        this.profileImage = profileImage;
        this.phoneNumber = phoneNumber;
        this.signUpDate = signUpDate;
    }
}