package com.example.Parser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import  com.example.Parser.servise.Parser.*;

import static com.example.Parser.servise.Parser.parser;


@SpringBootApplication
@OpenAPIDefinition // http://localhost:8080/swagger-ui/index.html#/
public class  ParserApplication {

	public static void main(String[] args) {
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				try {
					parser();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		};
		Timer timer = new Timer();
		SpringApplication.run(ParserApplication.class, args);
		Date startTime = new Date();
		timer.schedule(task, startTime, 1200_000);
	}

}
