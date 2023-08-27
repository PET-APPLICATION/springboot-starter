package com.petapp.starter.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author ivan.graciarena
 * @project spring-boot-starter
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
public class User {
    Double id;
    String name;
    String lastName;
    Location location;
    String description;
    List<Pet> pets;
    String password;
    String phoneNumber;
}
