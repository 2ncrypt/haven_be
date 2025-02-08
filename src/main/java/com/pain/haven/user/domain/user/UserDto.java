package com.pain.haven.user.domain.user;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private String id;
    private String userId;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private Integer snsCode;
    private String createdId;
    private LocalDateTime createdDt;
    private String updatedId;
    private LocalDateTime updatedDt;

    // 엔티티 -> DTO 변환 메서드
    public static UserDto fromEntity(User user) {
        return UserDto.builder()
                .id(user.getId())
                .userId(user.getUserId())
                .password(user.getPassword())
                .name(user.getName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .snsCode(user.getSnsCode())
                .createdId(user.getCreatedId())
                .createdDt(user.getCreatedDt())
                .updatedId(user.getUpdatedId())
                .updatedDt(user.getUpdatedDt())
                .build();
    }

    // DTO -> 엔티티 변환 메서드
    public User toEntity() {
        return User.builder()
                .id(this.id)
                .userId(this.userId)
                .password(this.password)
                .name(this.name)
                .email(this.email)
                .phoneNumber(this.phoneNumber)
                .snsCode(this.snsCode)
                .createdId(this.createdId)
                .createdDt(this.createdDt)
                .updatedId(this.updatedId)
                .updatedDt(this.updatedDt)
                .build();
    }
}
