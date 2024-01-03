package com.tutormatching.dotommorow.controller;

import com.tutormatching.dotommorow.dto.UserDto;
import com.tutormatching.dotommorow.dto.UserUpdateDto;
import com.tutormatching.dotommorow.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


}
