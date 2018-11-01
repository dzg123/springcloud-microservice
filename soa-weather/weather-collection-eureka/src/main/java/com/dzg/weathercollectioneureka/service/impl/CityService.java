package com.dzg.weathercollectioneureka.service.impl;

import com.dzg.weathercollectioneureka.feign.CityClient;
import com.dzg.weathercollectioneureka.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityClient cityClient;

    public List<City> cityList(){
        return cityClient.cityList();
    }
}
