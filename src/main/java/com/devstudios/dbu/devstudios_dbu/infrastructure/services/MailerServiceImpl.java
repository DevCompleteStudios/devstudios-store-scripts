package com.devstudios.dbu.devstudios_dbu.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.devstudios.dbu.devstudios_dbu.application.interfaces.services.IMailerService;



@Service
@Async
public class MailerServiceImpl implements IMailerService {

    @Autowired
    JavaMailSender mailSender;


    @Override
    public void sendEmail(String to, String html, String subject) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(html);
        message.setFrom("tu-email@gmail.com");  // Establece el correo desde el que envías
        mailSender.send(message);
    }

}
