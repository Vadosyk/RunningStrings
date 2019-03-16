package ua.com.qalight.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import ua.com.qalight.entity.ConnectionLog;
import ua.com.qalight.entity.Currency;
import ua.com.qalight.entity.CurrencyEntity;

public class FileManager {
	
	private static final String INPUT_FILE_PATH = 
			System.getProperty("user.dir") + 
			System.getProperty("file.separator") + 
			"files" + 
			System.getProperty("file.separator") + 
			"InputFile.txt";
	
	private static final String OUTPUT_FILE_PATH = 
			System.getProperty("user.dir") + 
			System.getProperty("file.separator") + 
			"files" + 
			System.getProperty("file.separator") + 
			"OutputFile.txt";
	
	public static Map<String, Double> readInputCurrencyVaues(){
		Map<String, Double> currencys = new HashMap<String, Double>();
		try(FileReader fileReader = new FileReader(INPUT_FILE_PATH);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			){
			String line = "";
			while((line = bufferedReader.readLine()) != null) {
				String[] words = line.split(" ");
				String currency = String.valueOf(words[0]);
				Double value = Double.valueOf(words[1]);
			
				currencys.put(currency, value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return currencys ;
	}
	
	public static void writeCurrencyValuesToFile(CurrencyEntity currency, Map<String, Double> currencyMap) {
		
		try (FileWriter fileWriter = new FileWriter(OUTPUT_FILE_PATH)){
			fileWriter.write(currency.toString() + currencyMap + "\n");
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	}
