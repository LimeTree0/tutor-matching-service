package com.tutormatching.dotommorow.controller.user;

import com.tutormatching.dotommorow.dto.user.UserDto;
import com.tutormatching.dotommorow.dto.user.UserJoinDto;
import com.tutormatching.dotommorow.dto.user.UserUpdateDto;
import com.tutormatching.dotommorow.service.user.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * 사용자 관련 컨트롤러
 */

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 회원 가입 페이지
    @GetMapping("/user/joinForm")
    public String user() {
        return "member/joinForm";
    }

    // 회원 가입
    @PostMapping("/user/join")
    public String join(UserJoinDto userDto) {
        log.info("userDto: {}", userDto);
        userService.save(userDto);
        return "redirect:/";
    }

    // 마이 페이지
    @GetMapping("/user/myPage")
    public String myPage(Principal principal, Model model) {
        if (principal == null) {
            return "redirect:/login";
        }

        log.info("mypage username: {}", principal.getName());
        UserDto userDto = userService.findById(principal.getName());
        model.addAttribute("userDto", userDto);
        return "member/myPage";
    }

    // 회원 정보 수정
    @PutMapping("/user/myPage")
    @ResponseBody
    public HttpStatus update(@RequestBody UserUpdateDto userUpdateDto) {
        log.info("userUpdateDto: {}", userUpdateDto);
        userService.update(userUpdateDto);
        return HttpStatus.OK;
    }

    // 회원 정보 삭제
    @DeleteMapping("/user/myPage/{userId}")
    @ResponseBody
    public HttpStatus delete(@PathVariable("userId") String userId) {
        log.info("delete username: {}", userId);
        userService.delete(userId);
        log.info("delete username: success");
        return HttpStatus.OK;
    }
}
