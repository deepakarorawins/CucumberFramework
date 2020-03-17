package com.deesite.dataProfiders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.DriverType;
import enums.EnvironmentType;

public class ConfigFileReader {
	private Properties properties;
	private final String propertyFilePath = System.getProperty("user.dir") + File.separator + "configs" + File.separator
			+ "Configuration.properties";

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
			throw new RuntimeException(
					"Driver Path not specified in the Configuration.properties file for the key: driverPath.");
	}

	public long getImplicitlyWait() {
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if (implicitlyWait != null) {
			try {
				return Long.parseLong(implicitlyWait);
			} catch (NumberFormatException e) {
				throw new RuntimeException("Not able to parse value: " + implicitlyWait + "into Long");
			}
		}
		return 30;
	}

	public String getApplicationUrl() {
		String appUrl = properties.getProperty("appUrl");
		if (appUrl != null)
			return appUrl;
		else
			throw new RuntimeException("Application Url is not specified in the Configuration.properties file for the Key: appUrl.");
	}
	
	public DriverType getBrowser() {
		String browserName = properties.getProperty("browser");
		if(browserName==null || browserName.equalsIgnoreCase("chrome"))return DriverType.CHROME;
		else if (browserName.equalsIgnoreCase("firefox"))return DriverType.FIREFOX;
		else if (browserName.equalsIgnoreCase("iexplorer"))return DriverType.INTERNETEXPLORER;
		else
			throw new RuntimeException("Browser Name Key value in the Configuration.properties file is not matched: "+ browserName);
	}
	
	public EnvironmentType getEnvironment() {
		String environmentName = properties.getProperty("environment");
		if(environmentName==null || environmentName.equalsIgnoreCase("local"))return EnvironmentType.LOCAL;
		else if (environmentName.equalsIgnoreCase("remote"))return EnvironmentType.REMOTE;
		else
			throw new RuntimeException("Environment Type Key value in the Configuration.properties file is not matched: "+ environmentName);
	}
	
	public Boolean getBrowserWindowSize() {
		String windowSize = properties.getProperty("isWindowMaximized");
		if(windowSize!=null) return Boolean.parseBoolean(windowSize);
		return true;
	}


}
