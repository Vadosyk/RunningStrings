package ua.com.qalight;

import java.util.List;
import java.util.Map;

import ua.com.qalight.entity.CurrencyEntity;
import ua.com.qalight.service.FileManager;
import ua.com.qalight.util.CurrencyMapper;

public class AppRunner {

	public static void main(String[] args) {
		
		runWithTimeout(2);
		
	}
	
	static void runWithTimeout(int minutes) {
		while (true) {
			Map<String, Double> currencyMap = FileManager.readInputCurrencyVaues();
			List<CurrencyEntity> currencyEntities = CurrencyMapper.getFromMap(currencyMap);
			
			
				FileManager.writeCurrencyValuesToFile(currencyEntities);
			
			
			try {
				Thread.sleep(1000 * 60 * minutes);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	

	}

}
