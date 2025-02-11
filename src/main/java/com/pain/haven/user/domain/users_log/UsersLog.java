package com.pain.haven.user.domain.users_log;

import com.pain.haven.user.domain.user.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users_log")
public class UsersLog {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_log_id_seq")
    @SequenceGenerator(name = "users_log_id_seq", sequenceName = "users_log_id_seq", allocationSize = 1)
    @Column(name = "id", length = 20, nullable = false)
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private Users user;

    @Column(name = "login_access", nullable = false)
    private Boolean loginAccess;

    @Column(name = "login_ip", length = 50)
    private String loginIp;

    @Column(name = "login_dt", nullable = false)
    private LocalDateTime loginDt;

    @Column(name = "created_id", length = 20)
    private String createdId;

    @Column(name = "created_dt", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdDt;

    @Column(name = "modified_id", length = 20)
    private String modifiedId;

    @Column(name = "modified_dt", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
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