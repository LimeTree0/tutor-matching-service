package com.tutormatching.dotommorow.controller.pay;


import com.tutormatching.dotommorow.dto.pay.KakaoApproveResponse;
import com.tutormatching.dotommorow.dto.pay.KakaoCancelResponse;
import com.tutormatching.dotommorow.service.pay.KakaoPayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.security.Principal;

@RequestMapping("/payment")
@RequiredArgsConstructor
@Controller
public class KakaoPayController {

    private final KakaoPayService kakaoPayService;

    /**
     * 결제 요청
     * @return
     */
    public String readyToKakaopay(Principal principal, Integer price,
                                  Integer lessonId, String lessonName) {

        return kakaoPayService.kakaoPayReady(principal.getName(), price, lessonName, lessonId);
    }

    /**
     * 결제 성공
     * @param pgToken
     * @return
     */
    @GetMapping("/success")
    public String success(@RequestParam("pg_token") String pgToken, Model model) {
        KakaoApproveResponse kakaoApprove = kakaoPayService.approveResponse(pgToken);

        return "redirect:/";
    }

    /**
     * 결제 진행 중 취소
     */
    @GetMapping("/cancel")
    public void cancel() {
        throw new RuntimeException("User canceled");
    }

    /**
     * 결제 실패
     */
    @GetMapping("/fail")
    public void fail() {
        throw new RuntimeException("Payment failed");
    }

    @PostMapping("/refund")
    public ResponseEntity refund() {
        KakaoCancelResponse cancelResponse = kakaoPayService.kakaoCancel();
        return new ResponseEntity(cancelResponse, HttpStatus.OK);
    }
}