package com.money.moneymanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailConfigTest {

    @Autowired(required = false)
    private JavaMailSender mailSender;

    @PostConstruct
    public void checkMailSender() {
        System.out.println("✅ JavaMailSender Bean: " + (mailSender != null ? "Created" : "NOT Created"));
    }
}
