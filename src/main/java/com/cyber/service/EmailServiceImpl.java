package com.cyber.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.security.GeneralSecurityException;
import java.security.SecureRandom;

@Component
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("mychalevytsh@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }

    @Override
    public void sendConfirmationMessage(String to) {
        String text = "Dear " + to + "to continue registration you should confirm your email." +
                "Please, enter the six-digit code from this message on 'CyberWe' site\n" +
                + getRandomKey();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("mychalevytsh@gmail.com");
        message.setTo(to);
        message.setSubject("Confirm registration");
        message.setText(text);
        javaMailSender.send(message);

    }

    private int getRandomKey(){
        int key = 0;
        try{
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        key = sr.nextInt(9000000) + 1000000;

        }catch (GeneralSecurityException e){
            e.printStackTrace();
        }
        return key;
    }
}
