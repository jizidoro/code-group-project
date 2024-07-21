package com.company.app.application.responseObjects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResultDto {

    Boolean success;
    Integer code;
    String message;
}
