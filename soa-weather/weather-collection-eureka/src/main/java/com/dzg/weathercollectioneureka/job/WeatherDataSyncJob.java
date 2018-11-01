package com.dzg.weathercollectioneureka.job;


import com.dzg.weathercollectioneureka.service.WeatherDataCollectionService;
import com.dzg.weathercollectioneureka.service.impl.CityService;
import com.dzg.weathercollectioneureka.vo.City;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class WeatherDataSyncJob extends QuartzJobBean {
    @Autowired
    private WeatherDataCollectionService weatherDataCollectionService;
    @Autowired
    private CityService cityService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) {
        log.info("Weather Data Sync Job. Start！");
        // 获取城市ID列表


        List<City> cityList = null;
        try {
            cityList = cityService.cityList();
        } catch (Exception e) {
            log.info("抛出异常:{}", e.getMessage());
        }
        for (City city : cityList) {
            String cityId = city.getCityId();
            log.info("Weather Data Sync Job, cityId:{}", cityId);
            weatherDataCollectionService.syncDataByCityId(cityId);
        }
        log.info("Weather Data Sync Job. End！");
    }
}
