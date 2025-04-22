package com.view_service.client;

import com.view_service.dto.SmsFindListResponseDto;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SmsApiService {

    private final RestTemplate restTemplate;

    @Value("${service.sms}")
    private String smsUrl;
    private String baseUrl;

    @PostConstruct
    private void init() {
        baseUrl = "http://" + smsUrl + "/api/sms";
    }

    public List<SmsFindListResponseDto> getSmsList(String startDt, String endDt) {
        System.out.println("***************"+ baseUrl);

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(baseUrl)
                .path("/sendList")
                .queryParam("startDt", startDt)
                .queryParam("endDt", endDt);

        ResponseEntity<List<SmsFindListResponseDto>> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<SmsFindListResponseDto>>() {}
        );
        return response.getBody();
    }

}
