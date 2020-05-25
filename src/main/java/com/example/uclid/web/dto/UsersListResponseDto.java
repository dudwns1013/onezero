package com.example.uclid.web.dto;

import com.example.uclid.domain.users.Users;
import lombok.Getter;

@Getter
public class UsersListResponseDto {

    private String name;
    private Long colNum;
    private String password;
    private Long phone;

    public UsersListResponseDto(Users entity){
        this.name = entity.getName();
        this.colNum = entity.getColNum();
        this.password = entity.getPassword();
        this.phone = entity.getPhone();
    }
}
