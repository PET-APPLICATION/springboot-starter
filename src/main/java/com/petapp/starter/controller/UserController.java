package com.petapp.starter.controller;

import com.petapp.starter.dto.UserCreateRequest;
import com.petapp.starter.dto.UserCreateResponse;
import com.petapp.starter.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author ivan.graciarena
 * @project spring-boot-starter
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Operation(summary = "Create user.", description = "Create user and saved into the database.",
            responses = {@ApiResponse(responseCode = "201", description = "CREATED",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))})
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserCreateResponse> addUser(@Valid @RequestBody UserCreateRequest userCreateRequest) {
        var userCreateResponse = userService.addUser(userCreateRequest);
        LOGGER.debug("User Created successfully: {} ", userCreateResponse);
        return new ResponseEntity<>(userCreateResponse, HttpStatus.CREATED);
    }
}
