package com.SEHS4701.group.serviceImpl;

import com.SEHS4701.group.dto.BlogListResponse;
import com.SEHS4701.group.dto.BlogByIdResponse;
import com.SEHS4701.group.model.Blog;
import com.SEHS4701.group.repository.BlogRepository;
import com.SEHS4701.group.service.BlogService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements BlogService {
    private final BlogRepository blogRepository;
    private final ModelMapper modelMapper;

    public BlogServiceImpl(BlogRepository blogRepository, ModelMapper modelMapper) {
        this.blogRepository = blogRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public BlogListResponse getList() {

           List<Blog> blogs = blogRepository.findAll();
        if (blogs.isEmpty()) {
            throw new RuntimeException("blog not found!");
        }
        return new BlogListResponse(blogs.stream().map(blog -> modelMapper.map(blog, BlogListResponse.Blog.class))
                .collect(Collectors.toList()));
    }

    @Override
    public BlogByIdResponse getById(Integer id) {
        Blog blog = blogRepository.findById(id).orElseThrow(() -> new RuntimeException("blog not found!"));
        return new BlogByIdResponse(modelMapper.map(blog, BlogByIdResponse.Blog.class));
    }
}