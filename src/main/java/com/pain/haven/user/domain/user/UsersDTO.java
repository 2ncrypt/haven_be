package com.pain.haven.user.domain.user;

import com.pain.haven.user.domain.users_access.UsersAccessDTO;
import com.pain.haven.user.domain.users_agree.UsersAgreeDTO;
import com.pain.haven.user.domain.users_log.UsersLogDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersDTO {
    private String userId;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private String createdId;
    private LocalDateTime createdDt;
    private String modifiedId;
    private LocalDateTime modifiedDt;

    private UsersAgreeDTO usersAgree;   // users_agree 테이블에 해당하는 DTO
    private UsersLogDTO usersLog;       // users_log 테이블에 해당하는 DTO
    private UsersAccessDTO usersAccess; // users_access 테이블에 해당하는 DTO
    // Getters and Setters
}