package com.example.demo.dto;

import com.example.demo.model.Clinic;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class ClinicListResponse extends BaseResponse {
    private List<Clinic> ItemList;

    public ClinicListResponse(List<Clinic> itemList) {
        ItemList = itemList;
    }
}
