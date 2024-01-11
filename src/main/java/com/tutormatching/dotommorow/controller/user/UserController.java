package com.tutormatching.dotommorow.controller.user;

import com.tutormatching.dotommorow.dto.user.UserJoinDto;
import com.tutormatching.dotommorow.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user/joinForm")
    public String user() {
        return "member/joinForm";
    }

    @PostMapping("/user/join")
    public String join(UserJoinDto userDto) {
        log.info("userDto: {}", userDto);
        userService.save(userDto);
        return "redirect:/";
    }
//    @GetMapping("/user/myPage/")
//    public String myPage() {
//        return "member/myPage";
//    }

}
