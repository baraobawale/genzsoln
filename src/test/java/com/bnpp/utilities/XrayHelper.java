package com.bnpp.utilities;

import java.io.File;

import com.dab.config.PropertiesHandler;

public class XrayHelper {

	/**
	 * get test ID from feature file
	 * 
	 * 
	 */

	public static String getTestIdFromFileName(String path) {
		String result = "";
		File f = new File(path);
		System.out.println("File Name1: " + f.getName().toString().toUpperCase().replace("_", "-").trim());
		result = f.getName().toString().toUpperCase().replace("_", "-").trim().split(".FEATURE")[0];
		Log.info("File Name = Test Issue Key: " + result);
		// result = f.getName().toString().toUpperCase().replace("_", "-").trim();
		return result;
	}

	public static String getExecKey() {
		String result = "";
	
		boolean create = false;
	
		if (create) {
			// create test execution
		} else {
			result = com.dab.config.PropertiesHandler.getXrayTestExecutionKey();
		}
	
		return result;
	}

}
