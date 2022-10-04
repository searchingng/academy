package com.searching.academy.controller;

import com.searching.academy.controller.vm.LoginVM;
import com.searching.academy.dto.UserDto;
import com.searching.academy.dto.request.RegistrationUserDto;
import com.searching.academy.dto.response.JWTTokenDto;
import com.searching.academy.service.AuthService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

   @PostMapping("/login")
   @ApiResponse
    public ResponseEntity<JWTTokenDto> login(HttpServletRequest request, @RequestBody @Valid LoginVM loginVM) {
        JWTTokenDto jwt = authService.loginUser(request, loginVM);
        if (jwt.isSuccess()) {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add(HttpHeaders.AUTHORIZATION, "Bearer " + jwt.getToken());
            return new ResponseEntity<>(jwt, httpHeaders, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().body(jwt);

    }

    @PostMapping("/registration")
    public ResponseEntity<UserDto> registration(@RequestBody @Valid RegistrationUserDto userDto) throws Exception {
        return ResponseEntity.ok(authService.register(userDto));
    }

}
