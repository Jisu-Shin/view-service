package com.view_service.client;

import com.view_service.dto.CustListResponseDto;
import com.view_service.dto.CustSaveRequestDto;
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
public class CustApiService {
    private final RestTemplate restTemplate;

    @Value("${service.cust}")
    private String custUrl;

    private String baseUrl;
    private UriComponentsBuilder builder;

    @PostConstruct
    private void init() {
        baseUrl = "http://" + custUrl + "/api/custs";
        builder = UriComponentsBuilder.fromUriString(baseUrl);
    }

    public List<CustListResponseDto> getCustId(String name) {
        builder.pathSegment("findId")
                .queryParam("name", name);

        ResponseEntity<List<CustListResponseDto>> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CustListResponseDto>>() {
                }
        );
        return response.getBody();
    }

    public List<CustListResponseDto> getCustAll() {
        ResponseEntity<List<CustListResponseDto>> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CustListResponseDto>>() {}
        );
        return response.getBody();
    }

    public Long createCust(CustSaveRequestDto requestDto) {
        ResponseEntity<Long> response = restTemplate.postForEntity(
                builder.toUriString(),
                requestDto,
                Long.class
        );

        return response.getBody();
    }
}
