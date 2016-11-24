package com.linctronix.service;

import javax.sql.DataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EventServiceApplication {
	
	public static void main(String args[]) {
		SpringApplication.run(EventServiceApplication.class, args);
	}
}
