package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	private String pageTitle;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	
	@Given("The user is on the Login Page")
	public void the_user_is_on_the_login_page() {
	    
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}
 
	@When("The user gets the title of the Page")
	public void the_user_gets_the_title_of_the_page() {
	    
		pageTitle = loginPage.pageTitle();
		System.out.println("The title of the Login page is "+pageTitle);
	    
	}

	@Then("The title of the page should be {string}")
	public void the_title_of_the_page_should_be(String expTitleName) {
	    
		System.out.println(expTitleName);
		System.out.println(pageTitle);
	    Assert.assertTrue(pageTitle.equals(expTitleName));
	}

	@Then("The Forgot Password link should be displayed")
	public void the_forgot_password_link_should_be_displayed() {
	    
		Assert.assertTrue(loginPage.frgtPwdLinkDispalyed());
	    
	}

	@When("The user clicks on the Forgot Password link")
	public void the_user_clicks_on_the_forgot_password_link() {
	    
		loginPage.frgtPwdclick();
	}

	@When("The user enters username {string}")
	public void the_user_enters_username(String username) {
	    
		loginPage.getUsername(username);
	    
	}

	@When("The user enters password {string}")
	public void the_user_enters_password(String password) {
	    
		loginPage.getPassword(password);
	    
	}

	@When("The user clicks on Sign In button")
	public void the_user_clicks_on_sign_in_button()  {
	    
		loginPage.clickOnSignIn();
		
	    
	}
	
}