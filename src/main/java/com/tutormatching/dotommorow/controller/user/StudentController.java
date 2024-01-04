package com.tutormatching.dotommorow.controller.user;

import com.tutormatching.dotommorow.dto.user.StudentDto;
import com.tutormatching.dotommorow.dto.user.StudentSaveDto;
import com.tutormatching.dotommorow.dto.user.StudentUpdateDto;
import com.tutormatching.dotommorow.dto.user.UserDto;
import com.tutormatching.dotommorow.service.user.StudentService;
import com.tutormatching.dotommorow.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final UserService userService;

    @GetMapping("/student")
    public String student() {
        UserDto userDto = new UserDto("test", 1L, "test", "W", 20, "test", "test", "test", null);
        StudentSaveDto studentSaveDto = new StudentSaveDto("test", 1, "test", null, null, null, "test", null);
        userService.save(userDto);
        studentService.save(studentSaveDto);

        studentService.update("test", new StudentUpdateDto(1, "update", null, null, null, null, null));
        StudentDto test = studentService.findById("test");
        log.info("test: {}", test.getRange());
        return "student";
    }
}
