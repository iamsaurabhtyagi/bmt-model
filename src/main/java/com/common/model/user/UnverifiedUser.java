package com.common.model.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "unverified_users")
public class UnverifiedUser {

    @Id
    @Column(columnDefinition = "CHAR(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    @Column(name = "user_id", columnDefinition = "CHAR(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID userId;

    @Column(name = "username", unique = true, length = 100)
    private String username;

    @Column(name = "email", unique = true, length = 100)
    private String email;

    @Column(name = "phone", unique = true, length = 10)
    private String phone;

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "pin", length = 255)
    private String pin;

    @Column(name = "verified", nullable = false)
    private Boolean verified = false;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type", nullable = false, length = 20)
    private UserType userType;

    @OneToMany(mappedBy = "unverifiedUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OtpToken> otpTokens = new ArrayList<>();

    @OneToMany(mappedBy = "unverifiedUser", cascade = CascadeType.ALL)
    private List<UserLoginUpdateDetails> loginUpdateRequests = new ArrayList<>();

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }
}

