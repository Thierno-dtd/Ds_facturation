package sever.com.serverFacturation;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Application de facturation",
				version = "1.0.0",
				description = "C'est une application web de genération de facture automatique avec l'envoie par mail et par whatsapp",
				contact = @Contact(
						name = "s-Thierno",
						email = "davidouthe2@gmail.com"
				)
		)
)
public class ServerFacturationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerFacturationApplication.class, args);
	}

}
