package com.dzg.weathercollectioneureka.service;

/**
 * Weather Data Collection Service.
 * 
 * @since 1.0.0 2017年11月26日
 * @author
 */
public interface WeatherDataCollectionService {

	/**
	 * 根据城市ID同步天气
	 * @param cityId
	 */


	void syncDataByCityId(String cityId);
}
