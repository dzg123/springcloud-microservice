package com.dzg.weathercityeureka.vo;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "c")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class CityList {
    @XmlElement(name = "d")
    private List<City> cityList;
}
