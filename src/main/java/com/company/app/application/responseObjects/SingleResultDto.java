package com.company.app.application.responseObjects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SingleResultDto<T> extends ResultDto {
    T data;

    public SingleResultDto(T response)
    {
        code = 200;
        success = true;
        message = "";
        data = response;
    }

    public SingleResultDto(Integer response)
    {
        code = 201;
        success = true;
        message = "";
    }

    public SingleResultDto(Exception ex)
    {
        code = 200;
        success = false;
        message = ex.getMessage();
        data = null;
    }
}