package com.tutormatching.dotommorow.controller.test;

import com.tutormatching.dotommorow.service.test.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping("/test")
    public String test() {
        List<String> testAll = testService.findAll();
        for (String test : testAll) {
            log.info("test: {}", test);
        }
        return "index";
    }

    @GetMapping("/")
    public String index(Principal principal) {

        if (principal == null) {
            return "index";
        }

        log.info("login username: {}", principal.getName());
        return "index";
    }
}
