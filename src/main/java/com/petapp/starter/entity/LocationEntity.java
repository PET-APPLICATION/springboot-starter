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
@Table(name = "location")
public class LocationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    Double id;
    String latitude;
    String longitude;

    private Instant createdDate;
    private Instant modifiedDate;
    private boolean isDeleted;
    @Builder.Default
    private boolean isActive = true;
}
