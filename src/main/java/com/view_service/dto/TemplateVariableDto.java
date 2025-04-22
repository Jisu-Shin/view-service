package com.view_service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class TemplateVariableDto {
    private String enText;

    private String koText;

    private String variableType;

    private String displayVarType;
}
