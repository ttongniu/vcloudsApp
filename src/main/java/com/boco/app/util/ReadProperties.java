package com.boco.app.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Read the properties file.
 * 
 * @author Metanoia.Lang
 * 
 */

public class ReadProperties {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private Properties prop = null;

	/**
	 * construction function.
	 * 
	 * @param filename
	 *            String Relative path for package base path
	 */
	public ReadProperties(String filename) {
		InputStream is = null;
		prop = new Properties();

		logger.info("load Properties file:" + filename + "...");
		is = this.getClass().getClassLoader().getResourceAsStream(filename);

		try {
			prop.load(is);
			logger.info("init Properties Object success");

			if (is != null)
				is.close();
			logger.info("close load Properties file:" + filename + " success");
		} catch (IOException e) {
			logger.error("load Properties file:" + filename + " IO error");
			e.printStackTrace();
		}
	}

	/**
	 * get value of key from property
	 * 
	 * @param key
	 *            String property key
	 * @return String value of key
	 */
	public String GetPara(String key) {
		return (prop.getProperty(key));
	}

	/**
	 * @see test function
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * String value = new
		 * ReadProperties("paramConfigure.properties").GetPara("appId");
		 */
		ReadProperties read = new ReadProperties("paramConfigure.properties");
		String value = read.GetPara("appId");
		String value2 = read.GetPara("user");
		System.out.println(value);
		System.out.println(value2);
	}
}
