package com.pain.haven.user.repository;

import com.pain.haven.user.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);

    boolean existsByEmail(String email);

    boolean existsByUserId(String userId);
}
