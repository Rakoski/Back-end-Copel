package com.example.hackathoncopel;

import com.example.hackathoncopel.servico.EmailSenderService;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.InputStream;

@SpringBootApplication
@CrossOrigin(origins = "http://localhost:8080/login")
public class HackathonCopelApplication {

    @Autowired
    private EmailSenderService emailSenderService;

    public static void main(String[] args) {
        SpringApplication.run(HackathonCopelApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void SendMail() {
        emailSenderService.SendEmail("my-email@gmail.com",
                "Esse é o subject",
                "E esse é o corpo da mensagem");
    }
}
