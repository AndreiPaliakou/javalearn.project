package com.apaliakou.homework15.service.impl;

import com.apaliakou.homework15.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
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
    public void check_sendPersonalMessage() {
        String expectedPersonalMessage = "Fuck!!!!!!!!";

        Mockito.when(messageCreatorImplMock.createPersonalMessage(Mockito.any(User.class), Mockito.anyString())).thenReturn(expectedPersonalMessage);

        User inputUser = new User("Andrei", "Paliakou", "mortis2008@mail.ru");
        String actualPersonalMessage = mailServiceImpl.sendPersonalMessage(inputUser);
        assertThat(actualPersonalMessage).isEqualTo(expectedPersonalMessage);
    }

    @Test
    public void check_getUsersEmails(){
        User user1 = new User("Petya", "Petrov", "petrov@mail.ru");
        User user2 = new User("Fedot", "Fedotov", "fedotov@mail.ru");
        User user3 = new User("Ivan", "Ivanov", "ivanov@mail.ru");
        Map<String, User> map = null;
        map.put(user1.getEmail(), user1);
        map.put(user2.getEmail(), user2);
        map.put(user3.getEmail(), user3);
        Map<String, User> expectedMap = map;
        Mockito.when(userServiceImplMock.getAllUsers().stream().map(Mockito.any(User.class)).thenReturn(expectedMap));
    }
}
