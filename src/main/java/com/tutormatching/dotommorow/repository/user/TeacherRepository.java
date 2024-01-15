package com.tutormatching.dotommorow.repository.user;

import com.tutormatching.dotommorow.dto.user.teacher.TeacherDto;
import com.tutormatching.dotommorow.dto.user.teacher.TeacherSaveDto;
import com.tutormatching.dotommorow.dto.user.teacher.TeacherUpdateDto;
import com.tutormatching.dotommorow.dto.user.teacher.TeacherWithUserDto;
import com.tutormatching.dotommorow.repository.mapper.user.TeacherMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


/**
 * teacher에 대한 정보를 CRUD할 수 있는 Repository 클래스
 */
@Repository
@RequiredArgsConstructor
public class TeacherRepository {

    private final TeacherMapper teacherMapper;

    // 선생님 정보 등록
    public void save(TeacherSaveDto teacherSaveDto) {
        teacherMapper.save(teacherSaveDto.getUserId(), teacherSaveDto.getRegionId(), teacherSaveDto.getYail(),
                teacherSaveDto.getTime(), teacherSaveDto.getComment(), teacherSaveDto.getCategory(),
                teacherSaveDto.getClassLevel(), teacherSaveDto.getAcademic());
    }

    // ID를 이용한 선생님 정보 수정
    public void update(TeacherUpdateDto teacherUpdateDto) {
        teacherMapper.update(teacherUpdateDto.getUserId(), teacherUpdateDto.getRegionId(), teacherUpdateDto.getYail(),
                teacherUpdateDto.getTime(), teacherUpdateDto.getComment(), teacherUpdateDto.getCategory(),
                teacherUpdateDto.getClassLevel(), teacherUpdateDto.getAcademic());
    }

    // ID를 이용한 선생님 정보 조회
    public TeacherDto findById(String userId) {
        return teacherMapper.findById(userId);
    }

    // ID를 이용한 선생님 정보 삭제
    public void delete(String userId) {
        teacherMapper.delete(userId);
    }

    public TeacherWithUserDto selectByIdWithUser(String userId) {
        return teacherMapper.selectByIdWithUser(userId);
    }
}
