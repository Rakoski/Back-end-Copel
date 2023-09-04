package com.example.hackathoncopel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication(exclude = {SessionAutoConfiguration.class})
@CrossOrigin(origins = "http://localhost:8080/login")
public class HackathonCopelApplication {

    public static void main(String[] args) {
        SpringApplication.run(HackathonCopelApplication.class, args);
    }

}
