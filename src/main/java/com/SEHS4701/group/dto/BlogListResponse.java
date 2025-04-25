package com.SEHS4701.group.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class BlogListResponse extends BaseResponse {
    private List<Blog> BlogList;

    public BlogListResponse(List<Blog> BlogList) {
        this.BlogList = BlogList;
    }

    @Getter
    @Setter
    public static class Blog{
        private Integer id;
        private String title;
        private String slug;
        private String snippet;
        private String content;
        private String post_date;
        private String image;
    }
}