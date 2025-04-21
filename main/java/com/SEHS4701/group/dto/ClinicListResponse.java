package com.SEHS4701.group.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class ClinicListResponse extends BaseResponse {
    private List<Clinic> ClinicList;

    public ClinicListResponse(List<Clinic> ClinicList) {
        this.ClinicList = ClinicList;
    }

    @Getter
    @Setter
    public static class Clinic{
        private int id;
        private String name;
        private String address;
        private String district;
        private String phone;
        private String openHours;
    }
}
