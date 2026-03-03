package com.comcast.hrm.generic.file.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	public String getDataFromPropertyFile(String key) throws IOException {
		String result = "";
		FileInputStream fis = new FileInputStream(".\\ConfigAppData\\commonData_NinzaHRM.properties");
		Properties prop = new Properties();
		prop.load(fis);
		result = prop.getProperty(key);
		return result;
	}

}
