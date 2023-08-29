package com.petapp.starter.entity;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

import static org.hibernate.annotations.CascadeType.*;

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
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    Long id;
    @Column(unique = true)
    String userName;
    String firstName;
    String lastName;
    @Column(unique = true)
    String email;
    String password;
    String phoneNumber;

    @OneToOne
    @Cascade(MERGE)
    @JoinColumn(name = "location_id")
    LocationEntity location;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = PetEntity.class)
    @Cascade(value = {REMOVE, MERGE, PERSIST})
    @JoinColumn(name = "pet_id", nullable = false)
    List<PetEntity> pets;

    @CreatedDate
    private Instant createdDate;
    @LastModifiedDate
    private Instant modifiedDate;
    private boolean isDeleted;
    @Builder.Default
    private boolean isActive = true;
}
