package com.dzg.weatherreporteureka.service.impl;

import com.dzg.weatherreporteureka.feign.DataClient;
import com.dzg.weatherreporteureka.service.WeatherReportService;
import com.dzg.weatherreporteureka.vo.Forecast;
import com.dzg.weatherreporteureka.vo.Weather;
import com.dzg.weatherreporteureka.vo.WeatherResponse;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {
    @Autowired
    private DataClient dataClient;

    @Override
    public Weather getDataByCityId(String cityId) {
        WeatherResponse response = dataClient.getDataByCityId(cityId);
        Weather data = null;
        if (response != null) {
            data = response.getData();
        }
        return data;
    }
}
