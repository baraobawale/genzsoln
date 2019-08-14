$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/workspace/RTA/src/test/java/features/UC67_68_Stammdaten.feature");
formatter.feature({
  "name": "Stammdaten bestaetigen und aendern",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "\u003cTestCase\u003e\u003cExpectedResult\u003e",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "User Logs in with \u003cUserID/Kontonummer\u003e , \u003cPIN/Password\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "User submits the generated TAN number in \"TAN_field\"",
  "keyword": "And "
});
formatter.step({
  "name": "User navigates to \"Persoenliche_Einstellungen\"",
  "keyword": "And "
});
formatter.step({
  "name": "clicks on \"Aendern\"",
  "keyword": "And "
});
formatter.step({
  "name": "User enters \u003cHouse_number\u003e in Straße, Hausnr. field",
  "keyword": "And "
});
formatter.step({
  "name": "User enters \u003cPLZ\u003e in PLZ field",
  "keyword": "And "
});
formatter.step({
  "name": "User enters \u003cOrt\u003e in Ort field",
  "keyword": "And "
});
formatter.step({
  "name": "User enters \u003cLand\u003e in Land field",
  "keyword": "And "
});
formatter.step({
  "name": "User enters \u003cSteueridentifikationsnummer\u003e in Steueridentifikationsnummer field",
  "keyword": "And "
});
formatter.step({
  "name": "User selects \u003cBeruf\u003e in Beruf Field",
  "keyword": "And "
});
formatter.step({
  "name": "User selects \u003cBranche\u003e in Branche Field",
  "keyword": "And "
});
formatter.step({
  "name": "User clicks on \"Weiter\" to continue",
  "keyword": "And "
});
formatter.step({
  "name": "User submits the generated TAN number in \"TAN_field\"",
  "keyword": "And "
});
formatter.step({
  "name": "clicks on \"Bestaetigen\"",
  "keyword": "And "
});
formatter.step({
  "name": "verify changed data shown on bestaetigung page",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "TestCase",
        "ExpectedResult",
        "UserID/Kontonummer",
        "PIN/Password",
        "House_number",
        "PLZ",
        "Ort",
        "Land",
        "Steueridentifikationsnummer",
        "Beruf",
        "Branche"
      ]
    },
    {
      "cells": [
        "stammdaten_edit_mandatoryfields",
        "Success",
        "880589404",
        "12345",
        "Bahnhofstr. 55",
        "90402",
        "Nürnberg",
        "Deutschland",
        "49257301603",
        "Arbeiter(in)",
        "Chemie, Pharma"
      ]
    }
  ]
});
formatter.scenario({
  "name": "stammdaten_edit_mandatoryfieldsSuccess",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "User Logs in with 880589404 , 12345",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User submits the generated TAN number in \"TAN_field\"",
  "keyword": "And "
});
formatter.match({
  "location": "Stammdaten.user_submits_the_generated_TAN_number_in(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User navigates to \"Persoenliche_Einstellungen\"",
  "keyword": "And "
});
formatter.match({
  "location": "Stammdaten.clickson(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "clicks on \"Aendern\"",
  "keyword": "And "
});
formatter.match({
  "location": "Stammdaten.clicks_on(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User enters Bahnhofstr. 55 in Straße, Hausnr. field",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User enters 90402 in PLZ field",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User enters Nürnberg in Ort field",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User enters Deutschland in Land field",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User enters 49257301603 in Steueridentifikationsnummer field",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User selects Arbeiter(in) in Beruf Field",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User selects Chemie, Pharma in Branche Field",
  "keyword": "And "
});
formatter.match({
  "location": "Stammdaten.user_selects_Chemie_Pharma_in_Branche_Field()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User clicks on \"Weiter\" to continue",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User submits the generated TAN number in \"TAN_field\"",
  "keyword": "And "
});
formatter.match({
  "location": "Stammdaten.user_submits_the_generated_TAN_number_in(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "clicks on \"Bestaetigen\"",
  "keyword": "And "
});
formatter.match({
  "location": "Stammdaten.clicks_on(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "verify changed data shown on bestaetigung page",
  "keyword": "Then "
});
formatter.match({
  "location": "Stammdaten.verify_changed_data_shown_on_bestaetigung_page()"
});
formatter.result({
  "status": "skipped"
});
});