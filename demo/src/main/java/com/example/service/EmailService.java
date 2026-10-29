package com.example.service;

import org.springframework.stereotype.Component;

@Component
public class EmailService implements NotificationService{

    @Override
    public void send(String message) {
        System.out.println("Email: " + message + "");
    }
}
