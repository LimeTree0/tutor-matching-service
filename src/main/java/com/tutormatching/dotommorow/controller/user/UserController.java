package com.tutormatching.dotommorow.controller.user;

import com.tutormatching.dotommorow.dto.user.user.UserDto;
import com.tutormatching.dotommorow.dto.user.user.UserJoinDto;
import com.tutormatching.dotommorow.dto.user.user.UserUpdateDto;
import com.tutormatching.dotommorow.service.user.UserService;
import com.tutormatching.dotommorow.util.FileUploadUtil;
import com.tutormatching.dotommorow.util.SmsUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.HashMap;
import java.util.Random;

/**
 * 사용자 관련 컨트롤러
 */

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final FileUploadUtil fileUploadUtil;
    private final SmsUtil smsUtil;

    private HashMap<String, String> verificationCodeMap = new HashMap<>();

    // 회원 가입 페이지
    @GetMapping("/user/joinForm")
    public String user() {
        return "user/joinForm";
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

        return "user/myPage";
    }

    // 회원 정보 수정
    @PutMapping(value = "/user/myPage", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    @ResponseBody
    public HttpStatus update(@RequestPart("userUpdateDto") UserUpdateDto userUpdateDto,
                             @RequestPart(value = "profileImage", required = false) MultipartFile profileImage) {

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

    // 문자 인증 번호 전송
    @PostMapping("/user/sms/verificationCode")
    @ResponseBody
    public HttpStatus sendSmsMessage(@RequestParam("phoneNumber") String phoneNumber) {

        // 인증 번호 생성
        Random random = new Random();
        String certificationCode = String.valueOf(random.nextInt(9000) + 1000);
        verificationCodeMap.put(phoneNumber, certificationCode);
        log.info("certificationCode: {}", certificationCode);
//        // 문자 전송
//        smsUtil.sendOne(phoneNumber, String.valueOf(certificationCode));
        return HttpStatus.OK;
    }

    // 문자 인증
    @PostMapping("/user/sms/certificate")
    @ResponseBody
    public HttpStatus certificatePhoneNumber(
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("certificationCode") String certificationCode) {

        String code = verificationCodeMap.get(phoneNumber);
        if (code == null || !code.equals(certificationCode)) {
            return HttpStatus.BAD_REQUEST;
        }

        log.info("phoneNumber: {} certificationCode: {}", phoneNumber, certificationCode);
        return HttpStatus.OK;
    }
}