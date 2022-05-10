package com.crm.VtigerBRAJ.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	/**
	 * its used to read the data from commonData.properties File based on key which you pass as an argument 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getPropertiesData(String key) throws IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonData\\credential.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String value=pobj.getProperty(key);
		return value;
	}

}
