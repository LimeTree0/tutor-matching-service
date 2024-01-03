package com.tutormatching.dotommorow.service;

import com.tutormatching.dotommorow.dto.UserDto;
import com.tutormatching.dotommorow.dto.UserUpdateDto;
import com.tutormatching.dotommorow.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void save(UserDto userDto) {
        userRepository.save(userDto);
    }

    public void update(UserUpdateDto userUpdateDto) {
        userRepository.update(userUpdateDto);
    }

    public List<UserDto> findAll() {
        return userRepository.findAll();
    }

    public UserDto findById(String userId) {
        return userRepository.findById(userId);
    }

    public void delete(String userId) {
        userRepository.delete(userId);
    }

}
