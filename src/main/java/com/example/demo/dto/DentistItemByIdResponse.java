package com.example.demo.dto;

import com.example.demo.model.DentistItem;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DentistItemByIdResponse extends BaseResponse {
    private DentistItem dentistItem;

    public DentistItemByIdResponse(DentistItem dentistItem) {
        this.dentistItem = dentistItem;
    }
}
