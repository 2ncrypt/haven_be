package com.pain.haven.user.domain.user;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private String user_id;
    private String password;
    private String name;
    private String email;
    private String phone_number;
    private Integer sns_code;     // 00 없음     // 01 카카오    // 02 구글    // 03 미정
    private String created_id;
    private LocalDateTime created_dt;
    private String updated_id;
    private LocalDateTime updated_dt;
}
