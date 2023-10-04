package com.currency.currencyconversionservice.service;

import java.text.DecimalFormat;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.currency.currencyconversionservice.config.Configuration;
import com.currency.currencyconversionservice.entity.CurrencyConverted;
import com.currency.currencyconversionservice.entity.CurrencyRate;


@Service
public class CurrencyServiceClass implements CurrencyService {
	@Autowired
	private Configuration configuration;
	
	private static final DecimalFormat decimalFormat = new DecimalFormat("0.00");

	@Override
	public CurrencyConverted getConversionRate(String from, String to, Integer quantity) {
		
		//we are getting this access key from centralized git configuration
		String accessKey=configuration.getKeyValue();
		
		
		
		// url for currency rate of 1 EUR to other currencies
		String url="http://data.fixer.io/api/latest?access_key=" + accessKey;
		ResponseEntity<CurrencyRate> currencyRate = new RestTemplate().getForEntity(url, CurrencyRate.class);	
		
		// got our response from the api w.r.t. EUR
		
		// do our processing of {convertFrom} to {convertTo} currency conversion and with specified quantity.
		// then return the final result object of CurrencyConverted class.
		
		double rate=0.0;
		
		if(from.equals("EUR")) {  // no need to do processing default conversion is from EUR to other currencies.
			rate = currencyRate.getBody().getRates().get(to);
		}else {
			// convert rate according to the EUR
//			1 EUR = 100 INR
//			1 EUR = 10 USD
//			10 usd = 100 inr
//		    1 usd = 100/10 inr
		    
			
			double fromRate = currencyRate.getBody().getRates().get(from);
			double toRate = currencyRate.getBody().getRates().get(to);
			rate = toRate/fromRate;
		}
		
		//to convert unix timestamp into java instant

		long unixTimestamp = currencyRate.getBody().getTimestamp();
		Instant instant = Instant.ofEpochSecond(unixTimestamp);		
		
		
		double convertedValue = Double.parseDouble(decimalFormat.format(rate*quantity));
		rate = Double.parseDouble(decimalFormat.format(rate));
		
		CurrencyConverted converted = new CurrencyConverted(from, to, convertedValue, rate,
											currencyRate.getBody().getDate() , instant.toString());
		
		return converted;
	}

}