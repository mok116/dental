package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class resultList {
	private Integer code;
	private String msg;
	private List<? extends Object> resultList = new ArrayList<>();
}
