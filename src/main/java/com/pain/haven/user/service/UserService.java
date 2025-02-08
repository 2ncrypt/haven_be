package com.pain.haven.user.service;

import com.pain.haven.user.domain.user.User;
import com.pain.haven.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired  // 생성자 주입 명시
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByName(String name) {
        return userRepository.findByName(name);  // ✅ findByName 사용
    }
    // 사용자 ID 존재 여부 확인
    public boolean checkUserIdExists(String userId) {
        return userRepository.existsByUserId(userId);
    }

    // 이메일 존재 여부 확인
    public boolean checkUserEmailExists(String email) {
        return userRepository.existsByEmail(email);
    }

    // 회원가입 기능
    public User registerUser(User user) {
        return userRepository.save(user);
    }
}
