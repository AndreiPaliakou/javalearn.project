package com.apaliakou.homework15.service.impl;

import com.apaliakou.homework15.model.User;
import com.apaliakou.homework15.service.api.MessageCreator;

import java.util.List;

public class MessageCreatorImpl implements MessageCreator {

    @Override
    public String createMessage(List<String> recipients, String theme) {
        return "The message text /" + theme + "/ was sent to the next mails: " + recipients.stream().toList();
    }

    @Override
    public String createPersonalMessage(User user, String theme) {
        return "The personal message text for user / " + user.getFirstName() + " "
                + user.getLastName() + " /: " + theme;
    }
}

