package com.example.uclid.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void product_load() {
        //given
        String name = "product name";
        String category = "product category";
        String price = "product price";
        String content = "product content";

        postsRepository.save(Posts.builder()
                .name(name)
                .category(category)
                .price(price)
                .content(content)
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getName()).isEqualTo(name);
        assertThat(posts.getCategory()).isEqualTo(category);
        assertThat(posts.getPrice()).isEqualTo(price);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_regist() {

        //given
        LocalDateTime now = LocalDateTime.of(2020, 5, 17, 0, 0, 0);
        postsRepository.save(Posts.builder()
                .name("name")
                .category("category")
                .price("price")
                .content("pd_content")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>> createDate=" + posts.getCreatedDate() + ", modifiedDate=" + posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);

    }

}