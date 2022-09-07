package io.movie.dicovertserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DicovertServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DicovertServerApplication.class, args);
	}

}
