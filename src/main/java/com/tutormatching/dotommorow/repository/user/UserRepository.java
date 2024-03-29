package com.tutormatching.dotommorow.repository.user;

import com.tutormatching.dotommorow.dto.user.user.UserDetailsCustomDto;
import com.tutormatching.dotommorow.dto.user.user.UserDto;
import com.tutormatching.dotommorow.dto.user.user.UserUpdateDto;
import com.tutormatching.dotommorow.repository.mapper.user.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * User에 대한 정보를 CRUD할 수 있는 Repository 클래스
 */
@Repository
@RequiredArgsConstructor
@Slf4j
public class UserRepository {

    private final UserMapper userMapper;

    // 회원 정보 등록
    public void save(UserDto userDto) {

        userMapper.save(userDto.getUserId(), userDto.getRegionId(), userDto.getPassword(), userDto.getGender()
                , userDto.getAge(), userDto.getUserName(), userDto.getProfileImageName(), userDto.getPhoneNumber()
                , userDto.getSignUpDate());
    }

    // ID를 이용한 회원 정보 수정
    public void update(UserUpdateDto userUpdateDto) {
        userMapper.update(userUpdateDto.getUserId(), userUpdateDto.getGender()
                , userUpdateDto.getAge(), userUpdateDto.getUserName(), userUpdateDto.getProfileImageName(),
                userUpdateDto.getPhoneNumber());
    }

    // 회원 정보 모두 조회
    public List<UserDto> findAll() {
        return userMapper.findAll();
    }

    // ID를 이용한 회원 정보 조회
    public UserDto findById(String userId) {
        return userMapper.findById(userId);
    }

    // 로그인 시 필요한 회원 정보 조회
    public UserDetailsCustomDto findByUserIdWithUserDetailCustomDto(String userId) {
        UserDetailsCustomDto customDto = userMapper.findByIdWithUserDetailsCustomDto(userId);
        log.info("[UserRepository] customDto: {}", customDto);
        return customDto;
    }

    // ID를 이용한 회원 정보 삭제
    public void delete(String userId) {
        userMapper.delete(userId);
    }


}
