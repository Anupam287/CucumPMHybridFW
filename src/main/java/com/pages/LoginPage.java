package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	// 1. private By locators
	// 2. public constructor
	// 3. pubic page methods

	private By emailId = By.id("email");
	private By password = By.id("passwd");
	private By signIn = By.id("SubmitLogin");
	private By frgtPwd = By.xpath("//a[text()='Forgot your password?'7890]");

	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	public String pageTitle() {
		
       
		return driver.getTitle();
	}

	public boolean frgtPwdLinkDispalyed() {

		return driver.findElement(frgtPwd).isDisplayed();
	}
	
	public void  frgtPwdclick() {
		
		driver.findElement(frgtPwd).click();
	}

	
	public void getUsername(String username) {

		driver.findElement(emailId).sendKeys(username);
	}

	public void getPassword(String pwd) {

		driver.findElement(password).sendKeys(pwd);
	}

	public void clickOnSignIn() {

		driver.findElement(signIn).click();
		
	}
	
	public AccountPage doLogin(String un, String pwd) {
		
		System.out.println("The user logs in with "+un+"and "+pwd);
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signIn).click();
		return new AccountPage(driver);
	}

}
