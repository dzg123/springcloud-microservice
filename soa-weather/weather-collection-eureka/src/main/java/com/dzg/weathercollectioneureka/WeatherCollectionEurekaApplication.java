package com.dzg.weathercollectioneureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WeatherCollectionEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherCollectionEurekaApplication.class, args);
	}
}
