package com.example.uclid.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
    private String name;
    private String category;
    private String price;
    private String content;
    private boolean sell;

    @Builder
    public PostsUpdateRequestDto(String name,String category,String price, String content,boolean sell){
        this.name = name;
        this.category = category;
        this.price = price;
        this.content = content;
        this.sell = sell;
    }
}
