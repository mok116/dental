package com.SEHS4701.group.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterResponse extends BaseResponse {
    private Integer lastInsertId;

    public RegisterResponse(int lastInsertId) {
        this.lastInsertId = lastInsertId;
    }

    public RegisterResponse(int code, String message) {
        super(code, message);
    }
}