package com.apaliakou.homework15.service.impl;

import com.apaliakou.homework15.model.User;
import com.apaliakou.homework15.service.api.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Override
    public Optional<User> getCurrentUser() {
        return Optional.of(new User("123", "123", "123"));
    }

    @Override
    public List<User> getDevelopers() {
        return List.of(new User("123", "123", "123"));
    }
}
