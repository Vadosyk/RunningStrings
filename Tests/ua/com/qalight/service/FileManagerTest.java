package ua.com.qalight.service;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;
import org.junit.jupiter.api.Test;

class FileManagerTest {

	@Test
	void testReadCurrency() {

			Map<String, Double> currencyEntities = FileManager.readInputCurrencyVaues();
			assertTrue(currencyEntities != null);
			
			
	}

	
	@Test
	void testWriteCurrency() {
		
		
	}
}
