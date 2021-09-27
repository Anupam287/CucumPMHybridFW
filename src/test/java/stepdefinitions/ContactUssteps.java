package stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.pages.ContactUsPage;
import com.qa.factory.DriverFactory;
import com.qa.utilities.ExcelsheetUtil;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class ContactUssteps {
	
	private ContactUsPage contactUsPage = new ContactUsPage(DriverFactory.getDriver());
	private Properties prop;
	
	@Given("The user navigates to the ContactUs page")
	public void the_user_navigates_to_the_contact_us_page() {
	    
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=contact");
		String title = contactUsPage.getContactPagetitle();
		System.out.println(title);
	    
	}

	@When("The user enters the required data from the Sheetname {string} and Rownumber {int}")
	public void the_user_enters_the_required_data_from_the_sheetname_and_rownumber(String sheetname, Integer rownumber) throws InvalidFormatException, IOException {
	    
		String path = contactUsPage.getProperty().getProperty("excelpath");
		
		ExcelsheetUtil excelSheetUtil = new ExcelsheetUtil();
		List<Map<String, String>> excelTestdata = excelSheetUtil.getData(path,sheetname);
		String heading = excelTestdata.get(rownumber).get("Subject Heading");
		String email = excelTestdata.get(rownumber).get("Email address");
		String message = excelTestdata.get(rownumber).get("Message");
		
		contactUsPage.fillContactForm(heading, email, message);
		
	}

	@When("The user clicks on the send button")
	public void the_user_clicks_on_the_send_button() {
	    
		contactUsPage.sendButton();
	    
	}

	@Then("The user is shown a succesful message {string}")
	public void the_user_is_shown_a_succesful_message(String expSuccessMessage) {
	    
		String ActSuccessMessage = contactUsPage.getsucessMessage();
		System.out.println(expSuccessMessage);
		System.out.println(ActSuccessMessage);
		Assert.assertEquals(expSuccessMessage, ActSuccessMessage);
	}

}
