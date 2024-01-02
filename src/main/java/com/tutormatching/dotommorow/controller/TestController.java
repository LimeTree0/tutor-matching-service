package com.tutormatching.dotommorow.controller;

import com.tutormatching.dotommorow.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping("/test")
    public String test() {
        for (int i = 0; i < 10; i++) {
            testService.save("test" + i);
        }
        List<String> testAll = testService.findAll();
        for (String test : testAll) {
            log.info("test: {}", test);
        }
        return "index";
    }
}
