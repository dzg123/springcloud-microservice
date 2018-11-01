package com.dzg.weatherreporteureka.controller;

import com.dzg.weatherreporteureka.feign.DataClient;
import com.dzg.weatherreporteureka.service.WeatherReportService;
import com.dzg.weatherreporteureka.vo.City;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/report")
public class WeatherReportController {


    @Autowired
    private WeatherReportService weatherReportService;
    @Autowired
    private DataClient dataClient;

    @GetMapping("/cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception {
        // 获取城市ID列表
        List<City> cityList = null;

        try {
            cityList = dataClient.cityList();


        } catch (Exception e) {
            log.error("Exception!", e);
        }

        model.addAttribute("title", "老卫的天气预报");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", cityList);
        model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
        return new ModelAndView("weather/report", "reportModel", model);
    }
}
