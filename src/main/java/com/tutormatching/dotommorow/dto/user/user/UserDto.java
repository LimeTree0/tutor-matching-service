package com.tutormatching.dotommorow.dto.user.user;

import com.tutormatching.dotommorow.dto.region.RegionDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

// 유저 조회 정보를 받아오는 DTO

@Getter
@Setter
@ToString
public class UserDto {
    private String userId;
    private Long regionId;
    private String password;
    private String gender;
    private Integer age;
    private String userName;
    private String profileImageName;
    private String phoneNumber;
    private LocalDateTime signUpDate;
    private RegionDto region;

    public UserDto(String userId, Long regionId, String password, String gender, Integer age,
                   String userName, String profileImageName, String phoneNumber, LocalDateTime signUpDate) {
        this.userId = userId;
        this.regionId = regionId;
        this.password = password;
        this.gender = gender;
        this.age = age;
        this.userName = userName;
        this.profileImageName = profileImageName;
        this.phoneNumber = phoneNumber;
        this.signUpDate = signUpDate;
    }
}