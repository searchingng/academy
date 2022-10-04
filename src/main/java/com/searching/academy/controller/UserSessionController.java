package com.searching.academy.controller;

import com.searching.academy.dto.UserSessionDto;
import com.searching.academy.entity.User;
import com.searching.academy.service.UserSessionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/userSessions")
public class UserSessionController {

    private final UserSessionService userSessionService;

    public UserSessionController(UserSessionService userSessionService) {
        this.userSessionService = userSessionService;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SUPERADMIN')")
    @GetMapping
    public ResponseEntity<Page<UserSessionDto>> getAllUserSession(Pageable pageable, User user) {
        Page<UserSessionDto> result = userSessionService.findAll(pageable, user);
        return ResponseEntity.ok(result);
    }
//    @GetMapping("/{id}")
//    public ResponseEntity<AdminSessionDto> getAllAdminSession(@PathVariable Long id){
//        AdminSessionDto adminSessionDtos = adminSessionService.findOne(id);
//        return ResponseEntity.ok(adminSessionDtos);
//    }
}
