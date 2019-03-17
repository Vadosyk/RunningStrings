package ua.com.qalight.service;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
				String[] velues = line.split("," + " ");
				currencys.put(velues[0], Double.valueOf(velues[1]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return currencys;
	}
	
	public static void writeCurrencyValuesToFile(List<CurrencyEntity> currencys) {
		
		try (FileWriter fileWriter = new FileWriter(OUTPUT_FILE_PATH, false)){
			String outVelues = "";
			for (CurrencyEntity currencyEntity : currencys) {
				outVelues += currencyEntity.getCurrency().getShortName() + "(" 
				+ currencyEntity.getCurrency().getSymbol() + ")"
				+ " - " + CalcService.getBuyPrice(currencyEntity)
				+ "/" + CalcService.getSellPrice(currencyEntity)
				+ " - " + currencyEntity.getValue() + "\n";
				
			}
			fileWriter.write(outVelues);
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	}
