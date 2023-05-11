package com.apaliakou.homework15.util;

import com.apaliakou.homework15.model.User;

import java.util.List;
import java.util.stream.Collectors;

public final class UserMailExtractor {


    private UserMailExtractor() {
    }

    public static List<String> getMailsFromUsers(List<User> users) {
        return users.stream()
                .map(User::getEmail)
                .collect(Collectors.toList());
    }
}
