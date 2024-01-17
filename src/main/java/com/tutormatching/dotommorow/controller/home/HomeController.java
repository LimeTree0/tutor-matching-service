package com.tutormatching.dotommorow.controller.home;

import com.tutormatching.dotommorow.dto.lesson.LessonConditionDto;
import com.tutormatching.dotommorow.dto.lesson.LessonDto;
import com.tutormatching.dotommorow.service.lesson.LessonService;
import com.tutormatching.dotommorow.service.test.TestService;
import com.tutormatching.dotommorow.util.FileUploadUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final LessonService lessonService;
    private final FileUploadUtil fileUploadUtil;

    @GetMapping("/")
    public String index(Model model) {
        List<LessonDto> lessonDtoList = lessonService.findAllByCondition(new LessonConditionDto());
        lessonDtoList.forEach(lessonDto -> {
            String fullPath = fileUploadUtil.getFullPath(lessonDto.getUserProfileImageName());
            lessonDto.setFilePath(fullPath);
        });

        if (lessonDtoList.size() == 0) {
            log.info("lessonDtoList is empty");
        }

        model.addAttribute("lessonDtoList", lessonDtoList);
        return "index";
    }
}
