package com.view_service.controller;

import com.view_service.client.SmsTemplateApiService;
import com.view_service.client.TemplateVariableApiService;
import com.view_service.dto.TemplateVariableDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/templateVariable")
public class TemplateVariableController {

    private final TemplateVariableApiService tmpltVarApiService;

    @PostMapping("/new")
    public String create(TemplateVariableDto requestDto) {
        tmpltVarApiService.create(requestDto);
        return "redirect:/smsTemplates/new";
    }

}
