package steps;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.simple.parser.ParseException;
import com.bnpp.library.CommonActions;
import com.bnpp.utilities.TANGenerator;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;

public class GenericSteps {

	CommonActions commonActions;

	public GenericSteps(CommonActions con) {
		this.commonActions = con;
	}

	/**
	 * 
	 * @param s
	 * @throws Exception
	 *             Description Initialization before starting of each scenario
	 *             execution
	 */
	@Before
	public void before(Scenario s) throws Exception {
		commonActions.initReports(s.getName());
		commonActions.setfaturefilenameandsceanrio(s.getId(), s.getName());

	}

	/**
	 * Description Closing the resources after execution of each scenario
	 */
	@After
	public void after() {
		commonActions.quit();
	}

	// ********Common step definitions ************//

	@And("^User enters \"(.*?)\" in \"(.*?)\" field$")
	public void type(String dataKey, String locatorKey)
			throws IllegalArgumentException, InterruptedException, IOException, ParseException {
		commonActions.enterText(locatorKey, dataKey);
	}

	@And("^User clears \"(.*?)\"$")
	public void clear(String locatorKey) {

		commonActions.clearfield(locatorKey);
	}

	@And("^User clicks on \"(.*?)\"$")
	public void click(String locatorKey) throws InterruptedException {
		if(locatorKey.equals("Aendern"))
		commonActions.scrollDown();
		commonActions.click(locatorKey);

	}

	
	@And("^User navigates to \"(.*?)\" and clicks on \"(.*?)\"$")
	       public void User_mouseOvers_and_navigates_to(String mouseoverelementKey,String clickElementKey) throws InterruptedException {
	             Thread.sleep(5000);
	             commonActions.mouseover(mouseoverelementKey);
	             commonActions.click(clickElementKey);

	       }



	@And("^User selects \"(.*?)\" in \"(.*?)\" field$")
	public void select(String dataKey, String locatorKey) throws Exception {
		commonActions.selectFromDropDown(locatorKey, dataKey);
	}

	@And("^User submits generated TAN number in \"(.*?)\"$")
	public void user_submits_the_generated_TAN_number_in(String TanKey)
			throws ClientProtocolException, IOException, InterruptedException {
		if (TanKey.equals("Mobile_TAN")) {
			commonActions.refreshPage();
			Thread.sleep(2000);
		}
		commonActions.enterTokenTan(TanKey, TANGenerator.requestTan());

	}

	@And("^User Logs in with \"(.*?)\",\"(.*?)\"$")
	public void abc(String UserID_Kontonummer, String PIN_Password)
			throws Exception, InterruptedException, IOException, ParseException {
		commonActions.enterText(UserID_Kontonummer, "UserID_Kontonummer");
		commonActions.enterText(PIN_Password, "PIN_Password");
		click("Einloggen");
	}
}
