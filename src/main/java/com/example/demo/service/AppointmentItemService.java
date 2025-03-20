package com.example.demo.service;

import com.example.demo.model.AppointmentItem;

import java.util.List;

public interface AppointmentItemService {

	void create(AppointmentItem appointmentItem);

//	AppointmentItemByPatientIdResponse getByPatientId(Integer id);

	List<AppointmentItem> getByDentistItem(Integer id);
}