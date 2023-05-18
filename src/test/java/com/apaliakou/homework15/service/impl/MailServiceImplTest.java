package com.apaliakou.homework15.service.impl;

import com.apaliakou.homework15.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MailServiceImplTest {

    @Mock
    private MessageCreatorImpl messageCreatorImplMock;

    @Mock
    private UserServiceImpl userServiceImplMock;

    @Mock
    private MailSenderImpl mailSenderImplMock;

    @InjectMocks
    private MailServiceImpl mailServiceImpl;

    @Test
    public void sendPersonalMessage_Test() {
        String expectedPersonalMessage = "Fuck!!!!!!!!";

        when(messageCreatorImplMock.createPersonalMessage(any(User.class),
                anyString())).thenReturn(expectedPersonalMessage);

        User inputUser = new User("Andrei", "Paliakou", "mortis2008@mail.ru");
        String actualPersonalMessage = mailServiceImpl.sendPersonalMessage(inputUser);
        assertThat(actualPersonalMessage).isEqualTo(expectedPersonalMessage);
    }

    @Test
    public void getUsersEmails_Test() {
        Map<String, User> expectedMap = new HashMap<>();
        User user1 = new User("Petya", "Petrov", "petrov@mail.ru");
        User user2 = new User("Fedot", "Fedotov", "fedotov@mail.ru");
        User user3 = new User("Ivan", "Ivanov", "ivanov@mail.ru");
        expectedMap.put(user1.getEmail(), user1);
        expectedMap.put(user2.getEmail(), user2);
        expectedMap.put(user3.getEmail(), user3);

        List<User> users = Arrays.asList(user1, user2, user3);

        when(userServiceImplMock.getAllUsers()).thenReturn(users);

        Map<String, User> actualMap = mailServiceImpl.getUsersEmails();

        assertThat(actualMap).isEqualTo(expectedMap);
    }

    @Test
    public void sendMessageAboutBug_Test() {
        when(userServiceImplMock.getAllUsers()).thenReturn(List.of(new User("Petya", "Petrov", "petrov@mail.ru")));
        when(messageCreatorImplMock.createMessage(anyList(), anyString())).thenReturn("BUG");

        mailServiceImpl.sendMessageAboutBug();

        verify(userServiceImplMock, times(1)).getAllUsers();
        verify(messageCreatorImplMock, times(1)).createMessage(anyList(), anyString());
        verify(mailSenderImplMock, times(1)).sendMail(anyString());
    }

    @Test
    public void sendMeDummyMessagesForAllTopics_Test() {
        when(userServiceImplMock.getCurrentUser()).thenReturn(Optional.of(new User("Ivan", "Ivanov", "ivanov@mail.ru")));
        when(messageCreatorImplMock.createPersonalMessage(any(User.class), anyString())).thenReturn("BUG");

        mailServiceImpl.sendMeDummyMessagesForAllTopics();

        verify(userServiceImplMock, times(1)).getCurrentUser();
        verify(mailSenderImplMock, times(1)).sendMail("BUG");
        verify(messageCreatorImplMock, times(3)).createPersonalMessage(any(User.class), anyString());
    }
}
