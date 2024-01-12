package com.tutormatching.dotommorow.controller.user;

import ch.qos.logback.classic.spi.ConfiguratorRank;
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
@Controller
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;
    private final UserService userService;

    @GetMapping("/teacher")
    public String teacher() {

        return "teacher 실행";
    }
}
