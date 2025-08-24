package com.bmt.model.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "user_login_update_details")
public class UserLoginUpdateDetails {

    @Id
    @Column(columnDefinition = "CHAR(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;
    @Column(name = "old_email", length = 255)
    private String oldEmail;
    @Column(name = "old_phone", length = 255)
    private String oldPhone;
    @Column(name = "old_username", length = 255)
    private String oldUsername;
    @Column(name = "new_email", length = 255)
    private String newEmail;
    @Column(name = "new_phone", length = 255)
    private String newPhone;
    @Column(name = "new_username", length = 255)
    private String newUsername;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 255)
    private RequestStatus status = RequestStatus.PENDING;

    @ManyToOne
    @JoinColumn(name = "unverified_user_id", nullable = false)
    private UnverifiedUser unverifiedUser;

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

