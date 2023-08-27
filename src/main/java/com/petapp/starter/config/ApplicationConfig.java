package com.petapp.starter.config;

import com.petapp.starter.dao.UserRepository;
import com.petapp.starter.service.UserService;
import com.petapp.starter.service.UserServiceImpl;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author ivan.graciarena
 * @project spring-boot-starter
 */
@Configuration
@EnableJpaRepositories("com.petapp.starter.dao")
@EntityScan("com.petapp.starter.entity")
public class ApplicationConfig {

    @Bean
    public UserService userService(final UserRepository userRepository) {
        return new UserServiceImpl(userRepository);
    }
}
