package com.crehana.userprofile.controller;

import com.crehana.userprofile.domain.model.User;
import com.crehana.userprofile.domain.service.UserService;
import com.crehana.userprofile.resource.SaveUserResource;
import com.crehana.userprofile.resource.UserResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@Tag(name = "Users", description = "Users API")
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserService userService;

    @Operation(summary = "Get All Users", description = "Get All available Users", responses = {
            @ApiResponse(
                    description = "All Users",
                    responseCode = "200",
                    content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/users")
    public List<UserResource> getAllUsers() {
        return userService.getAllUsers()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
    }

    @GetMapping("/users/{userId}")
    public UserResource getUserById(@PathVariable(value = "userId") Long userId) {
        return convertToResource(userService.getUserById(userId));
    }

    @PostMapping("/users")
    public UserResource createUser(
            @Valid @RequestBody SaveUserResource resource) {
        User user = convertToEntity(resource);
        return convertToResource(userService.createUser(user));
    }

    @PutMapping("/users/{userId}")
    public UserResource updateUser(@PathVariable Long userId,
                                   @Valid @RequestBody SaveUserResource resource) {
        User user = convertToEntity(resource);
        return convertToResource(
                userService.updateUser(userId, user));
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }

    private User convertToEntity(SaveUserResource resource) {
        return mapper.map(resource, User.class);
    }
    private UserResource convertToResource(User entity) {
        return mapper.map(entity, UserResource.class);
    }
}
