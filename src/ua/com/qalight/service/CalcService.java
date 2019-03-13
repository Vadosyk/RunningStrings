package ua.com.qalight.service;

import ua.com.qalight.Entity.CurrencyEntity;

public class CalcService {

	public static Double getSellPrice(CurrencyEntity currencyEntity) {
		return currencyEntity.getValue() * 1.05;
	}
	
	public static Double getBuyPrice(CurrencyEntity currencyEntity) {
		return currencyEntity.getValue() * 1.10;
	}
}