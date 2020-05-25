package com.example.uclid.web.dto;

import com.example.uclid.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {

    private Long id;
    private String name;
    private String category;
    private String price;
    private String content;
    private boolean sell;

    public PostsResponseDto(Posts entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.category = entity.getCategory();
        this.price = entity.getPrice();
        this.content = entity.getContent();
        this.sell = entity.isSell();

    }
}
