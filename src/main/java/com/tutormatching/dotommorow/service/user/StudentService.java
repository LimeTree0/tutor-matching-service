package com.tutormatching.dotommorow.service.user;

import com.tutormatching.dotommorow.dto.user.student.StudentDto;
import com.tutormatching.dotommorow.dto.user.student.StudentSaveDto;
import com.tutormatching.dotommorow.dto.user.student.StudentUpdateDto;
import com.tutormatching.dotommorow.repository.user.StudentRepository;
import com.tutormatching.dotommorow.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * student에 대한 정보를 CRUD할 수 있는 서비스 클래스
 */

@Service
@RequiredArgsConstructor
public class StudentService {

    private final UserRepository userRepository;
    private final StudentRepository studentRepository;

    // 학생 정보 등록
    public void save(StudentSaveDto studentSaveDto) {

        studentRepository.save(studentSaveDto);

    }

    // 학생 정보 수정
    public void update(StudentUpdateDto studentUpdateDto) {

        studentRepository.update(studentUpdateDto);
    }

    // ID를 이용한 학생 정보 조회
    public StudentDto findById(String userId) {
        return studentRepository.findById(userId);
    }

    // ID를 이용한 학생 정보 삭제
    public void delete(String userId) {
        studentRepository.delete(userId);
    }

}
