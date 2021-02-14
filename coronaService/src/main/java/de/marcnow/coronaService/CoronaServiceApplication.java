package de.marcnow.coronaService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class CoronaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoronaServiceApplication.class, args);
	}

}

@RestController
class HelloController {
	
	@GetMapping("/")
	String hello() {
		return "Hello World!";
	}
}
