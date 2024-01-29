package com.tutormatching.dotommorow.controller.lesson;

import com.tutormatching.dotommorow.dto.lesson.LessonConditionDto;
import com.tutormatching.dotommorow.dto.lesson.LessonDto;
import com.tutormatching.dotommorow.dto.lesson.LessonSaveDto;
import com.tutormatching.dotommorow.dto.lesson.LessonUpdateDto;
import com.tutormatching.dotommorow.dto.review.ReviewResponseDto;
import com.tutormatching.dotommorow.dto.user.teacher.TeacherDto;
import com.tutormatching.dotommorow.service.lesson.LessonService;
import com.tutormatching.dotommorow.service.review.ReviewService;
import com.tutormatching.dotommorow.service.user.TeacherService;
import com.tutormatching.dotommorow.util.FileUploadUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * 강의 CRUD를 담당하는 컨트롤러
 */
@Controller
@RequiredArgsConstructor
@Slf4j
public class LessonController {

    private final LessonService lessonService;
    private final TeacherService teacherService;
    private final FileUploadUtil fileUploadUtil;
    private final ReviewService reviewService;

    // 강의 등록 페이지 폼
    @GetMapping("/lesson/lessonForm")
    public String lessonForm(Principal principal, Model model) {
        String userId = principal.getName();
        TeacherDto teacherDto = teacherService.findById(userId);

        if (teacherDto == null) {
            return "redirect:/";
        }

        List<LessonDto> lessonDtoList = lessonService.findAllByTeacherId(teacherDto.getTeacherId());
        model.addAttribute("teacherId", teacherDto.getTeacherId());
        return "lesson/lessonForm";
    }

    // 강의 등록
    @PostMapping("/lesson")
    public String lessonRegistration(@ModelAttribute LessonSaveDto lessonDto) {
        log.info("lessonDto: {}", lessonDto);
        lessonService.save(lessonDto);
        return "redirect:/";
    }

    // 강의 수정 페이지 폼
    @GetMapping("/lesson/detail/correction/{classId}")
    public String lessonCorrection(@PathVariable("classId") Integer classId, Model model) {
        LessonDto lessonDto = lessonService.findById(classId);
        model.addAttribute("lessonDto", lessonDto);
        return "lesson/lessonCorrectionForm";
    }

    // 강의 상세 페이지 폼
    @GetMapping("/lesson/detail/{classId}")
    public String lessonDetail(@PathVariable("classId") Integer classId,
                               Model model, Principal principal) {
        LessonDto lessonDto = lessonService.findById(classId);
        List<ReviewResponseDto> reviewDtoList = reviewService.findByClassId(classId);
        model.addAttribute("lessonDto", lessonDto);
        model.addAttribute("reviewDtoList", reviewDtoList);
        model.addAttribute("currentUserId", principal.getName());


        return "lesson/lessonDetailForm";
    }

    // 강의 수정
    @PutMapping("/lesson/detail/correction")
    @ResponseBody
    public HttpStatus lessonUpdate(@RequestBody LessonUpdateDto lessonUpdateDto) {
        lessonService.update(lessonUpdateDto);
        return HttpStatus.OK;
    }

    // 강의 삭제
    @DeleteMapping("/lesson/detail/correction/{classId}")
    @ResponseBody
    public HttpStatus lessonDelete(@PathVariable("classId") Integer classId) {
        lessonService.delete(classId);
        return HttpStatus.OK;
    }

    // 강의 목록 페이지 폼
    @GetMapping("/lesson/lessonList")
    public String lessonList(@ModelAttribute LessonConditionDto lessonConditionDto, Model model) {

        log.info("lessonConditionDto: {}", lessonConditionDto);

        List<LessonDto> lessonDtoList = lessonService.findAllByCondition(lessonConditionDto);
        lessonDtoList.forEach(lessonDto -> {
            String fullPath = fileUploadUtil.getFullPath(lessonDto.getUserProfileImageName());
            lessonDto.setFilePath(fullPath);
        });
        log.info("lessonConditionDto lessonDtoList: {}", lessonDtoList.size());
        model.addAttribute("lessonDtoList", lessonDtoList);
        return "index";
    }


}
