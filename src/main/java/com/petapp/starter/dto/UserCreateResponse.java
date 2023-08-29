package com.petapp.starter.dto;

import lombok.*;

import java.util.List;

/**
 * @author ivan.graciarena
 * @project spring-boot-starter
 */
@Value
@EqualsAndHashCode
@Builder(builderClassName = "Builder")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserCreateResponse {
    String userName;
    String email;
}
