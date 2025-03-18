package com.example.demo.dto;

import com.example.demo.model.DentistItem;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class DentistItemListResponse extends BaseResponse {
    private List<DentistItem> dentistItemList;

    public DentistItemListResponse(List<DentistItem> dentistItemList) {
        this.dentistItemList = dentistItemList;
    }
}
