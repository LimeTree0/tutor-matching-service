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
//        log.info("student 실행");
//        UserDto userDto = new UserDto("userid", 1L, "password", "G", 20, "userName", "profileImage", "phonenumber", LocalDateTime.now());
//        StudentSaveDto studentSaveDto = new StudentSaveDto("userid", 1, "rage", LocalDateTime.now(), LocalDateTime.now(), "Category", "level", "academic");
//        userService.save(userDto);
//        studentService.save(studentSaveDto);
//
////        studentService.update("userid", new StudentUpdateDto(1, "update", null, null, null, null, null));
//        StudentDto test = studentService.findById("userid");
//
//        StudentWithUserDto student = studentRepository.selectByIdWithUser("userid");
//
//        log.info("student.getRange: {}", student.getRange());
//        log.info("student.getStudentId: {}", student.getStudentId());
//        log.info("student.userId: {}", student.getUserDto().getUserId());
//        log.info("student 종료");
        return "student";
    }
}
