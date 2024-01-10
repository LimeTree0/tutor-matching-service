package com.tutormatching.dotommorow.dto.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class UserJoinDto {
    private String userId;
    private String si;
    private String gun;
    private String gu;
    private String password;
    private String gender;
    private Integer age;
    private String userName;
    private String profileImage;
    private String phoneNumber;

    public UserDto transferToUserDto(UserJoinDto userJoinDto, long savedRegionId) {
        return new UserDto(userJoinDto.getUserId(), savedRegionId, userJoinDto.getPassword(), userJoinDto.getGender()
                , userJoinDto.getAge(), userJoinDto.getUserName(), userJoinDto.getProfileImage(), userJoinDto.getPhoneNumber()
                , LocalDateTime.now());
    }
}
