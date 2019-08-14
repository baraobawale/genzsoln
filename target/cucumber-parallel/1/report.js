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
  "name": "User selects \u003cBranche\u003e in Branche Field",
  "keyword": "And "
});
formatter.step({
  "name": "User clicks on \"Weiter\" to continue",
  "keyword": "And "
});
formatter.step({
  "name": "Verify error \"Bitte korrigieren Sie die folgenden Punkte:\" is displayed",
  "keyword": "Then "
});
formatter.step({
  "name": "Verify error messsages are displayed",
  "keyword": "And ",
  "rows": [
    {
      "cells": [
        "messages"
      ]
    },
    {
      "cells": [
        "Branche: Bitte wählen Sie die Branche, in der Sie arbeiten, aus."
      ]
    },
    {
      "cells": [
        "PLZ: Dieses Feld muss angegeben werden."
      ]
    },
    {
      "cells": [
        "Straße, Hausnr.: Dieses Feld muss angegeben werden"
      ]
    },
    {
      "cells": [
        "Ort: Dieses Feld muss angegeben werden."
      ]
    }
  ]
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
        "Branche"
      ]
    },
    {
      "cells": [
        "stammdaten_error_blankmandatoryfields",
        "Verify errors",
        "880589404",
        "12345",
        "null",
        "null",
        "null",
        "null",
        "Bitte auswaehlen"
      ]
    }
  ]
});
formatter.scenario({
  "name": "stammdaten_error_blankmandatoryfieldsVerify errors",
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
  "name": "User enters null in Straße, Hausnr. field",
  "keyword": "And "
});
formatter.match({
  "location": "Stammdaten.user_enters_null_in_Straße_Hausnr_field()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User enters null in PLZ field",
  "keyword": "And "
});
formatter.match({
  "location": "Stammdaten.user_enters_null_in_PLZ_field()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User enters null in Ort field",
  "keyword": "And "
});
formatter.match({
  "location": "Stammdaten.user_enters_null_in_Ort_field()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User selects Bitte auswaehlen in Branche Field",
  "keyword": "And "
});
formatter.match({
  "location": "Stammdaten.user_selects_Bitte_auswaehlen_in_Branche_Field()"
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
  "name": "Verify error \"Bitte korrigieren Sie die folgenden Punkte:\" is displayed",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "Verify error messsages are displayed",
  "rows": [
    {
      "cells": [
        "messages"
      ]
    },
    {
      "cells": [
        "Branche: Bitte wählen Sie die Branche, in der Sie arbeiten, aus."
      ]
    },
    {
      "cells": [
        "PLZ: Dieses Feld muss angegeben werden."
      ]
    },
    {
      "cells": [
        "Straße, Hausnr.: Dieses Feld muss angegeben werden"
      ]
    },
    {
      "cells": [
        "Ort: Dieses Feld muss angegeben werden."
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "Stammdaten.verify_error_is_displayed(DataTable)"
});
formatter.result({
  "status": "skipped"
});
});