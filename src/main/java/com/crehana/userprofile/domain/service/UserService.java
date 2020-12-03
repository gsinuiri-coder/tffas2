package com.crehana.userprofile.domain.service;

import com.crehana.userprofile.domain.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long userId);
    User createUser(User user);
    User updateUser(Long userId, User userDetails);
    ResponseEntity<?> deleteUser(Long userId);
}
