package com.common.model.party;

import com.common.model.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Getter
@Setter
@Entity
@Table(name = "party_requests")
public class PartyRequest {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "CHAR(36)")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private User customer;

    private String title;
    private String description;
    private LocalDate eventDate;
    private Integer expectedGuests;
    private String preferredLocation;
    private String budgetRange;
    private LocalDateTime createdAt;

    // Getters, setters, constructors omitted for brevity
}
