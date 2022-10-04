package com.searching.academy.service.impl;

import com.searching.academy.controller.vm.LoginVM;
import com.searching.academy.dto.UserDto;
import com.searching.academy.dto.request.RegistrationUserDto;
import com.searching.academy.dto.response.JWTTokenDto;
import com.searching.academy.entity.User;
import com.searching.academy.entity.enums.Role;
import com.searching.academy.errors.BadRequestAlertException;
import com.searching.academy.repository.UserRepository;
import com.searching.academy.security.jwt.JwtTokenProvider;
import com.searching.academy.service.AuthService;
import com.searching.academy.service.UserSessionService;
import com.searching.academy.service.mapper.RegistrationUserMapper;
import com.searching.academy.service.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final JwtTokenProvider tokenProvider;
    private final UserSessionService userSessionService;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final UserMapper userMapper;
    private final RegistrationUserMapper registrationUserMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public JWTTokenDto loginUser(HttpServletRequest request, @NotNull LoginVM loginVM) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginVM.getUsername(), loginVM.getPassword());
        Authentication authentication = null;
        try {
            authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = tokenProvider.generateToken(authentication);
            userSessionService.save(request, (User) authentication.getPrincipal(), jwt);
            User user = (User) authentication.getPrincipal();
            return new JWTTokenDto(jwt, true, user.getName(), user.getRole());
        } catch (Exception e) {
            return (new JWTTokenDto("Username or Password invalid", false, null, null));
        }
    }

    @Override
    public UserDto register(RegistrationUserDto userDto) throws BadRequestAlertException {
        User user = registrationUserMapper.toEntity(userDto);
        boolean existsByUsername = userRepository.existsByUsername(userDto.getUsername());

        if (!userDto.getConfirmPassword().equals(userDto.getPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "password and confirm password is not match");
        }

        // create
        if (existsByUsername){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already exits");
        }

        user.setRole(Role.USER);

        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
        return userMapper.toDto(user);
    }


}
