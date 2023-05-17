package com.apaliakou.homework15.service.impl;

import com.apaliakou.homework15.model.User;
import com.apaliakou.homework15.service.api.UserService;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class UserServiceImpl implements UserService {

    private static final List<User> listOfUsers = List.of(
            new User("Ivan", "Ivanov", "ivanov@mail.ru"),
            new User("Petya", "Petrov", "petrov@mail.ru"),
            new User("Fedot", "Fedotov", "fedotov@mail.ru"));

    @Override
    public List<User> getAllUsers() {
        return listOfUsers;
    }

    @Override
    public Optional<User> getCurrentUser() {
        Random rand = new Random();
        return Optional.of(listOfUsers.get(rand.nextInt(listOfUsers.size())));
    }
}
