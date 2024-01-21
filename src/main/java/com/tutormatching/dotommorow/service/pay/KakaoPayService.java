package com.tutormatching.dotommorow.service.pay;

import com.tutormatching.dotommorow.dto.pay.KakaoApproveResponse;
import com.tutormatching.dotommorow.dto.pay.KakaoCancelResponse;
import com.tutormatching.dotommorow.dto.pay.KakaoReadyResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
@PropertySource(value = {"classpath:application-pay.properties"})
public class KakaoPayService {
    static final String cid = "TC0ONETIME";
    @Value("${kakao.admin.key}")
    private String admin_key;

    private KakaoReadyResponse kakaoReady;

    public String kakaoPayReady(String userId, Integer price, String lessonName, Integer lessonId) {
        LinkedMultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();

        Integer vat_amount = (int) (price * 0.1);

        // 카카오페이 요청 생성
        parameters.add("cid", cid);
        parameters.add("partner_order_id", "1");
        parameters.add("partner_user_id", userId);
        parameters.add("item_name", lessonName);
        parameters.add("item_code", lessonId.toString());
        parameters.add("quantity", "1");
        parameters.add("total_amount", price.toString());
        parameters.add("tax_free_amount", "0");
        parameters.add("approval_url", "http://localhost:8080/payment/success"); // 성공 시 redirect url
        parameters.add("cancel_url", "http://localhost:8080/payment/cancel"); // 취소 시 redirect url
        parameters.add("fail_url", "http://localhost:8080/payment/fail"); // 실패 시 redirect url

        HttpEntity<LinkedMultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());
        RestTemplate restTemplate = new RestTemplate();

        kakaoReady = restTemplate.postForObject("https://kapi.kakao.com/v1/payment/ready",
                requestEntity, KakaoReadyResponse.class);


        return kakaoReady.getNext_redirect_pc_url();
    }

    public KakaoApproveResponse approveResponse(String pgToken) {
        // 카카오 요청
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("cid", cid);
        parameters.add("tid", kakaoReady.getTid());
        parameters.add("partner_order_id", "1");
        parameters.add("partner_user_id", "test");
        parameters.add("pg_token", pgToken);

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());

        RestTemplate restTemplate = new RestTemplate();

        KakaoApproveResponse approveResponse = restTemplate.postForObject("https://kapi.kakao.com/v1/payment/approve",
                requestEntity, KakaoApproveResponse.class);

        return approveResponse;
    }

    public KakaoCancelResponse kakaoCancel() {
        LinkedMultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("cid", cid);
        parameters.add("tid", kakaoReady.getTid());
        parameters.add("cancel_amount", "2200");
        parameters.add("cancel_tax_free_amount", "0");
        parameters.add("cancel_vat_amount", "200");

        HttpEntity<LinkedMultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());

        RestTemplate restTemplate = new RestTemplate();

        KakaoCancelResponse cancelResponse = restTemplate.postForObject("https://kapi.kakao.com/v1/payment/cancel",
                requestEntity, KakaoCancelResponse.class);

        return cancelResponse;
    }

    private HttpHeaders getHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();

        String auth = "KakaoAK " + admin_key;

        httpHeaders.add("Authorization", auth);
        httpHeaders.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        log.info("httpHeaders: {}", httpHeaders);

        return httpHeaders;
    }

}
