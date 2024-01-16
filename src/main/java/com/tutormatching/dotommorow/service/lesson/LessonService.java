package com.tutormatching.dotommorow.service.lesson;

import com.tutormatching.dotommorow.dto.lesson.LessonConditionDto;
import com.tutormatching.dotommorow.dto.lesson.LessonDto;
import com.tutormatching.dotommorow.dto.lesson.LessonSaveDto;
import com.tutormatching.dotommorow.dto.lesson.LessonUpdateDto;
import com.tutormatching.dotommorow.repository.lesson.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonService {

    private final LessonRepository lessonRepository;

    // 강의 등록
    public void save(LessonSaveDto lessonSaveDto) {
        lessonRepository.save(lessonSaveDto);
    }

    // 강의 아이디 기반 강의 조회
    public LessonDto findById(Integer classId) {
        return lessonRepository.findById(classId);
    }

    // 선생님 아이디 기반 강의 조회
    public List<LessonDto> findAllByTeacherId(Integer teacherId) {
        return lessonRepository.findAllByTeacherId(teacherId);
    }

    // 강의 검색
    public List<LessonDto> findAllByCondition(LessonConditionDto lessonConditionDto) {
        return lessonRepository.findAllByCondition(lessonConditionDto);
    }

    // 강의 수정
    public void update(LessonUpdateDto lessonUpdateDto) {
        lessonRepository.update(lessonUpdateDto);
    }

    // 강의 삭제
    public void delete(Integer classId) {
        lessonRepository.delete(classId);
    }
}
