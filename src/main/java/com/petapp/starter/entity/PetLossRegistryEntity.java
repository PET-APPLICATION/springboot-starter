package com.petapp.starter.entity;

import com.petapp.starter.domain.Location;
import lombok.*;
import org.hibernate.annotations.Cascade;

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
@Table(name = "pet_loss_registry")
public class PetLossRegistryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    Double id;

    String description;
    LocalDateTime timestamp;

    @ManyToOne
    @Cascade(MERGE)
    @JoinColumn(name = "location_id", nullable = false)
    LocationEntity location;

    private Instant createdDate;
    private Instant modifiedDate;
    private boolean isDeleted;
    @Builder.Default
    private boolean isActive = true;
}
