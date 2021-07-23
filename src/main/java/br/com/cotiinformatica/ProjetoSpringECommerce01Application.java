package br.com.cotiinformatica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = {"br.com.cotiinformatica"})
public class ProjetoSpringECommerce01Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoSpringECommerce01Application.class, args);
	}
	
	private static Class<ProjetoSpringECommerce01Application> applicationClass = ProjetoSpringECommerce01Application.class;
	
			@Override
			protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
				return builder.sources(applicationClass);
	}
}
