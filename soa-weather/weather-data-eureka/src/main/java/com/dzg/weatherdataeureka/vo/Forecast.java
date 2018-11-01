package com.dzg.weatherdataeureka.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 *   未来天气
 * @author dzg
 * @date 2018/10/25 19:11
 * @param
 * @return
 */
@Getter
@Setter
public class Forecast implements Serializable {
    private static final long serialVersionUID = 1L;
    private String date;
    private String high;
    private String fengli;
    private String low;
    private String fengxiang;
    private String type;
}
