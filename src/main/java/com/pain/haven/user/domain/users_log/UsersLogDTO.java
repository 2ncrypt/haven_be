package com.pain.haven.user.domain.users_log;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersLogDTO {

    private String id;
    private String userId;
    private Boolean loginAccess;
    private String loginIp;
    private LocalDateTime loginDt;
    private String createdId;
    private LocalDateTime createdDt;
    private String modifierId;
    private LocalDateTime modifierDt;
}