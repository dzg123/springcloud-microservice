package com.dzg.weatherdataeureka.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 *   天气信息
 * @author dzg  
 * @date 2018/10/25 19:12
 * @param    
 * @return   
 */ 
@Getter
@Setter
public class Weather implements Serializable{
    private static final long serialVersionUID = 1L;
    private String city;
    private String aqi;
    private String ganmao;
    private String wendu;
    private Yesterday yesterday;
    private List<Forecast> forecast;
}

