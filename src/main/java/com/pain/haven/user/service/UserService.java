package com.pain.haven.user.service;

import com.pain.haven.user.domain.user.User;
import com.pain.haven.user.domain.user.UserDto;
import com.pain.haven.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

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

    @Transactional
    public UserDto registerUser(UserDto userDto) {
        String newUserId = generateNextUserId();

        User newUser = User.builder()
                .id(newUserId)
                .userId(userDto.getUserId())
                .password(userDto.getPassword())
                .name(userDto.getName())
                .email(userDto.getEmail())
                .phoneNumber(userDto.getPhoneNumber())
                .snsCode(userDto.getSnsCode())
                .createdId("system")  // 시스템에서 자동 생성
                .createdDt(LocalDateTime.now())
                .updatedId(null)
                .updatedDt(null)
                .build();

        User savedUser = userRepository.save(newUser);

        return UserDto.builder()
                .id(savedUser.getId())
                .userId(savedUser.getUserId())
                .password(savedUser.getPassword())
                .name(savedUser.getName())
                .email(savedUser.getEmail())
                .phoneNumber(savedUser.getPhoneNumber())
                .snsCode(savedUser.getSnsCode())
                .createdId(savedUser.getCreatedId())
                .createdDt(savedUser.getCreatedDt())
                .updatedId(savedUser.getUpdatedId())
                .updatedDt(savedUser.getUpdatedDt())
                .build();
    }

    private String generateNextUserId() {
        String lastId = userRepository.findLastUserId();  // DB에서 마지막 ID 조회
        int lastNumber = Integer.parseInt(lastId.substring(1));  // "U0000000001" → 1
        String newUserId = String.format("U%010d", lastNumber + 1);  // 증가
        return newUserId;
    }
}
