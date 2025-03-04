package com.safeguard.safeguardbackend;

import com.safeguard.safeguardbackend.rest.impl.AccountControllerImpl;
import com.safeguard.safeguardbackend.rest.impl.PaymentControllerImpl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Import({
		AccountControllerImpl.class,
		PaymentControllerImpl.class,
})
public class SafeguardbackendApplication {

	// silence console logging
	@Value("${logging.level.root:OFF}")
	String message = "";

	/*
	 * Create required HandlerMapping, to avoid several default HandlerMapping instances being created
	 */
	@Bean
	public HandlerMapping handlerMapping() {
		return new RequestMappingHandlerMapping();
	}

	/*
	 * Create required HandlerAdapter, to avoid several default HandlerAdapter instances being created
	 */
	@Bean
	public HandlerAdapter handlerAdapter() {
		return new RequestMappingHandlerAdapter();
	}

	public static void main(String[] args) {
		SpringApplication.run(SafeguardbackendApplication.class, args);
	}
}