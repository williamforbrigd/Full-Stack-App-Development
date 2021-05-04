package calculator.springserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class SpringserverApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SpringserverApplication.class);
		app.setDefaultProperties(Collections
				.singletonMap("server.port", "3002"));
		app.run(args);
	}

}
