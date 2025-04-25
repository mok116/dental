package com.SEHS4701.group.controller;

import com.SEHS4701.group.dto.BaseResponse;
import com.SEHS4701.group.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/blog")
public class BlogController {
	
	private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBlogById(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(blogService.getById(id), HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity<>(new BaseResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/list")
	public ResponseEntity<?> list() {
		try {
			return new ResponseEntity<>(blogService.getList(), HttpStatus.OK);
		}
		catch (RuntimeException e) {
			return new ResponseEntity<>(new BaseResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}
}