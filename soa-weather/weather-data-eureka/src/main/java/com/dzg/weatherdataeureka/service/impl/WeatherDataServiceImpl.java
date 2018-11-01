package com.dzg.weatherdataeureka.service.impl;

import com.dzg.weatherdataeureka.service.WeatherDataService;
import com.dzg.weatherdataeureka.vo.WeatherResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class WeatherDataServiceImpl implements WeatherDataService {
    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        return this.doGetWeather(uri);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_URI + "city=" + cityName;
        return this.doGetWeather(uri);
    }


    private WeatherResponse doGetWeather(String uri) {
        String key = uri;
        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse resp = null;
        String strBody = null;
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        if (stringRedisTemplate.hasKey(key)) {
            log.info("redis has data");
            strBody = ops.get(key);
        } else {
            log.info("redis don't has data");
//         如果缓存中没有，则抛出异常
            throw new RuntimeException("redis don't has data");
        }
        try {
            resp = mapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            log.error("抛出异常{}", e.getMessage());
        }
        return resp;
    }


}
