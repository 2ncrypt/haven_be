package com.pain.haven.user.controller;

import com.pain.haven.user.domain.user.UserDto;
import com.pain.haven.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired  // 생성자 주입 명시적 설정
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 회원가입
    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.registerUser(userDto));
    }

    @GetMapping("/exists/id/{userId}")
    public boolean checkUserIdExists(@PathVariable String userId) {
        System.out.println("Checking user ID exists: " + userId);
        return userService.checkUserIdExists(userId);
    }

    @GetMapping("/exists/email/{email}")
    public boolean checkUserEmailExists(@PathVariable String email) {
        System.out.println("Checking email exists: " + email);
        return userService.checkUserEmailExists(email);
    }

}
