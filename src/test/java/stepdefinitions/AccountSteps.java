package stepdefinitions;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Assert;

import com.pages.AccountPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountPage accountPage;
	
	@Given("The user is already logged into the application")
	public void the_user_is_already_logged_into_the_application(DataTable credsTable) {
	   
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
		List<Map<String, String>> credsList= credsTable.asMaps();
		String username = credsList.get(0).get("Username");
		String password = credsList.get(0).get("Password");
		accountPage= loginPage.doLogin(username, password);
		
		
	}

	@Given("The user is on the Account page")
	public void the_user_is_on_the_account_page() {
	    
		String title = accountPage.getAccountPageTitle();
		System.out.println("The Title of the account page is "+title);
	}

	@Then("The user gets the Account section")
	public void the_user_gets_the_account_section(DataTable expAccountSectionDatatable) {
	    
		List<String> expList =expAccountSectionDatatable.asList();
		List<String> expAccountSectionList = expList.stream()
                .map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.print(expAccountSectionList);
		
		List<String> actualAccountSectionList = accountPage.getAccountSectionList();
		System.out.print(actualAccountSectionList);
		
		Assert.assertTrue(expAccountSectionList.containsAll(actualAccountSectionList));
	}

	@Then("The Account section count is {int}")
	public void the_account_section_count_is(Integer expAccountsectionCount) {
	    
		int actualAccountsectionCount   = accountPage.getAccountsectioncount();
		Assert.assertTrue(actualAccountsectionCount==expAccountsectionCount);
	}

}
