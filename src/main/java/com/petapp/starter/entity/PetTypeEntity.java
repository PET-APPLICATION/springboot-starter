package com.petapp.starter.entity;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

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
@Table(name = "pet_type")
public class PetTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    Double id;

    String typeName;

    private Instant createdDate;
    private Instant modifiedDate;
    private boolean isDeleted;
    @Builder.Default
    private boolean isActive = true;
}
