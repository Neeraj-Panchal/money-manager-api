package com.money.moneymanager.service;//package com.money.moneymanager.service;
//
//
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class EmailService {
//
//
//    private final JavaMailSender mailSender;
//
//    @Value("${spring.mail.properties.mail.smtp.from}")
//    private String fromEmail;
//
//    public void sendEmail(String to,String subject, String body) {
//        try{
//            SimpleMailMessage message = new SimpleMailMessage();
//            message.setFrom(fromEmail);
//            message.setTo(to);
//            message.setSubject(subject);
//            message.setText(body);
//            mailSender.send(message);
//        }catch (Exception e){
//            throw new RuntimeException("there is problem in sending mail : "+e.getMessage());
//        }
//    }
//
//}

// Inside your EmailService.java

import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor // (Or however you are injecting)
@Slf4j
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final JavaMailSenderImpl mailSender;

    // Make sure your method looks like this:
    public void sendEmail(String to, String subject, String htmlbody) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();

            // Use MimeMessageHelper and set multipart = true
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

            helper.setTo(to);
            helper.setSubject(subject);

            // *** THIS IS THE MOST IMPORTANT PART ***
            // The 'true' here tells Spring this is an HTML email
            helper.setText(htmlbody, true);

            mailSender.send(mimeMessage);
            log.info("Sent HTML email to: {}", to);
        } catch (Exception e) {
            // Add logging here
            throw new RuntimeException("there is problem in sending mail : "+e.getMessage());
        }
    }
}