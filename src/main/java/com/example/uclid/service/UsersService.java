package com.example.uclid.service;

import com.example.uclid.domain.users.Users;
import com.example.uclid.domain.users.UsersRepository;
import com.example.uclid.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UsersService {
    private final UsersRepository usersRepository;


    @Transactional
    public Long save(UsersSaveRequestDto requestDto){
        return usersRepository.save(requestDto.toEntity()).getColNum();
    }

    public UsersResponseDto findById (Long colNum){
        Users entity = usersRepository.findById(colNum).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+colNum));

        return new UsersResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<UsersListResponseDto> findAllDesc(){
        return usersRepository.findAllDesc().stream().map(UsersListResponseDto::new).collect(Collectors.toList());
    }


}
