package com.linctronix.service;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EventServiceApplication {
	
	public static void main(String args[]) {
		SpringApplication.run(EventServiceApplication.class, args);
	}
	
	@Bean
	DataSource dataSource() {
	    BasicDataSource dataSourceConfig = new BasicDataSource();
	    dataSourceConfig.setDriverClassName("org.postgresql.Driver");

	    dataSourceConfig.setUrl("jdbc:postgresql://127.0.0.1:5432/rule_action");
	    dataSourceConfig.setUsername("luke");
	    dataSourceConfig.setValidationQuery("SELECT 1");
	    dataSourceConfig.setPassword("29597808");

	    return dataSourceConfig;
	}
}
