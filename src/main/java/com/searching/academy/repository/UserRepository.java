package com.searching.academy.repository;

import com.searching.academy.entity.User;
import com.searching.academy.entity.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByRole(Role role);

    boolean existsByUsernameAndIdNot(String username, Long id);

}
