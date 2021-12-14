package com.borgestech.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.borgestech.currencyexchangeservice.bean.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

	public CurrencyExchange findByFromAndTo(String to, String from);
}
