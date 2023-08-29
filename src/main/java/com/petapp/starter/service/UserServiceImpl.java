package com.petapp.starter.service;

import com.petapp.starter.dao.UserRepository;
import com.petapp.starter.dto.UserCreateRequest;
import com.petapp.starter.dto.UserCreateResponse;
import com.petapp.starter.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * @author ivan.graciarena
 * @project spring-boot-starter
 */

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper = UserMapper.INSTANCE;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserCreateResponse addUser(UserCreateRequest userCreateRequest) {
        var userEntityToBeSaved = userMapper.map(userCreateRequest);
        userRepository.save(userEntityToBeSaved);
        return userMapper.map(userEntityToBeSaved);
    }
}
