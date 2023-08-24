package com.ecommerce;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "trenndytreand Ecommerce Backend",
				version = "1.0.0",
				description = "This Ecommerce project only for learning",
				termsOfService = "Education",
				contact = @Contact(
						name = "Sameera Udesh",
						email = "sameeraudesh95@gmail.com"
				),
				license = @License(
						name = "Licence",
						url = "sameera"
				)
		)
)
public class TrendythreadbackendappApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrendythreadbackendappApplication.class, args);
	}

}
