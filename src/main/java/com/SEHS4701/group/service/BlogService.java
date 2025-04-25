package com.SEHS4701.group.service;

import com.SEHS4701.group.dto.BlogListResponse;
import com.SEHS4701.group.dto.BlogByIdResponse;

public interface BlogService {
	BlogListResponse getList();

	BlogByIdResponse getById(Integer id);
}