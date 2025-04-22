package com.view_service.client;

import com.view_service.dto.BookingSearch;
import org.junit.jupiter.api.Test;
import org.springframework.web.util.UriComponentsBuilder;

import static org.junit.jupiter.api.Assertions.*;

class BookingApiServiceTest {

    @Test
    public void url확인() throws Exception {
        //given
        String baseUrl = "http://localhost:8080/api/bookings";

        BookingSearch bookingSearch = new BookingSearch();
//        bookingSearch.setBookingStatus("BOOK");

        UriComponentsBuilder builder = UriComponentsBuilder.fromPath(baseUrl)
                .pathSegment("search");

        if (bookingSearch.getBookingStatus() != null) {
            builder.queryParam("bookingStatus", bookingSearch.getBookingStatus());
        }

        if (bookingSearch.getItemId() != null) {
            builder.queryParam("itemId", bookingSearch.getItemId());
        }

        System.out.println(builder.toUriString());


    }

}