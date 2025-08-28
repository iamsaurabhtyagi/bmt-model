package com.common.model.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "otp_tokens")
public class OtpToken {

    @Id
    @Column(columnDefinition = "CHAR(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    @Column(name = "otp", nullable = false, length = 10)
    private String otp;

    @Column(name = "expiry_time", nullable = false)
    private LocalDateTime expiryTime;

    @Column(name = "is_used", nullable = false)
    private boolean isUsed = false;

    @Enumerated(EnumType.STRING)
    @Column(name = "token_status", nullable = false)
    private TokenStatus tokenStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "purpose", length = 50)
    private OtpPurpose purpose; // e.g., "registration", "login", etc.

    @Column(name = "delivered", nullable = false)
    private boolean delivered = false;

    @ManyToOne(optional = false)
    @JoinColumn(name = "unverified_user_id", nullable = false)
    private UnverifiedUser unverifiedUser;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }
}
