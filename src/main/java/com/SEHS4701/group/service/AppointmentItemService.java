package com.SEHS4701.group.service;

import com.SEHS4701.group.model.AppointmentItem;

import java.util.List;

public interface AppointmentItemService {

	void create(AppointmentItem appointmentItem);

	List<AppointmentItem> getByDentistItem(Integer id);
}