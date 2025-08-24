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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "personal_information")
public class PersonalInformation {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "CHAR(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    @OneToMany(mappedBy = "personalInformation", cascade = CascadeType.ALL)
    private List<FamilyInformation> familyInformation = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "first_name", length = 100)
    private String firstName;

    @Column(name = "middle_name", length = 100)
    private String middleName;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @Column(name = "full_name", length = 100)
    private String fullName;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", length = 15)
    private Gender gender;

    @Column(name = "marital_status", length = 100)
    private String maritalStatus;

    @Column(name = "profile_pic_url", length = 500)
    private String profilePicUrl;

    @Column(name = "date_of_birth", nullable = false, length = 100)
    private LocalDate dataOfBirth;

    @Column(name = "marriage_anniversary", nullable = false, length = 100)
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
