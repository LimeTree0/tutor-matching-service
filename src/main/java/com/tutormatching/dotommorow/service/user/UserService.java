package com.tutormatching.dotommorow.service.user;

import com.tutormatching.dotommorow.dto.region.RegionDto;
import com.tutormatching.dotommorow.dto.user.UserDto;
import com.tutormatching.dotommorow.dto.user.UserJoinDto;
import com.tutormatching.dotommorow.dto.user.UserUpdateDto;
import com.tutormatching.dotommorow.repository.region.RegionRepository;
import com.tutormatching.dotommorow.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User에 대한 정보를 CRUD할 수 있는 서비스 클래스
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RegionRepository regionRepository;
    private final PasswordEncoder passwordEncoder;

    // 회원 정보 등록
    public void save(UserJoinDto userJoinDto) {
        userJoinDto.setPassword(passwordEncoder.encode(userJoinDto.getPassword()));
        long savedRegionId = regionRepository.save(userJoinDto.getSi(), userJoinDto.getGun(), userJoinDto.getGu());
        UserDto userDto = userJoinDto.transferToUserDto(userJoinDto, savedRegionId);
        log.info("[UserService] userDto: {}", userDto);
        userRepository.save(userDto);
    }

    // 회원 정보 수정
    public void update(UserUpdateDto userUpdateDto) {
        UserDto userDto = userRepository.findById(userUpdateDto.getUserId());
        Long regionId = userDto.getRegionId();
        RegionDto regionDto = regionRepository.findById(regionId);
        regionDto.setSi(userUpdateDto.getSi());
        regionDto.setGun(userUpdateDto.getGun());
        regionDto.setGu(userUpdateDto.getGu());
        regionRepository.update(regionDto);
        userRepository.update(userUpdateDto);
    }

    // 회원 정보 모두 조회
    public List<UserDto> findAll() {
        return userRepository.findAll();
    }

    // ID를 이용한 회원 정보 조회
    public UserDto findById(String userId) {
        UserDto userDto = userRepository.findById(userId);
        RegionDto regionDto = regionRepository.findById(userDto.getRegionId());
        userDto.setRegion(regionDto);
        return userDto;
    }

    // ID를 이용한 회원 정보 삭제
    public void delete(String userId) {
        userRepository.delete(userId);
    }

}
