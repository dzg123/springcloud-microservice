package com.dzg.weathercollectioneureka.controller;

import com.dzg.weathercollectioneureka.service.impl.CityService;
import com.dzg.weathercollectioneureka.vo.City;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController {
    @Autowired
    private CityService cityService;
    @GetMapping("/cities")
    public List<City> cityList(){
        return cityService.cityList();
    }
}
