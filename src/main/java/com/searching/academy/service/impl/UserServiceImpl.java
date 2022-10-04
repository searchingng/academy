package com.searching.academy.service.impl;

import com.searching.academy.dto.UserDto;
import com.searching.academy.dto.request.CreationUserDto;
import com.searching.academy.dto.response.AlertResponseDto;
import com.searching.academy.entity.User;
import com.searching.academy.repository.UserRepository;
import com.searching.academy.service.UserService;
import com.searching.academy.service.mapper.CreationUserMapper;
import com.searching.academy.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final CreationUserMapper creationUserMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Page<UserDto> findAll(Pageable pageable) {
        return userRepository.findAll(pageable).map(userMapper::toDto);
    }

    @Override
    public Optional<UserDto> findOne(Long id) {
        return userRepository.findById(id).map(userMapper::toDto);

    }

    @Override
    public UserDto save(CreationUserDto userDto) {
        User user = creationUserMapper.toEntity(userDto);
        boolean existsByUsername = userRepository.existsByUsernameAndIdNot(userDto.getUsername(), userDto.getId());

        if (!userDto.getConfirmPassword().equals(userDto.getPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "password and confirm password is not match");
        }

        // create
        if (existsByUsername){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already exits");
        }

        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
//        JWTTokenDto jwtTokenDto = authService.loginUser(httpServletRequest,new LoginVM(userDto.getUsername(), userDto.getPassword()));
        return userMapper.toDto(user);

    }


    @Override
    public AlertResponseDto delete(Long id) {
        userRepository.deleteById(id);
        return new AlertResponseDto("User o'chirilmadi", false);
    }
}
