package com.apaliakou.homework15.service.impl;

import com.apaliakou.homework15.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

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
    public void check_sendFirstInvitation() {
        String expectedPersonalMessage = "Fuck!!!!!!!!";

        Mockito.when(messageCreatorImplMock.createPersonalMessage(Mockito.any(User.class), Mockito.anyString())).thenReturn(expectedPersonalMessage);

        User inputUser = new User("Andrei", "Paliakou", "mortis2008@mail.ru");
        String actualPersonalMessage = mailServiceImpl.sendFirstInvitation(inputUser);
        assertThat(actualPersonalMessage).isEqualTo(expectedPersonalMessage);
    }
}
