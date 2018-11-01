package com.dzg.weatherreporteureka.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 *   昨日天气
 * @author dzg  
 * @date 2018/10/25 19:11
 * @param    
 * @return   
 */ 
@Getter
@Setter
public class Yesterday implements Serializable {
    private static final long serialVersionUID = 1L;
    private String date;
    private String high;
    private String fx;
    private String low;
    private String fl;
    private String type;
}
