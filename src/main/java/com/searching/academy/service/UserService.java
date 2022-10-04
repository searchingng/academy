package com.searching.academy.service;

import com.searching.academy.dto.UserDto;
import com.searching.academy.dto.request.CreationUserDto;
import com.searching.academy.dto.response.AlertResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface UserService {

    Page<UserDto> findAll(Pageable pageable);

    Optional<UserDto> findOne(Long id);

    UserDto save(CreationUserDto userDto);

    AlertResponseDto delete(Long id) throws Exception;
}
