package com.tutormatching.dotommorow.controller.user;

import com.tutormatching.dotommorow.dto.user.student.StudentDto;
import com.tutormatching.dotommorow.dto.user.student.StudentSaveDto;
import com.tutormatching.dotommorow.dto.user.student.StudentUpdateDto;
import com.tutormatching.dotommorow.dto.user.user.UserDto;
import com.tutormatching.dotommorow.service.user.StudentService;
import com.tutormatching.dotommorow.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


/**
 * 학생 crud와 관련된 클래스
 */
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class StudentController {

    private final StudentService studentService;
    private final UserService userService;

    // 학생 정보 등록폼
    @GetMapping("/student")
    public String studentForm(Principal principal, Model model) {
        String userId = principal.getName();
        UserDto userDto = userService.findById(userId);
        Long regionId = userDto.getRegionId();

        StudentDto studentDto = studentService.findById(userId);

        boolean isExist = false;
        if (studentDto != null) {
            isExist = true;
            model.addAttribute("studentDto", studentDto);
            log.info("studentDto: {}", studentDto);
        } else {
            model.addAttribute("studentDto", new StudentDto());
        }

        model.addAttribute("isExist", isExist);
        model.addAttribute("userId", userId);
        model.addAttribute("regionId", regionId);
        return "user/studentForm";
    }

    // 학생 정보 등록
    @PostMapping("/student")
    public String studentJoin(@ModelAttribute StudentSaveDto studentDto) {
        log.info("studentJoinDto: {}", studentDto);
        studentService.save(studentDto);
        return "redirect:/";
    }

    // 학생 정보 수정
    @PutMapping("/student")
    @ResponseBody
    public HttpStatus studentUpdate(@RequestBody StudentUpdateDto studentUpdateDto) {
        log.info("studentUpdateDto: {}", studentUpdateDto);
        studentService.update(studentUpdateDto);
        return HttpStatus.OK;
    }

    // 학생 정보 삭제
    @DeleteMapping("/student/{userId}")
    @ResponseBody
    public HttpStatus studentDelete(@PathVariable("userId") String userId, Principal principal) {
        if (userId.equals(principal.getName())) {
            log.info("userId: {}", userId);
            studentService.delete(userId);
            return HttpStatus.OK;
        }
        return HttpStatus.BAD_REQUEST;
    }
}