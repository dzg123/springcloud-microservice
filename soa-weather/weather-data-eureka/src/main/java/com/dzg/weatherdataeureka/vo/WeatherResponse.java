package com.dzg.weatherdataeureka.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 *       天气响应
 * @author dzg
 * @date 2018/10/25 19:15 
 * @param    
 * @return   
 */ 
@Getter
@Setter
public class WeatherResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private Weather data;
    private Integer status;
    private String desc;
}
