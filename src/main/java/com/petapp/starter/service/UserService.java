package com.petapp.starter.service;

import com.petapp.starter.dto.UserCreateRequest;
import com.petapp.starter.dto.UserCreateResponse;

/**
 * @author ivan.graciarena
 * @project spring-boot-starter
 */
public interface UserService {
    UserCreateResponse addUser(UserCreateRequest userCreateRequest);
}
