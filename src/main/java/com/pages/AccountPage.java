package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.factory.DriverFactory;

public class AccountPage {
	
	
	
	private WebDriver driver;
	
	private By accountSection = By.cssSelector("div[class = 'row addresses-lists'] span");
	
	public AccountPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public String getAccountPageTitle() {
		
		return driver.getTitle();
	}
	
	public int getAccountsectioncount() {
		
		return driver.findElements(accountSection).size();
		
	}
	
	public List<String> getAccountSectionList() {
		
		List<String> accountSectionList= new ArrayList<>();
		List<WebElement> accountList= driver.findElements(accountSection);
		
		for(WebElement e :accountList) {
			
			String text = e.getText();
			System.out.println(text);
			accountSectionList.add(text);
		}
		
		return accountSectionList;
	}

}
