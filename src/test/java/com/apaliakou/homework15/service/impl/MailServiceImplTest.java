package com.apaliakou.homework15.service.impl;

import com.apaliakou.homework15.model.User;
import com.apaliakou.homework15.service.api.MailSender;
import com.apaliakou.homework15.service.api.MessageCreator;
import com.apaliakou.homework15.service.api.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
public class MailServiceImplTest {

    @Mock
    private MessageCreator messageCreatorMock;

    @Mock
    private UserService userServiceMock;

    @Mock
    private MailSender mailSenderMock;

    @InjectMocks
    private MailServiceImpl mailServiceImpl;

    @Test
    public void check_sendFirstInvitation() {
        String expectedPersonalMessage = "Fuck!!!!!!!!";

        Mockito.when(messageCreatorMock.createPersonalMessage(Mockito.any(User.class), Mockito.anyString())).thenReturn(expectedPersonalMessage);

        User inputUser = new User("Andrei", "Paliakou", "mortis2008@mail.ru");
        String actualPersonalMessage = mailServiceImpl.sendFirstInvitation(inputUser);
        assertThat
    }
}
