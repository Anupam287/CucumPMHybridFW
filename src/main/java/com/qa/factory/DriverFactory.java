package com.qa.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.utilities.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	// This method is used to initialise the thread local driver based on the browser

	private WebDriver driver;

	public static ThreadLocal<WebDriver> tl = new ThreadLocal<>();
	
	private Constants constant;

	public  WebDriver init_driver(String browser) {
		
		System.out.println("browser value is: " + browser);

		if (browser.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			tl.set(new ChromeDriver());
		}

		else if (browser == "firefox") {

			WebDriverManager.chromedriver().setup();
			tl.set(new FirefoxDriver());

		}

		else if (browser == "safari") {

			
			tl.set(new SafariDriver());

		}
		
		else {
			
			System.out.println("Please pass the correct browser value: " + browser);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return getDriver();

	}
	
	// When the driver will be returned to five different instances, then to make sure all of them run in a synchronized way
	// the synchronized keyword is used
	
	
	public static synchronized WebDriver getDriver() {
		
		return tl.get();
	}

}
