package ca.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"ca.mss"})
public class SpringBootStarterDemoWarApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStarterDemoWarApplication.class, args);
	}

}
