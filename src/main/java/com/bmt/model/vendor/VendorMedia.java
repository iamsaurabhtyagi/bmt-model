package com.bmt.model.vendor;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Table(name = "vendor_media")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VendorMedia {

    @Id
    @Column(columnDefinition = "CHAR(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id", nullable = false, foreignKey = @ForeignKey(name = "fk_media_vendor"))
    private Vendor vendor;

    @Column(name = "media_type", length = 50, nullable = false)
    private String mediaType;

    @Column(name = "url", length = 500, nullable = false)
    private String url;

    @Column(name = "description", length = 255)
    private String description;
}