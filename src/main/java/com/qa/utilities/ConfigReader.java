package com.qa.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	// This is used to return the properties from the Config.properties file
	
	
	private Properties prop; 
	
	public Properties init_prop() {
		
		Properties prop = new Properties();
		try {
			FileInputStream ip = new  FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
}
