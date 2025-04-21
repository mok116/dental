package com.SEHS4701.group.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse{
    private int code = 0;
    private String message = "success";

    public BaseResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResponse(int code) {
        this.code = code;
    }

    public BaseResponse() {
    }
}
