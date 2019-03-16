package ua.com.qalight.service;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;
import org.junit.jupiter.api.Test;

import ua.com.qalight.entity.Currency;
import ua.com.qalight.entity.CurrencyEntity;

class FileManagerTest {

	@Test
	void testReadCurrencyFromFile() {
		
		Map<String, Double> currencyMap = FileManager.readInputCurrencyVaues();
		assertTrue(currencyMap != null);
		
		
	}

	@Test
	void testWriteCurrencyToFile() {
		String currency = "876";
		Double value = 26,30;
		CurrencyEntity currency = new CurrencyEntity(currency, value);
		FileManager.writeCurrencyValuesToFile(currency, currencyMap);
		assertTrue(currencyMap != null);
	
	
}
