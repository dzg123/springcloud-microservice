package com.dzg.weathereurekaclientzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
@EnableZuulProxy
@SpringBootApplication
public class WeatherEurekaClientZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherEurekaClientZuulApplication.class, args);
	}
}
