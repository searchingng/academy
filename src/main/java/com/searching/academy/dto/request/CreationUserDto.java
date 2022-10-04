package com.searching.academy.dto.request;

import com.searching.academy.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreationUserDto {

    private Long id;

    @NotBlank(message = "name is required")
    private String name;
    @NotBlank(message = "Username is required")
    private String username;
    @NotBlank(message = "password is required")
    private String password;

    @NotBlank(message = "ConfirmPassword is required")
    private String confirmPassword;

    @NotNull
    private Role role;
}
