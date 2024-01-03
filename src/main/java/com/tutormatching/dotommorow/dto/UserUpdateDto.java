package com.tutormatching.dotommorow.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDto {

    @Setter(lombok.AccessLevel.NONE)
    private String userId;
    private Long regionId;
    private String gender;
    private Integer age;
    private String userName;
    private String profileImage;
    private String phoneNumber;

    public UserUpdateDto(String userId, Long regionId, String gender, Integer age, String userName, String profileImage, String phoneNumber) {
        this.userId = userId;
        this.regionId = regionId;
        this.gender = gender;
        this.age = age;
        this.userName = userName;
        this.profileImage = profileImage;
        this.phoneNumber = phoneNumber;
    }
}
