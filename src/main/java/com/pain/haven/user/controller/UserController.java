package com.pain.haven.user.controller;

import com.pain.haven.user.domain.user.UsersDTO;
import com.pain.haven.user.service.UserService;
import com.pain.haven.utils.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final EmailService emailService;

    @Autowired  // 생성자 주입 명시적 설정
    public UserController(UserService userService, EmailService emailService) {
        this.userService = userService;
        this.emailService = emailService;
    }
    // 아이디 중복 검사
    @GetMapping("/exists/id/{userId}")
    public boolean checkUserIdExists(@PathVariable String userId) {
        System.out.println("Checking user ID exists: " + userId);
        return userService.checkUserIdExists(userId);
    }
    //이메일 중복 검사
    @GetMapping("/exists/email/{email}")
    public boolean checkUserEmailExists(@PathVariable String email) {
        System.out.println("Checking email exists: " + email);

        return userService.checkUserEmailExists(email);
    }
    // 회원가입
    @PostMapping("/register")
    public Map<String , Object> registerUser(@RequestBody UsersDTO usersDTO) {
        Map<String , Object> result = new HashMap<>();
        return result;
    }


}
