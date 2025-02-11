package com.pain.haven.user.repository;

import com.pain.haven.user.domain.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<Users, Long> {

    @Query("SELECT COALESCE(MAX(u.id), 'U0000000000') FROM Users u")
    String findLastUserId();

    Users findByName(String name);

    boolean existsByEmail(String email);

    boolean existsByUserId(String userId);
}
