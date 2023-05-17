package com.apaliakou.homework15;

import com.apaliakou.homework15.model.User;
import com.apaliakou.homework15.service.impl.MailSenderImpl;
import com.apaliakou.homework15.service.impl.MailServiceImpl;
import com.apaliakou.homework15.service.impl.MessageCreatorImpl;
import com.apaliakou.homework15.service.impl.UserServiceImpl;
import com.apaliakou.homework15.util.UserMailExtractor;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import static com.apaliakou.homework15.model.enums.Topic.BUG;
import static com.apaliakou.homework15.model.enums.Topic.TASK;

public class Main {
    public static void main(String[] args) {
// void sendMessageAboutBug() method simulation
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        List<User> listOfUsers = userServiceImpl.getAllUsers(); //      1. get users list

        List<String> listOfMails = UserMailExtractor.getMailsFromUsers(listOfUsers);//      2. extract users mails from users

        MessageCreatorImpl messageCreatorImpl = new MessageCreatorImpl();
        String message = messageCreatorImpl.createMessage(listOfMails, BUG.getText());//     3. create message "Bug was found"

        MailSenderImpl mailSenderImpl = new MailSenderImpl();
        mailSenderImpl.sendMail(message);//                         4. send message about bug to the mail
        System.out.println();

// String sendFirstInvitation(User user) method simulation

        User user = new User("Andrei", "Paliakou", "mortis2008@mail.ru");//     1. create user

        String personalMessage = messageCreatorImpl.createPersonalMessage(user, TASK.getText());//      2. create personal message "Task was created"

        mailSenderImpl.sendMail(personalMessage);//     3. send message about task to the mail
        System.out.println();

// void sendMeDummyMessagesForAllTopics() method simulation
        User currentUser = userServiceImpl.getCurrentUser().orElseThrow(NoSuchElementException::new);//     1. get current user
        MailServiceImpl mailServiceImpl = new MailServiceImpl(messageCreatorImpl, userServiceImpl, mailSenderImpl);
        Set<String> messages = mailServiceImpl.getMessagesForUser(currentUser);//       2. create set of messages
        messages.forEach(mailSenderImpl::sendMail);//       3. send messages to the mails
        System.out.println();

// getDeveloperEmails() method simulation
        Map<String, User> map = mailServiceImpl.getUsersEmails();// get the map with "mail - user" pairs
        map.forEach((key, value) -> System.out.println(key + "\t: " + value.getFirstName() + " " + value.getLastName()));
    }
}
