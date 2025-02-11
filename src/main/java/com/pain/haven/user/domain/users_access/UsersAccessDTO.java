package com.pain.haven.user.domain.users_access;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersAccessDTO {

    private String id;
    private String userId;
    private boolean emailAccess;
    private LocalDateTime emailAccessDt;
    private String emailVerifyCode;
    private boolean snsAccess;
    private LocalDateTime snsAccessDt;
    private String createdId;
    private LocalDateTime createdDt;
    private String modifierId;
    private LocalDateTime modifierDt;
}