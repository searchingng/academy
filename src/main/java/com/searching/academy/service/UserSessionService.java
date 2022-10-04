package com.searching.academy.service;

import com.searching.academy.dto.UserSessionDto;
import com.searching.academy.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletRequest;

public interface UserSessionService {

    Page<UserSessionDto> findAll(Pageable pageable, User user);

    void save(HttpServletRequest request, User user, String token);

//    AdminSessionDto findOne(Long id);


}
