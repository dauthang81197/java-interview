package com.example.service;

import org.springframework.stereotype.Component;

@Component
public class OrderService {
    private final NotificationService notificationService;
    // Spring tu tim bean Notification Service de truyen vao day
    public OrderService(NotificationService notificationService) {
       this.notificationService = notificationService;
    }

    public void sendOrderNotification() {
        System.out.println("Dat hang thanh cong");
        notificationService.send("Don hang da dat");
    }
}
