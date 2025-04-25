package com.SEHS4701.group.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class BookedClinicDentistIdsResponse extends BaseResponse {
    private List<Integer> bookedClinicDentistIds;

    public BookedClinicDentistIdsResponse(List<Integer> bookedClinicDentistIds) {
        this.bookedClinicDentistIds = bookedClinicDentistIds;
    }
}
