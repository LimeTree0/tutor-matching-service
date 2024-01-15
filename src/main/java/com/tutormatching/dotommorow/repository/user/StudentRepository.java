package com.tutormatching.dotommorow.repository.user;

import com.tutormatching.dotommorow.dto.user.*;
import com.tutormatching.dotommorow.repository.mapper.user.StudentMapper;
import com.tutormatching.dotommorow.repository.mapper.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * student에 대한 정보를 CRUD할 수 있는 Repository 클래스
 */
@Repository
@RequiredArgsConstructor
public class StudentRepository {

    private final StudentMapper studentMapper;

    // 학생 정보 등록
    public void save(StudentSaveDto studentSaveDto) {
        studentMapper.save(studentSaveDto.getUserId(), studentSaveDto.getRegionId(), studentSaveDto.getRange(),
                studentSaveDto.getYail(), studentSaveDto.getTime(), studentSaveDto.getCategory(), studentSaveDto.getClassLevel(),
                studentSaveDto.getAcademic());
    }

    // ID를 이용한 학생 정보 수정
    public void update(StudentUpdateDto studentUpdateDto) {
        studentMapper.update(studentUpdateDto.getUserId(), studentUpdateDto.getRegionId(), studentUpdateDto.getRange()
                , studentUpdateDto.getYail(), studentUpdateDto.getTime(), studentUpdateDto.getCategory(),
                studentUpdateDto.getClassLevel(), studentUpdateDto.getAcademic());
    }

    // ID를 이용한 학생 정보 조회
    public StudentDto findById(String userId) {
        return studentMapper.findById(userId);
    }

    // ID를 이용한 학생 정보 삭제
    public void delete(String userId) {
        studentMapper.delete(userId);
    }

    public StudentWithUserDto selectByIdWithUser(String userId) {
        return studentMapper.selectByIdWithUser(userId);
    }
}
