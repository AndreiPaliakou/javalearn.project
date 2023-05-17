package com.apaliakou.homework15.service.api;

import com.apaliakou.homework15.model.User;
import java.util.Map;

public interface MailService {
    void sendMessageAboutBug();

    String sendPersonalMessage(User user);

    void sendMeDummyMessagesForAllTopics();

    Map<String, User> getUsersEmails();
}
