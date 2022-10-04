package com.searching.academy.service;

import com.searching.academy.controller.vm.LoginVM;
import com.searching.academy.dto.UserDto;
import com.searching.academy.dto.request.RegistrationUserDto;
import com.searching.academy.dto.response.JWTTokenDto;
import com.searching.academy.errors.BadRequestAlertException;

import javax.servlet.http.HttpServletRequest;

public interface AuthService {

    JWTTokenDto loginUser(HttpServletRequest request, LoginVM loginVM);

    UserDto register(RegistrationUserDto userDto) throws BadRequestAlertException;
}
