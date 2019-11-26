package com.bnpp.utilities;

import java.io.File;

public class XrayHelper {

	/**
	 * get test ID from feature file
	 * 
	 * 
	 */

	public static String getTestIdFromFileName(String path) {
		String result = "";

		File f = new File(path);
		result = f.getName().toString().toUpperCase().replace("_", "-").trim().split(".FEATURE")[0];
		Log.info("File Name = Test Issue Key: " + result);

		return result;
	}

	
}
