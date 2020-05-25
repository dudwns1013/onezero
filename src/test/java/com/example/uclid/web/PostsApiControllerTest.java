package com.example.uclid.web;

import com.example.uclid.domain.posts.Posts;
import com.example.uclid.domain.posts.PostsRepository;
import com.example.uclid.web.dto.PostsSaveRequestDto;
import com.example.uclid.web.dto.PostsUpdateRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void tearDown() throws Exception{
        postsRepository.deleteAll();
    }

    @Test
    public void Posts_regist() throws Exception{
        //given
        String name = "name";
        String category = "category";
        String price = "price";
        String content = "content";
        PostsSaveRequestDto requestDto = PostsSaveRequestDto.builder()
                .name(name)
                .category(category)
                .price(price)
                .content(content)
                .build();

        String url = "http://localhost:"+port+"/api/v1/posts";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getName()).isEqualTo(name);
        assertThat(all.get(0).getCategory()).isEqualTo(category);
        assertThat(all.get(0).getPrice()).isEqualTo(price);
        assertThat(all.get(0).getContent()).isEqualTo(content);

    }

    @Test
    public void Posts_update() throws Exception{
        //given
        Posts savedPosts = postsRepository.save(Posts.builder().name("pd_name")
                .category("pd_category")
                .price("pd_price")
                .content("pd_content")
                .build());

        Long updateId = savedPosts.getId();
        String expectedName = "up_name";
        String expectedCategory = "up_category";
        String expectedPrice = "up_price";
        String expectedContent = "up_content";

        PostsUpdateRequestDto requestDto = PostsUpdateRequestDto.builder().name(expectedName)
                .category(expectedCategory)
                .price(expectedPrice)
                .content(expectedContent)
                .build();

        String url = "http://localhost:"+port+"/api/v1/posts/"+updateId;

        HttpEntity<PostsUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        //when
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT,requestEntity,Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getName()).isEqualTo(expectedName);
        assertThat(all.get(0).getCategory()).isEqualTo(expectedCategory);
        assertThat(all.get(0).getPrice()).isEqualTo(expectedPrice);
        assertThat(all.get(0).getContent()).isEqualTo(expectedContent);

    }
}