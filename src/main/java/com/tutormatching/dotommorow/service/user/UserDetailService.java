package com.tutormatching.dotommorow.service.user;

import com.tutormatching.dotommorow.dto.user.UserDetailsCustomDto;
import com.tutormatching.dotommorow.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 로그인 시 필요한 유저 정보를 조회하는 클래스
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        UserDetailsCustomDto dto = userRepository.findByUserIdWithUserDetailCustomDto(userId);
        log.info("[UserDetailService] dto: {}", dto);
        return userRepository.findByUserIdWithUserDetailCustomDto(userId);
    }
}
