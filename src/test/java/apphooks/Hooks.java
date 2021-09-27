 package apphooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.utilities.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	private ConfigReader configReader;
	private Properties prop;
	private DriverFactory driverFactory;
	private WebDriver driver;
	
	@Before(order=0)
	public void getProperty() {
		
		ConfigReader configReader = new ConfigReader();
		prop = configReader.init_prop();
	}
	@Before(order=1)
	public void launchBrowser() {
		String browserName =prop.getProperty("browser");
		 DriverFactory driverFactory = new  DriverFactory();
		 driver = driverFactory.init_driver(browserName);
		
	}
	
	@After(order =0)
	public void closeBrowser() {
		
		driver.quit();
	}
	
	@After(order = 1)
    public void takeScreenshot(Scenario scenario) {
		
		if(scenario.isFailed()) {
			
			String screenshotName= scenario.getName().replace(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
	}
}