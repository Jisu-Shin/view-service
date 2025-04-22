package com.view_service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class ItemGetResponseDto {
    private Long id;
    private String name;
    private int price;
    private int stockQuantity;

}
