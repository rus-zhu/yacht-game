package com.ruszhu.yacht;

import com.ruszhu.yacht.domain.Game;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class YachtApplication {

	public static void main(String[] args) {
		SpringApplication.run(YachtApplication.class, args);
	}

	@Bean
	public Game createGame() {
		return new Game();
	}
}
