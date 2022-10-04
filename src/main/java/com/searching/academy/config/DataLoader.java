package com.searching.academy.config;

import com.searching.academy.dto.request.CreationUserDto;
import com.searching.academy.entity.enums.Role;
import com.searching.academy.repository.UserRepository;
import com.searching.academy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DataLoader {

    private final UserRepository userRepository;
    private final UserService userService;

    @Bean
    public void createAdmin(){

        if (userRepository.existsByRole(Role.ADMIN))
            return;

        CreationUserDto admin = new CreationUserDto();
        admin.setName("Admin");
        admin.setUsername("admin");
        admin.setPassword("pass");
        admin.setConfirmPassword("pass");
        admin.setRole(Role.ADMIN);

        userService.save(admin);

    }

}
