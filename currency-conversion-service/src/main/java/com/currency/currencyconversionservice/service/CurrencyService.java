package com.currency.currencyconversionservice.service;

import com.currency.currencyconversionservice.entity.CurrencyConverted;

public interface CurrencyService {

	public CurrencyConverted getConversionRate(String from, String to, Integer quantity);
}
