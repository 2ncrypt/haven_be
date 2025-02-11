package com.pain.haven.user.domain.users_agree;

import com.pain.haven.user.domain.user.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users_agree")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersAgree {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_agree_id_seq")
    @SequenceGenerator(name = "users_agree_id_seq", sequenceName = "users_agree_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "terms_agree", nullable = false)
    private boolean termsAgree;

    @Column(name = "terms_agree_dt")
    private LocalDateTime termsAgreeDt;

    @Column(name = "privacy_policy_agree", nullable = false)
    private boolean privacyPolicyAgree;

    @Column(name = "privacy_policy_agree_dt")
    private LocalDateTime privacyPolicyAgreeDt;

    @Column(name = "age_verification", nullable = false)
    private boolean ageVerification;

    @Column(name = "age_verification_dt")
    private LocalDateTime ageVerificationDt;

    @Column(name = "third_party_agree", nullable = false)
    private boolean thirdPartyAgree;

    @Column(name = "third_party_agree_dt")
    private LocalDateTime thirdPartyAgreeDt;

    @Column(name = "marketing_agree", nullable = false)
    private boolean marketingAgree;

    @Column(name = "marketing_agree_dt")
    private LocalDateTime marketingAgreeDt;

    @Column(name = "created_id", length = 20)
    private String createdId;

    @Column(name = "created_dt", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdDt;

    @Column(name = "modified_id", length = 20)
    private String modifiedId;

    @Column(name = "modified_dt", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime modifiedDt;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private Users users;

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