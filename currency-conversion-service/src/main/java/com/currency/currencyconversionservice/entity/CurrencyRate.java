package com.currency.currencyconversionservice.entity;

import java.util.Map;



public class CurrencyRate {
	
	boolean success;
	
	long timestamp;
	
	String base;
	
	String date;
		
	//for dynamic mapping
	Map<String, Double> rates;
	

	public CurrencyRate() {
		
	}

	public CurrencyRate(boolean success, long timestamp, String base, String date, Map<String,Double> rates) {
		super();
		this.success = success;
		this.timestamp = timestamp;
		this.base = base;
		this.date = date;
		this.rates = rates;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	public Map<String, Double> getRates() {
		return rates;
	}

	public void setRates(Map<String, Double> rates) {
		this.rates = rates;
	}

	
	@Override
	public String toString() {
		return "CurrencyRate [success=" + success + ", timestamp=" + timestamp + ", base=" + base + ", date=" + date
				+ ", rates=" + rates + "]";
	}	

}

//to convert unix timestamp into java instant

//long unixTime = 1665083712;
//Instant instant = Instant.ofEpochSecond(unixTime);
//
//System.out.println(instant);