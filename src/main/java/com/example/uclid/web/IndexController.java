package com.example.uclid.web;

import com.example.uclid.service.PostsService;
import com.example.uclid.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/addstock")
    public String addstock(){
        return "addstock";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @GetMapping("/notice")
    public String notice(){
        return "notice";
    }

    @GetMapping("/service")
    public String service(){
        return "service";
    }

    @GetMapping("/shop")
    public String shop(Model model){
        model.addAttribute("posts",postsService.findAllDesc());
        return "shop";
    }

    @GetMapping("/buy/{id}")
    public String buy(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);
        return "buy";
    }

    @GetMapping("/write")
    public String write(){
        return "write";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);
        return "detail";
    }


}
