package com.api.educationalsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.educationalsystem.utils.JWTUtils;

@RestController
@SpringBootApplication
public class EducationalSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EducationalSystemApplication.class, args);

        JWTUtils.init();
    }

    // @GetMapping(path = "/csrf-token")
    // public CsrfToken getCsrfToken(CsrfToken token) {
    // return token;
    // }
}
