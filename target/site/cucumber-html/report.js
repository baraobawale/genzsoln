$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/features/UC67_68_Stammdaten.feature");
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
  "name": "Verify \u003cErrorMesssages\u003e are displayed",
  "keyword": "Then ",
  "rows": [
    {
      "cells": [
        "ErrorMesssages"
      ]
    },
    {
      "cells": [
        "\"Bitte korrigieren Sie die folgenden Punkte:\""
      ]
    },
    {
      "cells": [
        "\"Branche: Bitte wählen Sie die Branche, in der Sie arbeiten, aus.\""
      ]
    },
    {
      "cells": [
        "\"PLZ: Dieses Feld muss angegeben werden.\""
      ]
    },
    {
      "cells": [
        "\"Straße, Hausnr.: Dieses Feld muss angegeben werden.\""
      ]
    },
    {
      "cells": [
        "\"Ort: Dieses Feld muss angegeben werden.\""
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
        "Branche"
      ]
    },
    {
      "cells": [
        "stammdaten_error_blankmandatoryfields",
        "Verify errors",
        "880589404",
        "12345",
        "\"\"",
        "\"\"",
        "\"\"",
        "\"Bitte auswählen\""
      ]
    }
  ]
});
formatter.scenario({
  "name": "stammdaten_error_blankmandatoryfieldsVerify errors",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User Logs in with 880589404 , 12345",
  "keyword": "When "
});
formatter.match({
  "location": "Stammdaten.user_Logs_in_with(int,int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User submits the generated TAN number in \"TAN_field\"",
  "keyword": "And "
});
formatter.match({
  "location": "Stammdaten.user_submits_the_generated_TAN_number_in(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User navigates to \"Persoenliche_Einstellungen\"",
  "keyword": "And "
});
formatter.match({
  "location": "Stammdaten.clickson(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clicks on \"Aendern\"",
  "keyword": "And "
});
formatter.match({
  "location": "Stammdaten.clicks_on(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters \"\" in Straße, Hausnr. field",
  "keyword": "And "
});
formatter.match({
  "location": "Stammdaten.user_enters_house_no_in_Straße_Hausnr_field(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters \"\" in PLZ field",
  "keyword": "And "
});
formatter.match({
  "location": "Stammdaten.user_enters_PLZ_in_PLZ_field(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters \"\" in Ort field",
  "keyword": "And "
});
formatter.match({
  "location": "Stammdaten.user_enters_Ort_in_Ort_field(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User selects \"Bitte auswählen\" in Branche Field",
  "keyword": "And "
});
formatter.match({
  "location": "Stammdaten.user_selects_Bitte_auswaehlen_in_Branche_Field(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on \"Weiter\" to continue",
  "keyword": "And "
});
formatter.match({
  "location": "Stammdaten.user_clicks_on_to_continue(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify \u003cErrorMesssages\u003e are displayed",
  "rows": [
    {
      "cells": [
        "ErrorMesssages"
      ]
    },
    {
      "cells": [
        "\"Bitte korrigieren Sie die folgenden Punkte:\""
      ]
    },
    {
      "cells": [
        "\"Branche: Bitte wählen Sie die Branche, in der Sie arbeiten, aus.\""
      ]
    },
    {
      "cells": [
        "\"PLZ: Dieses Feld muss angegeben werden.\""
      ]
    },
    {
      "cells": [
        "\"Straße, Hausnr.: Dieses Feld muss angegeben werden.\""
      ]
    },
    {
      "cells": [
        "\"Ort: Dieses Feld muss angegeben werden.\""
      ]
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "Stammdaten.verify_error_messsages_are_displayed(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});