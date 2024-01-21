package com.tutormatching.dotommorow.controller.order;

import com.tutormatching.dotommorow.controller.pay.KakaoPayController;
import com.tutormatching.dotommorow.dto.order.OrderSaveDto;
import com.tutormatching.dotommorow.dto.user.student.StudentDto;
import com.tutormatching.dotommorow.service.order.OrderService;
import com.tutormatching.dotommorow.service.user.StudentService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.time.LocalDateTime;

@Slf4j
@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final KakaoPayController kakaoPayController;
    private final StudentService studentService;


    @PostMapping("/order")
    @ResponseBody
    public String order(@ModelAttribute OrderSaveDto orderSaveDto, Principal principal) {

        log.info("orderSaveDto: {}", orderSaveDto);
        orderSaveDto.setFirstDate(LocalDateTime.now());
        StudentDto studentDto = studentService.findById(principal.getName());
        orderSaveDto.setStudentId(studentDto.getStudentId());
        orderService.save(orderSaveDto);
        String url = kakaoPayController.readyToKakaopay(principal, orderSaveDto.getPrice(),
                orderSaveDto.getClassId(), orderSaveDto.getLessonName());

        return url;
    }

}
