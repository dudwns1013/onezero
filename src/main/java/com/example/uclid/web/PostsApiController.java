package com.example.uclid.web;

import com.example.uclid.service.PostsService;
import com.example.uclid.service.UsersService;
import com.example.uclid.web.dto.PostsResponseDto;
import com.example.uclid.web.dto.PostsSaveRequestDto;
import com.example.uclid.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;


    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long buy(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.buy(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id){
        return postsService.findById(id);
    }

}
