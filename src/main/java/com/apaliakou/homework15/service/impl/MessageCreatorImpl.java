package com.apaliakou.homework15.service.impl;

import com.apaliakou.homework15.model.User;
import com.apaliakou.homework15.service.api.MessageCreator;

import java.util.List;

public class MessageCreatorImpl implements MessageCreator {

    private List<String> recipients;

    private String theme;

    public List<String> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<String> recipients) {
        this.recipients = recipients;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Override
    public String createMessage(List<String> recipients, String theme) {
        String newMessage = theme + System.lineSeparator() + recipients.stream().toString();
        return newMessage;
    }

    @Override
    public String createPersonalMessage(User user, String theme) {
        String newMessage = "Personal message for user: " + user.getFirstName() + " "
                + user.getLastName() + System.lineSeparator() + theme;
        return newMessage;
    }
}
