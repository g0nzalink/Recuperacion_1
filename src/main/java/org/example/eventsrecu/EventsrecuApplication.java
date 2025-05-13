package org.example.eventsrecu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class EventsrecuApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(EventsrecuApplication.class, args);
	}
	
}
