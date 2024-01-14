package com.tutormatching.dotommorow.util;

import jakarta.annotation.PostConstruct;
import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


/**
 * SMS 발송 유틸
 */
@Component
// application-sms.properties 파일을 읽어옴
@PropertySource("classpath:application-sms.properties")
public class SmsUtil {

    @Value("${coolsms.api.key}")
    private String apiKey;

    @Value("${coolsms.api.secret}")
    private String apiSecretKey;

    private DefaultMessageService messageService;

    @PostConstruct
    private void init() {
        this.messageService = NurigoApp.INSTANCE.initialize(apiKey, apiSecretKey, "https://api.coolsms.co.kr");
    }

    // 단일 메시지 발송
    public SingleMessageSentResponse sendOne(String to, String verificationCode) {
        Message message = new Message();

        // 발신번호 및 수신번호는 반드시 01012345678 형태로 입력되어야 합니다
        message.setFrom("01057069516");
        message.setTo(to);
        message.setText("[doTomorrow] 아래의 인증번호를 입력해주세요\n" + verificationCode);

        return this.messageService.sendOne(new SingleMessageSendingRequest(message));
    }
}

