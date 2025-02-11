package com.pain.haven.user.domain.users_access;

import com.pain.haven.user.domain.user.Users;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users_access")
public class UsersAccess {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_access_id_seq")
    @SequenceGenerator(name = "users_access_id_seq", sequenceName = "users_access_id_seq", allocationSize = 1)
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private Users user;  // User와 연결된 외래키

    @Column(name = "user_id", nullable = false) // userId 컬럼을 명확히 추가
    private String userId; // 외래키로서 사용

    @Column(nullable = false)  // 이메일 인증 여부 필드
    private boolean emailAccess;

    @Column(nullable = true)   // 이메일 인증 일자
    private LocalDateTime emailAccessDt;

    @Column(nullable = true)   // 이메일 인증 코드
    private String emailVerifyCode;

    @Column(nullable = false)  // SNS 연동 여부 필드
    private boolean snsAccess;

    @Column(nullable = true)   // SNS 연동 일자
    private LocalDateTime snsAccessDt;

    @Column(nullable = false)  // 생성자 ID 필드
    private String createdId;

    @Column(nullable = true)   // 생성 일자
    private LocalDateTime createdDt;

    @Column(nullable = true)   // 수정자 ID 필드
    private String modifiedId;

    @Column(nullable = true)   // 수정 일자
    private LocalDateTime modifiedDt;

    @PrePersist
    public void prePersist() {
        // 최초 등록 시 등록자와 등록일자 자동 설정
        if (createdId == null) {
            createdId = "SYSTEM";  // 예시로 시스템 ID로 설정
            createdDt = LocalDateTime.now(); // 현재 시간으로 설정
        }
    }

    @PreUpdate
    public void preUpdate() {
        // 수정 시 수정자와 수정일자 자동 설정
        if (modifiedId == null) {
            modifiedId = "SYSTEM"; // 예시로 수정자 ID 설정
            modifiedDt = LocalDateTime.now(); // 현재 시간으로 수정일자 설정
        }
    }
}
