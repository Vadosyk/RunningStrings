package ua.com.qalight.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

class FileManagerTest {

	@Test
	void testReadCurrentyFromFile() {
		
		Map<String, Double> currencyMap = FileManager.readInputCurrencyVaues();
		assertTrue(currencyMap != null);
		
		
	}

}
