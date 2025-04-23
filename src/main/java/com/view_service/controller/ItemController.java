package com.view_service.controller;


import com.view_service.client.ItemApiService;
import com.view_service.dto.ItemCreateRequestDto;
import com.view_service.dto.ItemUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private final ItemApiService itemApiService;

    @GetMapping("")
    public String getItemList(Model model) {
        log.info("###########ItemController getItemList 진입");
        model.addAttribute("items", itemApiService.getItemAll());
        return "item-getList";
    }

    @GetMapping("/new")
    public String createItemForm() {
        return "item-createForm";
    }

    @PostMapping("/new")
    public String createItem(ItemCreateRequestDto requestDto) {
        itemApiService.createItem(requestDto);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String updateItemForm(@PathVariable("id")Long id, Model model) {
        model.addAttribute("item", itemApiService.getItem(id));
        return "item-updateForm";
    }

    @PostMapping("/{id}")
    public String updateItem(ItemUpdateRequestDto requestDto) {
        itemApiService.updateItem(requestDto);

        return "redirect:/items";
    }

}
