package com.deesite.dataProfider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	private Properties properties;
	private final String propertyFilePath = System.getProperty("user.dir") + File.separator + "configs"+File.separator+"Configuration.properties";

	public ConfigFileReader() {
		BufferedReader bufferedReader;
		try {
			bufferedReader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(bufferedReader);
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties file not found at " + propertyFilePath);

		}
	}

	public String getDriverPath() {
		String driverPath = properties.getProperty("driverPath");
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
	}

	public long getImplicitlyWait() {
		String implicitWait = properties.getProperty("implicitlyWait");
		if (implicitWait != null)
			return Long.parseLong(implicitWait);
		else
			throw new RuntimeException("implicitlyWait not specified in the Configuraton.properties file.");
	}

	public String getApplicationUrl() {
		String appUrl = properties.getProperty("appUrl");
		if (appUrl != null)
			return appUrl;
		else
			throw new RuntimeException("appUrl not specified in the Configuration.properties file.");
	}

}
