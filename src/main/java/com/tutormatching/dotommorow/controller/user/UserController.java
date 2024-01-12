package com.tutormatching.dotommorow.controller.user;

import com.tutormatching.dotommorow.dto.user.UserDto;
import com.tutormatching.dotommorow.dto.user.UserJoinDto;
import com.tutormatching.dotommorow.dto.user.UserUpdateDto;
import com.tutormatching.dotommorow.service.user.UserService;
import com.tutormatching.dotommorow.util.FileUploadUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

/**
 * 사용자 관련 컨트롤러
 */

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final FileUploadUtil fileUploadUtil;

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

        // 회원 정보 조회
        UserDto userDto = userService.findById(principal.getName());
        log.info("userDto: {}", userDto);
        model.addAttribute("userDto", userDto);

        String filePath = fileUploadUtil.getFullPath(userDto.getProfileImageName());
        model.addAttribute("filePath", filePath);

        return "member/myPage";
    }

    // 회원 정보 수정
    @PutMapping(value = "/user/myPage", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    @ResponseBody
    public HttpStatus update(@RequestPart("userUpdateDto") UserUpdateDto userUpdateDto,
                             @RequestPart("profileImage") MultipartFile profileImage) {

        log.info("userUpdateDto: {}", userUpdateDto);
        log.info("profileImage: {}", profileImage);
        userService.update(userUpdateDto, profileImage);
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
