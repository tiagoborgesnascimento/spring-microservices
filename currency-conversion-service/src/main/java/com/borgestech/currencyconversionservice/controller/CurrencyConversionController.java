package com.borgestech.currencyconversionservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.borgestech.currencyconversionservice.bean.CurrencyConversion;
import com.borgestech.currencyconversionservice.feignclient.CurrencyExchangeService;

@RestController
@RequestMapping("/currency-conversion")
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeService currencyExchangeService;
	
	@GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(
			@PathVariable(name = "from") String from,
			@PathVariable(name = "to") String to,
			@PathVariable(name = "quantity") BigDecimal quantity) {
		
		CurrencyConversion currencyConversion = currencyExchangeService.retrieveExchangeValue(from, to);
		currencyConversion.setQuantity(quantity);
		
		return currencyConversion;
	}
}
