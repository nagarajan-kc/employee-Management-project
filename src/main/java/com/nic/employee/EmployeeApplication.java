package com.nic.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;

@SpringBootApplication
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

	@Bean
	public SpringResourceTemplateResolver htmlTemplateResolver()
	{
	    SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
	    resolver.setPrefix("classpath:/templates/");
	    resolver.setSuffix(".html"); // here
	    resolver.setTemplateMode("HTML5");
	    resolver.setOrder(1);
	    return resolver;
	}
}
