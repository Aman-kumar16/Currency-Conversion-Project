package com.currency.currencyconversionservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


//This is the configuration class
//Here we are referring the configuration from centralized git repository
@Component
@ConfigurationProperties("access-key")
public class Configuration {
	
	private String keyValue;

	public String getKeyValue() {
		return keyValue;
	}

	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}
	
	

}
