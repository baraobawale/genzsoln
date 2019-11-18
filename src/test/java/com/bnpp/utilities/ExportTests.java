package com.bnpp.utilities;

import com.bnpp.runner.JunitRunner;
import com.dab.xray.Xray;

public class ExportTests {

	public static void main(String[] args) {

		export();

	}

	public static void export() {

		com.dab.config.PropertiesHandler.setConfigPath(Configurations.XrayConfigPath);

		JunitRunner.setLogger();

		Xray.exportCucumberTestsFromXray();

	}

}
