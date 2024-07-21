package com.company.app.application.responseObjects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ListResultDto<T> extends ResultDto {

    List<T> data;

    public ListResultDto(List<T> response)
    {
        code = 200;
        success = true;
        message = "";
        data = response;
    }

    public ListResultDto(Exception ex)
    {
        code = 200;
        success = false;
        message = ex.getMessage();
        data = null;
    }
}