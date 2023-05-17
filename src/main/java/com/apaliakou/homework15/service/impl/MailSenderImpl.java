package com.apaliakou.homework15.service.impl;

import com.apaliakou.homework15.service.api.MailSender;

public class MailSenderImpl implements MailSender {

private String mail;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public void sendMail(String mail) {
        System.out.println(mail);
    }
}
