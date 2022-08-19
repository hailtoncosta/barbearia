package com.barbershop.barbearia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.Ordered;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableWebMvc
public class BarbeariaApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(BarbeariaApplication.class, args);
		
		//BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		//String result = encoder.encode("123");
		//System.out.println(result);
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("/login");
		registry.setOrder(Ordered.LOWEST_PRECEDENCE);
	}

}
