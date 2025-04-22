package com.view_service.controller;


import com.view_service.client.SmsTemplateApiService;
import com.view_service.client.TemplateVariableApiService;
import com.view_service.dto.SmsTemplateRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/smsTemplates")
public class SmsTemplateController {

    private final SmsTemplateApiService smsTemplateApiService;
    private final TemplateVariableApiService tmpltVarApiServie;

    @GetMapping("/new")
    public String createTemplateForm(Model model) {
        model.addAttribute("templates", smsTemplateApiService.getSmsTemplates());
        model.addAttribute("placeholders", tmpltVarApiServie.getTemplateVariables());
        return "template-create";
    }

    @PostMapping("/new")
    public String createTemplate(SmsTemplateRequestDto requestDto) {
        smsTemplateApiService.createSmsTemplate(requestDto);
        return "redirect:/smsTemplates/new";
    }

}
