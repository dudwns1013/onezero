package com.example.uclid.web.dto;

import com.example.uclid.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private Long id;
    private String name;
    private String category;
    private String price;
    private String content;
    private boolean sell;

    @Builder
    public PostsSaveRequestDto(String name, String category, String price, String content,boolean sell) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.content = content;
        this.sell = sell;
    }

    public Posts toEntity(){
        return Posts.builder()
                .name(name)
                .category(category)
                .price(price)
                .content(content)
                .sell(sell)
                .build();
    }
}
