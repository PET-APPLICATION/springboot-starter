package com.petapp.starter.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author ivan.graciarena
 * @project spring-boot-starter
 */
@Value
@EqualsAndHashCode
@Builder(builderClassName = "Builder")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserCreateRequest {

    @NotBlank
    @Email(regexp = "^[a-zA-Z0-9_!#$%&*+/=?`'{|}~^.-]+@[a-zA-Z0-9.-]+$")
    String email;
    @NotBlank
    String firstName;
    @NotBlank
    String lastName;
    @NotBlank
    String userName;
    String password;
    String phoneNumber;
}
