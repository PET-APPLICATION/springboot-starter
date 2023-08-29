package com.petapp.starter.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author ivan.graciarena
 * @project spring-boot-starter
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
public class PetLossRegistry {
    Double id;
    Location location;
    String description;
    LocalDateTime timestamp;
}
