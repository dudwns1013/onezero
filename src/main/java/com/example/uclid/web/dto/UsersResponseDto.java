package com.example.uclid.web.dto;

import com.example.uclid.domain.users.Users;
import lombok.Getter;

@Getter
public class UsersResponseDto {
    private Long colNum;
    private String name;
    private String password;
    private Long phone;

    public UsersResponseDto(Users entity){
        this.name = entity.getName();
        this.colNum = entity.getColNum();
        this.password = entity.getPassword();
        this.phone = entity.getPhone();

    }
}
