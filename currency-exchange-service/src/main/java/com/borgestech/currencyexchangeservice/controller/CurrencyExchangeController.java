package com.borgestech.currencyexchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.borgestech.currencyexchangeservice.bean.CurrencyExchange;
import com.borgestech.currencyexchangeservice.repository.CurrencyExchangeRepository;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {
	
	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;
	
	@GetMapping("/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(
			@PathVariable(name = "from") String from,
			@PathVariable(name = "to") String to) {
		
		return currencyExchangeRepository.findByFromAndTo(to, from);
	}
	
}
