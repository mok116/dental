package com.SEHS4701.group.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BlogByIdResponse extends BaseResponse {
    private Blog blog;

    public BlogByIdResponse(Blog blog) {
        this.blog = blog;
    }

    public BlogByIdResponse(int code, Blog blog) {
        super(code);
        this.blog = blog;
    }

    public BlogByIdResponse(int code, String message, Blog blog) {
        super(code, message);
        this.blog = blog;
    }
    @Getter
    @Setter
    public static class Blog{
        private int id;
        private String title;
        private String slug;
        private String snippet;
        private String content;
        private String post_date;
        private String image;
    }
}