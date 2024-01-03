package com.tutormatching.dotommorow.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDto {

    private Long regionId;
    private String gender;
    private Integer age;
    private String userName;
    private String profileImage;
    private String phoneNumber;

    public UserUpdateDto(Long regionId, String gender, Integer age, String userName, String profileImage, String phoneNumber) {
        this.regionId = regionId;
        this.gender = gender;
        this.age = age;
        this.userName = userName;
        this.profileImage = profileImage;
        this.phoneNumber = phoneNumber;
    }
}
