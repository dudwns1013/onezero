package com.example.uclid.web.dto;

import com.example.uclid.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsListResponseDto {
    private Long id;
    private String name;
    private String category;
    private String price;
    private String content;
    private boolean sell;
    private LocalDateTime modifiedDate;

    public PostsListResponseDto(Posts entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.category = entity.getCategory();
        this.price = entity.getPrice();
        this.content = entity.getContent();
        this.sell = entity.isSell();
        this.modifiedDate = entity.getModifiedDate();
    }

}
