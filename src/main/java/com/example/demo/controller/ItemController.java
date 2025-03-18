package com.example.demo.controller;

import com.example.demo.dto.BaseResponse;
import com.example.demo.dto.ItemListResponse;
import com.example.demo.model.Item;
import com.example.demo.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/item")
public class ItemController {
	private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/list")
	public ResponseEntity<?> list() {
		try {
			List<Item> itemList = itemService.getList();
			return new ResponseEntity<>(new ItemListResponse(itemList), HttpStatus.OK);
		}
		catch (RuntimeException e) {
			return new ResponseEntity<>(new BaseResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}
}