package com.pain.haven.user.repository;

import com.pain.haven.user.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT COALESCE(MAX(u.id), 'U0000000000') FROM User u")
    String findLastUserId();

    User findByName(String name);

    boolean existsByEmail(String email);

    boolean existsByUserId(String userId);
}
