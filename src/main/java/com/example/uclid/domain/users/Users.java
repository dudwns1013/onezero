package com.example.uclid.domain.users;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Users {

    @Id
    @Column(nullable = false)
    private Long colNum;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Long phone;

    @Builder
    public Users(Long colNum, String name, String password, Long phone){
        this.colNum = colNum;
        this.name = name;
        this.password = password;
        this.phone = phone;
    }

}
