package com.tutormatching.dotommorow.service.user;

import com.tutormatching.dotommorow.dto.user.UserDto;
import com.tutormatching.dotommorow.dto.user.UserJoinDto;
import com.tutormatching.dotommorow.dto.user.UserUpdateDto;
import com.tutormatching.dotommorow.repository.region.RegionRepository;
import com.tutormatching.dotommorow.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User에 대한 정보를 CRUD할 수 있는 서비스 클래스
 */

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RegionRepository regionRepository;

    // 회원 정보 등록
    public void save(UserJoinDto userJoinDto) {
        long savedRegionId = regionRepository.save(userJoinDto.getSi(), userJoinDto.getGun(), userJoinDto.getGu());
        UserDto userDto = userJoinDto.transferToUserDto(userJoinDto, savedRegionId);
        userRepository.save(userDto);
    }

    // 회원 정보 수정
    public void update(String userId, UserUpdateDto userUpdateDto) {
        userRepository.update(userId, userUpdateDto);
    }

    // 회원 정보 모두 조회
    public List<UserDto> findAll() {
        return userRepository.findAll();
    }

    // ID를 이용한 회원 정보 조회
    public UserDto findById(String userId) {
        return userRepository.findById(userId);
    }

    // ID를 이용한 회원 정보 삭제
    public void delete(String userId) {
        userRepository.delete(userId);
    }

}
