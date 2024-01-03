package com.tutormatching.dotommorow.repository;

import com.tutormatching.dotommorow.dto.UserDto;
import com.tutormatching.dotommorow.dto.UserUpdateDto;
import com.tutormatching.dotommorow.repository.mapper.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final UserMapper userMapper;

    public void save(UserDto userDto) {

        userMapper.save(userDto.getUserId(), userDto.getRegionId(), userDto.getPassword(), userDto.getGender()
                , userDto.getAge(), userDto.getUserName(), userDto.getProfileImage(), userDto.getPhoneNumber()
                , userDto.getSignUpDate());
    }

    public void update(UserUpdateDto userUpdateDto) {
        userMapper.update(userUpdateDto.getUserId(), userUpdateDto.getRegionId(), userUpdateDto.getGender()
                , userUpdateDto.getAge(), userUpdateDto.getUserName(), userUpdateDto.getProfileImage(),
                userUpdateDto.getPhoneNumber());
    }

    public List<UserDto> findAll() {
        return userMapper.findAll();
    }

    public UserDto findById(String userId) {
        return userMapper.findById(userId);
    }

    public void delete(String userId) {
        userMapper.delete(userId);
    }
}
