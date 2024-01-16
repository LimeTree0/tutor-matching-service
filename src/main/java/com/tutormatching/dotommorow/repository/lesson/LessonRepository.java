package com.tutormatching.dotommorow.repository.lesson;

import com.tutormatching.dotommorow.dto.lesson.LessonConditionDto;
import com.tutormatching.dotommorow.dto.lesson.LessonDto;
import com.tutormatching.dotommorow.dto.lesson.LessonSaveDto;
import com.tutormatching.dotommorow.dto.lesson.LessonUpdateDto;
import com.tutormatching.dotommorow.repository.mapper.lesson.LessonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 강의 CRUD를 담당하는 레포지토리
 */
@Repository
@RequiredArgsConstructor
public class LessonRepository {

    private final LessonMapper lessonMapper;

    // 강의 등록
    public void save(LessonSaveDto lessonSaveDto) {
        lessonMapper.save(lessonSaveDto);
    }

    // 강의 아이디 기반 강의 조회
    public LessonDto findById(Integer classId) {
        return lessonMapper.findById(classId);
    }

    // 선생님 아이디 기반 강의 조회
    public List<LessonDto> findAllByTeacherId(Integer teacherId) {
        return lessonMapper.findAllByTeacherId(teacherId);
    }

    // 강의 검색
    public List<LessonDto> findAllByCondition(LessonConditionDto lessonConditionDto) {
        String category = lessonConditionDto.getCategory();
        String location = lessonConditionDto.getLocation();
        String ftf = lessonConditionDto.getFtf();
        return lessonMapper.findAllByCondition(category, location, ftf);
    }

    // 강의 수정
    public void update(LessonUpdateDto lessonUpdateDto) {
        lessonMapper.update(lessonUpdateDto);
    }

    // 강의 삭제
    public void delete(Integer classId) {
        lessonMapper.delete(classId);
    }
}
