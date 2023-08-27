package com.petapp.starter.service;

import com.petapp.starter.dao.UserRepository;
import com.petapp.starter.dto.UserCreateRequest;
import com.petapp.starter.dto.UserCreateResponse;
import com.petapp.starter.mapper.UserMapper;

/**
 * @author ivan.graciarena
 * @project spring-boot-starter
 */
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserCreateResponse addUser(UserCreateRequest userCreateRequest) {
        var userEntityToBeSaved = UserMapper.INSTANCE.map(userCreateRequest);
        userRepository.save(userEntityToBeSaved);
        return UserMapper.INSTANCE.map(userEntityToBeSaved);
    }
}
