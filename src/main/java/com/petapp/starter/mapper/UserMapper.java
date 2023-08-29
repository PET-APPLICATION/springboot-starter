package com.petapp.starter.mapper;

import com.petapp.starter.dto.UserCreateRequest;
import com.petapp.starter.dto.UserCreateResponse;
import com.petapp.starter.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author ivan.graciarena
 * @project spring-boot-starter
 */
@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserEntity map(UserCreateRequest userCreateRequest);

    UserCreateResponse map(UserEntity userEntity);
}
