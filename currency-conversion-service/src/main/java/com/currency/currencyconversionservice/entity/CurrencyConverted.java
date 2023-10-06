package com.currency.currencyconversionservice.entity;


// response class
public class CurrencyConverted {

	String base;
	
	String convertTo;
	
	Integer quantity;
	
	double convertedValue;
	
	double rate;
	
	String date;
	
	String timestamp;
	

	public CurrencyConverted() {
		
	}

	public CurrencyConverted(String base, String convertTo, Integer quantity, double convertedValue, double rate,
			String date, String timestamp) {
		super();
		this.base = base;
		this.convertTo = convertTo;
		this.quantity = quantity;
		this.convertedValue = convertedValue;
		this.rate = rate;
		this.date = date;
		this.timestamp = timestamp;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getConvertTo() {
		return convertTo;
	}

	public void setConvertTo(String convertTo) {
		this.convertTo = convertTo;
	}


	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getConvertedValue() {
		return convertedValue;
	}

	

	public void setConvertedValue(double convertedValue) {
		this.convertedValue = convertedValue;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "CurrencyConverted [base=" + base + ", convertTo=" + convertTo + ", quantity=" + quantity
				+ ", convertedValue=" + convertedValue + ", rate=" + rate + ", date=" + date + ", timestamp="
				+ timestamp + "]";
	}

	
}
