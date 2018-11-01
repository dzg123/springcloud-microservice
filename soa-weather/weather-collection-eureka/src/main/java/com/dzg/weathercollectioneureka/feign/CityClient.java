package com.dzg.weathercollectioneureka.feign;

import com.dzg.weathercollectioneureka.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Component
@FeignClient("weather-city-eureka")
public interface CityClient {
    @GetMapping("/cities")
    List<City> cityList();
}
