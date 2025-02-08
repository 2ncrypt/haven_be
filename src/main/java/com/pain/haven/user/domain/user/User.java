package com.pain.haven.user.domain.user;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")  // PostgreSQL에서는 소문자 + snake_case 사용
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 자동 증가 (PostgreSQL에서 SERIAL 역할)
    @Column(name = "user_id")
    private Long userId;  // 기본 키 (Long 타입)

    @Column(name = "password", nullable = false)
    private String password;  // 비밀번호

    @Column(name = "name", nullable = false, length = 50)
    private String name;  // 사용자 이름

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;  // 이메일 (유니크)

    @Column(name = "phone_number", nullable = false, length = 20)
    private String phoneNumber;  // 전화번호 (앞자리 0 유지)

    @Column(name = "sns_code", nullable = false)
    private Integer snsCode;  // SNS 연동 코드 (00 없음, 01 카카오, 02 구글, 03 미정)

    @Column(name = "created_id", nullable = false)
    private String createdId;  // 최초 등록자 ID

    @Column(name = "created_dt", nullable = false, updatable = false)
    private LocalDateTime createdDt;  // 최초 생성일

    @Column(name = "updated_id")
    private String updatedId;  // 최근 수정자 ID

    @Column(name = "updated_dt")
    private LocalDateTime updatedDt;  // 최근 수정일

    @PrePersist
    protected void onCreate() {
        this.createdDt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedDt = LocalDateTime.now();
    }
}
