package com.dzg.weathercityeureka.service.impl;

import com.dzg.weathercityeureka.service.CityDataService;
import com.dzg.weathercityeureka.util.XmlBuilder;
import com.dzg.weathercityeureka.vo.City;
import com.dzg.weathercityeureka.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class CityDataServiceImpl implements CityDataService {
    @Override
    public List<City> listCity() throws Exception {
        ClassPathResource resource = new ClassPathResource("citylist.xml");
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));
        StringBuffer buffer = new StringBuffer();
        String line;
        while ((line = br.readLine()) != null) {
            buffer.append(line);
        }
        br.close();
        CityList cityList = (CityList) XmlBuilder.xmlstrToObject(CityList.class, buffer.toString());
        return cityList.getCityList();
    }
}
