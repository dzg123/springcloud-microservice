package com.dzg.weatherreporteureka.feign;

import com.dzg.weatherreporteureka.service.impl.DataClientFallback;
import com.dzg.weatherreporteureka.vo.City;
import com.dzg.weatherreporteureka.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Component
@FeignClient(name="weather-eureka-client-zuul",fallback = DataClientFallback.class)
public interface DataClient {
    /**
     * 获取城市列表
     * @return
     * @throws Exception
     */
    @GetMapping("/city/cities")
    List<City> cityList() throws Exception;
    /**
     * 根据城市ID查询天气数据
     */
    @GetMapping("/data/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
}
