package com.view_service.controller;



import com.view_service.client.BookingApiService;
import com.view_service.client.CustApiService;
import com.view_service.client.ItemApiService;
import com.view_service.dto.BookingCreateRequestDto;
import com.view_service.dto.BookingListResponseDto;
import com.view_service.dto.BookingSearch;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/bookings")
public class BookingController {

    private final BookingApiService bookingApiService;
    private final ItemApiService itemApiService;
    private final CustApiService custApiService;

    @GetMapping("")
    public String bookingList(Model model, @ModelAttribute("bookingSearch") BookingSearch bookingSearch) {
        log.info("######bookingController.bookingList 진입");

        List<BookingListResponseDto> searchList = bookingApiService.searchBooking(bookingSearch);

        model.addAttribute("bookings", searchList);
        model.addAttribute("bookingSearch", bookingSearch);
        return "booking-getList";
    }

    @GetMapping("/new")
    public String createBookingForm(Model model) {
        log.info("######bookingController.createBookingForm 진입");

        model.addAttribute("custs", custApiService.getCustAll());
        model.addAttribute("items", itemApiService.getItemAll());

        return "booking-createForm";
    }

    @PostMapping("/new")
    public String booking(BookingCreateRequestDto requestDto) {
        bookingApiService.book(requestDto);

        return "redirect:/";
    }
}
