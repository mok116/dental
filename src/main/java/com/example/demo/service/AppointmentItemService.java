package com.example.demo.service;

import com.example.demo.model.AppointmentItem;

import java.util.List;

public interface AppointmentItemService {

	void create(AppointmentItem appointmentItem);

	List<AppointmentItem> getByAppointmentId(Integer id);

	List<AppointmentItem> getByDentalItem(Integer id);
}