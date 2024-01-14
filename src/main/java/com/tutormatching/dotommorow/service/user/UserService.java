package com.tutormatching.dotommorow.service.user;

import com.tutormatching.dotommorow.dto.region.RegionDto;
import com.tutormatching.dotommorow.dto.user.UserDto;
import com.tutormatching.dotommorow.dto.user.UserJoinDto;
import com.tutormatching.dotommorow.dto.user.UserUpdateDto;
import com.tutormatching.dotommorow.repository.region.RegionRepository;
import com.tutormatching.dotommorow.repository.user.UserRepository;
import com.tutormatching.dotommorow.util.FileUploadUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * User에 대한 정보를 CRUD할 수 있는 서비스 클래스
 */

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final RegionRepository regionRepository;
    private final PasswordEncoder passwordEncoder;
    private final FileUploadUtil fileUploadUtil;

    // 회원 정보 등록
    public void save(UserJoinDto userJoinDto) {
        userJoinDto.setPassword(passwordEncoder.encode(userJoinDto.getPassword()));

        // 지역 Dto 생성
        RegionDto regionDto = new RegionDto();
        regionDto.setSi(userJoinDto.getSi());
        regionDto.setGun(userJoinDto.getGun());
        regionDto.setGu(userJoinDto.getGu());

        long savedRegionId = regionRepository.save(regionDto);
        UserDto userDto = userJoinDto.transferToUserDto(userJoinDto, savedRegionId);
        log.info("[UserService] userDto: {}", userDto);
        userRepository.save(userDto);
    }

    // 회원 정보 수정
    public void update(UserUpdateDto userUpdateDto, MultipartFile profileImage) {

        // 유저 지역 정보 수정
        UserDto userDto = userRepository.findById(userUpdateDto.getUserId());
        Long regionId = userDto.getRegionId();
        RegionDto regionDto = regionRepository.findById(regionId);
        regionDto.setSi(userUpdateDto.getSi());
        regionDto.setGun(userUpdateDto.getGun());
        regionDto.setGu(userUpdateDto.getGu());
        regionRepository.update(regionDto);

        // 유저 프로필 수정
        if (profileImage != null) {

            // 기존 프로필 이미지 삭제
            if (userUpdateDto.getProfileImageName() != null) {
                fileUploadUtil.deleteFile(userUpdateDto.getProfileImageName());
            }

            // 새로운 프로필 이미지 업로드
            String fileName = fileUploadUtil.uploadFile(profileImage);
            userUpdateDto.setProfileImageName(fileName);
        }

        // 유저 정보 수정
        userRepository.update(userUpdateDto);
    }

    // 회원 정보 모두 조회
    @Transactional(readOnly = true)
    public List<UserDto> findAll() {
        return userRepository.findAll();
    }

    // ID를 이용한 회원 정보 조회
    @Transactional(readOnly = true)
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
