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
@Table(name = "pet")
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    Double id;

    String petName;
    Integer age;
    String description;
    boolean isLost;

    @ManyToOne
    @Cascade(MERGE)
    @JoinColumn(name = "pet_breed_id", nullable = false)
    PetBreedEntity petBreed;

    @Column(name = "user_id", insertable = false, updatable = false)
    private Integer userId;

    private Instant createdDate;
    private Instant modifiedDate;
    private boolean isDeleted;
    @Builder.Default
    private boolean isActive = true;
}
