package com.apaliakou.homework15.service.api;

import com.apaliakou.homework15.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> getCurrentUser();

    List<User> getAllUsers();
}
