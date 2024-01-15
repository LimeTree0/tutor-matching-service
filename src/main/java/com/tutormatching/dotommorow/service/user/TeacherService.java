package com.tutormatching.dotommorow.service.user;

import com.tutormatching.dotommorow.dto.user.teacher.TeacherDto;
import com.tutormatching.dotommorow.dto.user.teacher.TeacherSaveDto;
import com.tutormatching.dotommorow.dto.user.teacher.TeacherUpdateDto;
import com.tutormatching.dotommorow.dto.user.teacher.TeacherWithUserDto;
import com.tutormatching.dotommorow.repository.user.TeacherRepository;
import com.tutormatching.dotommorow.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * student에 대한 정보를 CRUD할 수 있는 서비스 클래스
 */

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final UserRepository userRepository;
    private final TeacherRepository teacherRepository;

    // 선생님 정보 등록
    public void save(TeacherSaveDto teacherSaveDto) {

        teacherRepository.save(teacherSaveDto);

    }

    // 선생님 정보 수정
    public void update(TeacherUpdateDto teacherUpdateDto) {

        teacherRepository.update(teacherUpdateDto);
    }

    // ID를 이용한 선생님 정보 조회
    public TeacherDto findById(String userId) {
        return teacherRepository.findById(userId);
    }

    // ID를 이용한 선생님 정보 삭제
    public void delete(String userId) {
        teacherRepository.delete(userId);
    }


    // 선생님 정보와 선생님 가입 정보를 같이 조회
    public TeacherWithUserDto selectByIdWithUser(String userId) {
        return teacherRepository.selectByIdWithUser(userId);
    }

}
