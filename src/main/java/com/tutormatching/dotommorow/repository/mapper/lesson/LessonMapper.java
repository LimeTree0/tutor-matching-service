package com.tutormatching.dotommorow.repository.mapper.lesson;

import com.tutormatching.dotommorow.dto.lesson.LessonConditionDto;
import com.tutormatching.dotommorow.dto.lesson.LessonDto;
import com.tutormatching.dotommorow.dto.lesson.LessonSaveDto;
import com.tutormatching.dotommorow.dto.lesson.LessonUpdateDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LessonMapper {

    // 강의 등록
    void save(LessonSaveDto lessonSaveDto);

    // 강의 아이디 기반 강의 조회
    LessonDto findById(Integer classId);

    // 선생님 아이디 기반 강의 조회
    List<LessonDto> findAllByTeacherId(Integer teacherId);

    // 강의 검색
    List<LessonDto> findAllByCondition(@Param("category") String category, @Param("location") String location, @Param("ftf") String ftf);

    // 강의 수정
    void update(LessonUpdateDto lessonUpdateDto);

    // 강의 삭제
    void delete(Integer classId);

}
