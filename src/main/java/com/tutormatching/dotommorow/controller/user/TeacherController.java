package com.tutormatching.dotommorow.controller.user;

import com.tutormatching.dotommorow.dto.user.teacher.TeacherDto;
import com.tutormatching.dotommorow.dto.user.teacher.TeacherSaveDto;
import com.tutormatching.dotommorow.dto.user.teacher.TeacherUpdateDto;
import com.tutormatching.dotommorow.dto.user.user.UserDto;
import com.tutormatching.dotommorow.service.user.TeacherService;
import com.tutormatching.dotommorow.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class TeacherController {

    private final TeacherService teacherService;
    private final UserService userService;

    @GetMapping("/teacher")
    public String teacherForm(Principal principal, Model model) {
        String userId = principal.getName();
        UserDto userDto = userService.findById(userId);
        Long regionId = userDto.getRegionId();

        TeacherDto teacherDto = teacherService.findById(userId);

        boolean isExist = false;
        if (teacherDto != null) {
            isExist = true;
            model.addAttribute("teacherDto", teacherDto);
            log.info("teacherDto: {}", teacherDto);
        } else {
            model.addAttribute("teacherDto", new TeacherDto());
        }

        model.addAttribute("isExist", isExist);
        model.addAttribute("userId", userId);
        model.addAttribute("regionId", regionId);
        return "user/teacherForm";
    }

    // 학생 정보 등록
    @PostMapping("/teacher")
    public String teacherJoin(@ModelAttribute TeacherSaveDto teacherDto) {
        log.info("teacherJoinDto: {}", teacherDto);
        teacherService.save(teacherDto);
        return "redirect:/";
    }

    // 학생 정보 수정
    @PutMapping("/teacher")
    @ResponseBody
    public HttpStatus teacherUpdate(@RequestBody TeacherUpdateDto teacherUpdateDto) {
        log.info("teacherUpdateDto: {}", teacherUpdateDto);
        teacherService.update(teacherUpdateDto);
        return HttpStatus.OK;
    }

    // 학생 정보 삭제
    @DeleteMapping("/teacher/{userId}")
    @ResponseBody
    public HttpStatus teacherDelete(@PathVariable("userId") String userId, Principal principal) {
        if (userId.equals(principal.getName())) {
            log.info("userId: {}", userId);
            teacherService.delete(userId);
            return HttpStatus.OK;
        }
        return HttpStatus.BAD_REQUEST;
    }
}
