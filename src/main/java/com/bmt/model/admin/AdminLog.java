package com.bmt.model.admin;

import com.bmt.model.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.*;

@Getter
@Setter
@Entity
@Table(name = "admin_logs")
public class AdminLog {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "CHAR(36)")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private User admin;

    private String action;
    private String targetType;
    private UUID targetId;
    private String message;
    private LocalDateTime createdAt;

}
