package com.view_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SmsTemplateListResponseDto {
    private Long id;
    private String templateContent;
    private String smsType;
}
