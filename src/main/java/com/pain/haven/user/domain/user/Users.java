package com.pain.haven.user.domain.user;

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
@Table(name = "users")
public class Users {
    @Id
    @Column(name = "id", length = 20)
    private String id;

    @Column(name = "user_id", length = 20, nullable = false)
    private String userId;

    @Column(name = "password", length = 255, nullable = false)
    private String password;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "phone_number", length = 20, nullable = false)
    private String phoneNumber;

    @Column(name = "created_id", length = 20)
    private String createdId;

    @Column(name = "created_dt", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdDt;

    @Column(name = "modified_id", length = 20)
    private String modifiedId;

    @Column(name = "modified_dt", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime modifiedDt;

}