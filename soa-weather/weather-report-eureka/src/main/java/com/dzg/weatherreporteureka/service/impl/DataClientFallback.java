package com.dzg.weatherreporteureka.service.impl;

import com.dzg.weatherreporteureka.feign.DataClient;
import com.dzg.weatherreporteureka.vo.City;
import com.dzg.weatherreporteureka.vo.WeatherResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class DataClientFallback implements DataClient {
    @Override
    public List<City> cityList() throws Exception {
        List<City> cityList = new ArrayList<>();
        City city = new City();
        city.setCityId("111111");
        city.setCityName("杭州");
        cityList.add(city);
        city = new City();
        city.setCityId("2222");
        city.setCityName("dasda");
        cityList.add(city);
        return cityList;
    }

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        return null;
    }
}
