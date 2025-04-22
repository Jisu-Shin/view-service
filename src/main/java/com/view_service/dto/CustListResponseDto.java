package com.view_service.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class CustListResponseDto {

    private Long id;

    private String name;

    private String phoneNumber;

    private String consentType;
}
