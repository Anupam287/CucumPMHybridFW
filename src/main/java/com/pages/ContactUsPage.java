package com.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.qa.utilities.ConfigReader;

public class ContactUsPage {

	private ConfigReader configReader;
	private Properties prop;
	private WebDriver driver;

	private By subjectHeading = By.id("id_contact");
	private By email = By.id("email");
	private By message = By.id("message");
	private By sendButton = By.id("submitMessage");
	private By successMsg = By.cssSelector("p[class= 'alert alert-success']");

	public ContactUsPage(WebDriver driver) {

		this.driver = driver;
	}

	public String getContactPagetitle() {

		return driver.getTitle();

	}

	public void fillContactForm(String heading, String emailId, String msg) {

		Select select = new Select(driver.findElement(subjectHeading));
		select.selectByVisibleText(heading);
		driver.findElement(email).sendKeys(emailId);
		driver.findElement(message).sendKeys(msg);
	}

	public void sendButton() {

		driver.findElement(sendButton).click();
	}

	public String getsucessMessage() {

		return driver.findElement(successMsg).getText();
	}

	public Properties getProperty() {

		ConfigReader configReader = new ConfigReader();
		prop = configReader.init_prop();
		return prop;
	}

}