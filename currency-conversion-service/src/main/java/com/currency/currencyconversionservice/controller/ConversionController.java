package com.currency.currencyconversionservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.currency.currencyconversionservice.entity.CurrencyConverted;
import com.currency.currencyconversionservice.service.CurrencyService;

@RestController
public class ConversionController {
	
	@Autowired
	private CurrencyService currencyService;
	
	@GetMapping("/getConvertedValue/from/{from}/to/{to}/quantity/{quantity}")
	public ResponseEntity<?> getConvertedValue(@PathVariable String from,
											    @PathVariable String to,
												@PathVariable Integer quantity){
				
		CurrencyConverted converted = currencyService.getConversionRate(from, to, quantity);
		
		return new ResponseEntity<>(converted,HttpStatus.OK);
	}
	
	@GetMapping("/test")
	public String test() {
		return "Congratulations, It is Working!!";
	}

}
