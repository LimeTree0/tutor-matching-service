package com.tutormatching.dotommorow.controller.user;

import com.tutormatching.dotommorow.dto.user.UserDto;
import com.tutormatching.dotommorow.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user")
    public String user() {
        UserDto userDto = new UserDto("userid", 1L, "password", "G", 20, "userName", "profileImage", "phonenumber", LocalDateTime.now());
        userService.save(userDto);

        UserDto userid = userService.findById("userid");
        log.info("userid: {}", userid.getUserId());
        return "user";
    }

}
