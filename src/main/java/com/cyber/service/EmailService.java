package com.cyber.service;

public interface EmailService {
     void sendSimpleMessage(String to, String subject, String text);
     void sendConfirmationMessage(String to);
}
