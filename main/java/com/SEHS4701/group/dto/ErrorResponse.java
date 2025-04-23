package com.SEHS4701.group.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ErrorResponse extends BaseResponse {
    Map<String, String> errors = new HashMap<>();

    public ErrorResponse(int code, String message, Map<String, String> errors) {
        super(code, message);
        this.errors = errors;
    }

    public ErrorResponse(int code, Map<String, String> errors) {
        super(code);
        this.errors = errors;
    }

    public ErrorResponse(Map<String, String> errors) {
        this.errors = errors;
    }
}