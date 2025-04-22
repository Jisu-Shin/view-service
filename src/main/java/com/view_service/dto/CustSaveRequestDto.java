package com.view_service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class CustSaveRequestDto {

    private String name;
    private String phoneNumber;
    private String smsConsentType;

    @Builder
    public CustSaveRequestDto(String name, String phoneNumber, String smsConsentType) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.smsConsentType = smsConsentType;
    }

    @Override
    public String toString() {
        return "CustSaveRequestDto{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", smsConsentType=" + smsConsentType +
                '}';
    }
}
