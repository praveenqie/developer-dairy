package com.learn.security;

import com.learn.security.dto.RegisterRequest;
import com.learn.security.enumtype.Role;
import com.learn.security.service.Impl.AuthenticationServiceImpl;

import static com.learn.security.enumtype.Role.ADMIN;
import static com.learn.security.enumtype.Role.MANAGER;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}
}
