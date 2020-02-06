package edu.cvc.javabot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"me.ramswaroop.jbot", "edu.cvc.javabot"})
public class JavabotApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavabotApplication.class, args);
	}

}
