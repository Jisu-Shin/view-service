package com.view_service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class BookingListResponseDto {

    private Long bookId;
    private Long custId;
    private String custName;
    private String itemName;
    private int count;
    private String bookingStatus;
    private String bookDt;
    private boolean isBooking;
}
