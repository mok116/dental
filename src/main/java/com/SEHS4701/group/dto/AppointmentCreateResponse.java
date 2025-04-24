package com.SEHS4701.group.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AppointmentCreateResponse extends BaseResponse {
    private Integer lastInsertId;

    public AppointmentCreateResponse(int lastInsertId) {
        this.lastInsertId = lastInsertId;
    }

    public AppointmentCreateResponse(int code, String message) {
        super(code, message);
    }
}
