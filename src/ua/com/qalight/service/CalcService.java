package ua.com.qalight.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import ua.com.qalight.entity.CurrencyEntity;

public class CalcService {

	public static Double getSellPrice(CurrencyEntity currencyEntity) {
		BigDecimal result = new BigDecimal(currencyEntity.getValue() * 1.05);
		BigDecimal correctresult = result.setScale(2, RoundingMode.HALF_UP);
		return correctresult.doubleValue();
	}
	
	public static Double getBuyPrice(CurrencyEntity currencyEntity) {
		BigDecimal result = new BigDecimal(currencyEntity.getValue() * 1.10);
		BigDecimal correctresult = result.setScale(2, RoundingMode.HALF_UP);
		return correctresult.doubleValue();
	}
}