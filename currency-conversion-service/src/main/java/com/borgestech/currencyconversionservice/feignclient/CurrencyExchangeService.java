package com.borgestech.currencyconversionservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.borgestech.currencyconversionservice.bean.CurrencyConversion;

@FeignClient(name = "currency-exchange-service")
public interface CurrencyExchangeService {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchangeValue(
			@PathVariable(name = "from") String from,
			@PathVariable(name = "to") String to);
}
