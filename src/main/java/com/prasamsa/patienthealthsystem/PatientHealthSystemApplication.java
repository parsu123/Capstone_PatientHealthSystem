package com.prasamsa.patienthealthsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class PatientHealthSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientHealthSystemApplication.class, args);
    }

}
