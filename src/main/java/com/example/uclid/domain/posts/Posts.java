package com.example.uclid.domain.posts;

import com.example.uclid.domain.BaseTimeEntity;
import lombok.Builder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String price;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private boolean sell;

    @Builder
    public Posts(String name,boolean sell,String category,String price, String content){
        this.name = name;
        this.sell = sell;
        this.category = category;
        this.price = price;
        this.content = content;
    }

    @Builder
    public void buy(String name,boolean sell, String category, String price, String content) {
        this.name = name;
        this.sell = sell;
        this.category=category;
        this.price=price;
        this.content = content;
    }
}
