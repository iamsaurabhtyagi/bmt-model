package com.bmt.model.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "family_information")
public class FamilyInformation {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "CHAR(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "personal_information_id", nullable = false)
    private PersonalInformation personalInformation;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "relationship", length = 100)
    private String relationship;

    @Enumerated(EnumType.STRING)
    @Column(name = "marital_status", length = 100)
    private MaritalStatus maritalStatus;

    @Column(name = "date_of_birth", length = 100)
    private LocalDate dataOfBirth;

    @Column(name = "marriage_anniversary", length = 100)
    private LocalDate marriageAnniversary;

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
