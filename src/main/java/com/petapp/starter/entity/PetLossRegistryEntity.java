package com.petapp.starter.entity;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;

import static org.hibernate.annotations.CascadeType.MERGE;

/**
 * @author ivan.graciarena
 * @project spring-boot-starter
 */
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "pet_loss_registries")
public class PetLossRegistryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    Long id;

    String description;
    LocalDateTime timestamp;

    @OneToOne
    @Cascade(MERGE)
    @JoinColumn(name = "location_id", nullable = false)
    LocationEntity location;

    @OneToOne
    @Cascade(MERGE)
    @JoinColumn(name = "pet_id")
    PetEntity pet;

    @CreatedDate
    private Instant createdDate;

    @LastModifiedDate
    private Instant modifiedDate;
    private boolean isDeleted;
    @Builder.Default
    private boolean isActive = true;
}
