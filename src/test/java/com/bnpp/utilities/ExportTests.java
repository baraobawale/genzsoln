package com.bnpp.utilities;

import com.dab.qa.App;
import com.dab.xray.Xray;

public class ExportTests {

	public static void main(String[] args) {

		export();

	}

	public static void export() {
		App.setLogger();

		com.dab.config.PropertiesHandler.setConfigPath(Configurations.XrayConfigPath);

		Xray.exportCucumberTestsFromXray();

	}

}
