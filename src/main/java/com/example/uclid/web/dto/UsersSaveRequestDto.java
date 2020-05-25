package com.example.uclid.web.dto;

import com.example.uclid.domain.users.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UsersSaveRequestDto {

    private Long colNum;
    private String name;
    private String password;
    private Long phone;

    @Builder
    public UsersSaveRequestDto(Long colNum,String name,String password,Long phone) {
        this.colNum = colNum;
        this.name = name;
        this.password = password;
        this.phone = phone;
    }

    public Users toEntity(){
        return Users.builder()
                .colNum(colNum)
                .name(name)
                .password(password)
                .phone(phone)
                .build();
    }

}
