package com.apaliakou.homework15;

import com.apaliakou.homework15.model.User;
import com.apaliakou.homework15.model.enums.Topic;
import com.apaliakou.homework15.service.impl.MailSenderImpl;
import com.apaliakou.homework15.service.impl.MessageCreatorImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageCreatorImpl messageCreatorImpl = new MessageCreatorImpl();

        String[] recipientsArray = {"fakeSite1.com", "fakeSite2.ru", "fakeSite3.by"};
        List<String> recipientsArrayList = List.of(recipientsArray);
        messageCreatorImpl.createMessage(recipientsArrayList, Topic.BUG.getText());

        User user = new User("Andrei", "Paliakou", "mortis2008@mail.ru");
        messageCreatorImpl.createPersonalMessage(user, Topic.BUG.getText());

        MailSenderImpl mailSenderImpl = new MailSenderImpl();
        String mail = "FOR RECIPIENTS";
        mailSenderImpl.sendMail(mail);


    }
}
