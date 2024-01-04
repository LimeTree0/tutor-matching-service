package com.tutormatching.dotommorow.controller.user;

import com.tutormatching.dotommorow.dto.user.*;
import com.tutormatching.dotommorow.service.user.StudentService;
import com.tutormatching.dotommorow.service.user.TeacherService;
import com.tutormatching.dotommorow.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;
    private final UserService userService;

    @GetMapping("/teacher")
    public String teacher() {
        UserDto userDto = new UserDto("test", 1L, "test", "W", 20, "test", "test", "test", null);
        TeacherSaveDto teacherSaveDto = new TeacherSaveDto("test", 1, null, null, "hello", null, "test", null);
        userService.save(userDto);
        teacherService.save(teacherSaveDto);

        teacherService.update("test", new TeacherUpdateDto(1, null, null, "update", null, null, null));
        TeacherDto test = teacherService.findById("test");
        log.info("test: {}", test.getComment());
        return "teacher 실행";
    }
}
