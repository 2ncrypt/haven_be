package com.pain.haven.user.domain.users_agree;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersAgreeDTO {

    private String id;
    private String userId;
    private boolean termsAgree;
    private LocalDateTime termsAgreeDt;
    private boolean privacyPolicyAgree;
    private LocalDateTime privacyPolicyAgreeDt;
    private boolean ageVerification;
    private LocalDateTime ageVerificationDt;
    private boolean thirdPartyAgree;
    private LocalDateTime thirdPartyAgreeDt;
    private boolean marketingAgree;
    private LocalDateTime marketingAgreeDt;
    private String createdId;
    private LocalDateTime createdDt;
    private String modifierId;
    private LocalDateTime modifierDt;
}