package com.tutormatching.dotommorow.controller.user;

import com.tutormatching.dotommorow.dto.user.*;
import com.tutormatching.dotommorow.repository.user.StudentRepository;
import com.tutormatching.dotommorow.repository.user.UserRepository;
import com.tutormatching.dotommorow.service.user.StudentService;
import com.tutormatching.dotommorow.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Slf4j
@Controller
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final UserService userService;
    private final StudentRepository studentRepository;

    @GetMapping("/student")
    public String student() {

        return "student";
    }
}
