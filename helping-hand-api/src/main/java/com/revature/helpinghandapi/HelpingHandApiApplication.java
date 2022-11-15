package com.revature.helpinghandapi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource()
public class HelpingHandApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelpingHandApiApplication.class, args);
	}

}
