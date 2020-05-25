package com.example.uclid.web;

import com.example.uclid.service.UsersService;
import com.example.uclid.web.dto.UsersResponseDto;
import com.example.uclid.web.dto.UsersSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UsersApiController {

    private final UsersService usersService;

    @PostMapping("/api/v1/users")
    public Long save(@RequestBody UsersSaveRequestDto requestDto){
        return usersService.save(requestDto);
    }

    @GetMapping("/api/v1/users/{colNum}")
    public UsersResponseDto findById (@PathVariable Long colNum){
        return usersService.findById(colNum);
    }
}
