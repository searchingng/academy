package com.searching.academy.repository;

import com.searching.academy.entity.UserSession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSessionRepository extends JpaRepository<UserSession, Long> {
    Page<UserSession> findAllByUserId(Long user_id, Pageable pageable);
}
