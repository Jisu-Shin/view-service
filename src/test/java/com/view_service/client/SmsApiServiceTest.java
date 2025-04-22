package com.view_service.client;

import com.view_service.dto.SmsTemplateListResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SmsApiServiceTest {

    @Autowired SmsApiService smsApiService;
    @Autowired SmsTemplateApiService smsTemplateApiService;

    @Value("${service.sms}")
    private String smsUrl;
    
    @Test
    public void sms템플릿조회() throws Exception {
        //given

        //when
        List<SmsTemplateListResponseDto> smsTemplates = smsTemplateApiService.getSmsTemplates();
        System.out.println(smsTemplates.size());
        System.out.println(smsTemplates.get(0).getTemplateContent());

        //then
        assertNotNull(smsTemplates);
    }

    @Test
    public void baseurl확인() throws Exception {
        //given

        //when
        System.out.println(smsUrl);

        //then
    }

}