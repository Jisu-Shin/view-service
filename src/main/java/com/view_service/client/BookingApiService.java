package com.view_service.client;

import com.view_service.dto.BookingCreateRequestDto;
import com.view_service.dto.BookingListResponseDto;
import com.view_service.dto.BookingSearch;
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
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingApiService {
    public final RestTemplate restTemplate;
    public final CustApiService custApiService;

    @Value("${service.booking}")
    private String bookingUrl;

    private String baseUrl;

    @PostConstruct
    private void init() {
        baseUrl = "http://" + bookingUrl + "/api/bookings";
    }

    public Long cancelBooking(Long id) {
        System.out.println("***************" + baseUrl);

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(baseUrl)
                .pathSegment(String.valueOf(id), "cancel");

        ResponseEntity<Long> response = restTemplate.postForEntity(
                builder.toUriString(),
                id,
                Long.class
        );
        return response.getBody();
    }

    public List<BookingListResponseDto> searchBooking(BookingSearch bookingSearch) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(baseUrl)
                .pathSegment("search");

        if (bookingSearch.getBookingStatus() != null) {
            builder.queryParam("bookingStatus", bookingSearch.getBookingStatus());
        }

        if (bookingSearch.getItemId() != null) {
            builder.queryParam("itemId", bookingSearch.getItemId());
        }

        System.out.println("***************" + builder.toUriString());


        // 1. booking 검색
        ResponseEntity<List<BookingListResponseDto>> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<BookingListResponseDto>>() {
                }
        );
        List<BookingListResponseDto> result = response.getBody();

        // 2. cust 조회
        Map<Long, String> custMap;
        if (bookingSearch.getCustName() != null) {
            custMap = custApiService.getCustId(bookingSearch.getCustName()).stream()
                    .collect(Collectors.toMap(cust -> cust.getId(), cust -> cust.getName()));

            result.stream()
                    .filter(booking -> custMap.containsKey(booking.getCustId()))
                    .forEach(booking -> booking.setCustName(custMap.get(booking.getCustId())));
        }

        return result;
    }

    public Long book(BookingCreateRequestDto requestDto) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(baseUrl);

        ResponseEntity<Long> response = restTemplate.postForEntity(
                builder.toUriString(),
                requestDto,
                Long.class
        );

        return response.getBody();
    }

}
