package com.netflix.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class NetflixOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixOrderApplication.class, args);
	}


}
