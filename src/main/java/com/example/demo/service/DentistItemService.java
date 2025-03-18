package com.example.demo.service;

import com.example.demo.model.DentistItem;

import java.util.List;

public interface DentistItemService {

	List<DentistItem> getList();

	DentistItem getById(Integer id);

	List<DentistItem> getByDentistId(Integer id);
}