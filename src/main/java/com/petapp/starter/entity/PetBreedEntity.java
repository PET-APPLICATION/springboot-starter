package com.petapp.starter.entity;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.Instant;

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
@Table(name = "pet_breed")
public class PetBreedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    Double id;
    String breedName;

    @ManyToOne
    @Cascade(MERGE)
    @JoinColumn(name = "pet_type_id", nullable = false)
    PetTypeEntity petType;

    private Instant createdDate;
    private Instant modifiedDate;
    private boolean isDeleted;
    @Builder.Default
    private boolean isActive = true;
}
