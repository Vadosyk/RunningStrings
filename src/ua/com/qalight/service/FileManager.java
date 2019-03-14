package ua.com.qalight.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import ua.com.qalight.Entity.CurrencyEntity;

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
		
		CurrencyEntity currencyEntity = new CurrencyEntity();
		
		
		try(FileInputStream fileInputStream = new FileInputStream(INPUT_FILE_PATH);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream); 
		){
		 
			currencyEntity = (CurrencyEntity) objectInputStream.readObject();
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return  currencyEntity;
	}
	
	public static void writeCurrencyValuesToFile(CurrencyEntity currency, Map<String, Double> currencyMap) {
		
		try(
				FileOutputStream fileOutputStream = new FileOutputStream(OUTPUT_FILE_PATH);
				ObjectOutputStream objOutputStream = new ObjectOutputStream(fileOutputStream); 
			){
			 
			objOutputStream.writeObject(currency);
			objOutputStream.writeObject(currencyMap);	
			
			}catch (Exception e) {
				
				e.printStackTrace();
			}
		
	}
}