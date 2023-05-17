package com.apaliakou.homework15.service.impl;

import com.apaliakou.homework15.exception.RecipientsException;
import com.apaliakou.homework15.model.User;
import com.apaliakou.homework15.model.enums.Topic;
import com.apaliakou.homework15.service.api.MailSender;
import com.apaliakou.homework15.service.api.MailService;
import com.apaliakou.homework15.service.api.MessageCreator;
import com.apaliakou.homework15.service.api.UserService;
import com.apaliakou.homework15.util.UserMailExtractor;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.apaliakou.homework15.model.enums.Topic.BUG;
import static com.apaliakou.homework15.model.enums.Topic.TASK;

public class MailServiceImpl implements MailService {

    private final MessageCreator messageCreator;
    private final UserService userService;
    private final MailSender mailSender;

    public MailServiceImpl(MessageCreator messageCreator, UserService userService, MailSender mailSender) {
        this.messageCreator = messageCreator;
        this.userService = userService;
        this.mailSender = mailSender;
    }


    @Override
    public void sendMessageAboutBug() {
        List<User> listOfUsers = userService.getAllUsers();

        List<String> recipients = UserMailExtractor.getMailsFromUsers(listOfUsers);

        checkRecipients(recipients);

        String message = messageCreator.createMessage(recipients, BUG.getText());

        mailSender.sendMail(message);
    }

    @Override
    public String sendPersonalMessage(User user) {
        String personalMessage = messageCreator.createPersonalMessage(user, TASK.getText());

        mailSender.sendMail(personalMessage);

        return personalMessage;
    }

    @Override
    public void sendMeDummyMessagesForAllTopics() {
        User currentUser = userService.getCurrentUser()
                .orElseThrow(NoSuchElementException::new);

        Set<String> messages = getMessagesForUser(currentUser);

        messages.forEach(mailSender::sendMail);
    }

    @Override
    public Map<String, User> getUsersEmails() {
        return userService.getAllUsers().stream()
                .collect(Collectors.toMap(User::getEmail, Function.identity()));
    }

    private void checkRecipients(List<String> recipients) {
        if (recipients.isEmpty()) {
            throw new RecipientsException("Recipients list is empty!!!");
        }
    }

    public Set<String> getMessagesForUser(User currentUser) {
        return Arrays.stream(Topic.values())
                .map(Topic::getText)
                .map(text -> messageCreator.createPersonalMessage(currentUser, text))
                .collect(Collectors.toSet());
    }
}