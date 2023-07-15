package appsHooksPackage;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factoryPackage.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilitiesPackage.ConfigReader;

public class ApplicationHooks {
	
	private DriverFactory DriverFactory_obj;
	private WebDriver driver;
	private ConfigReader ConfigReader_obj;
	//maintaining a Properties class reference
	Properties properties;
	
	@Before(order = 0)
	public void getProperty() {
		
		// creating an object of ConfigReader class so that we can call the InitializeProperties() method
		ConfigReader_obj = new ConfigReader();		
		
		properties = ConfigReader_obj.InitializeProperties();
		
		System.out.println(">>> " + properties);
				
	}
	
	@Before( order = 1)
	public void launchBrowser() {
		
		String browserName = properties.getProperty("browser");
		
		// creating an object of DriverFactory
		DriverFactory_obj = new DriverFactory();
		
		driver = DriverFactory_obj.InitialiseDriver(browserName);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					
	}
	
	@After( order = 0 )
	public void quitBrowser() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.quit();
		
	}
	
	@After( order = 1 )
	public void tearDown(Scenario Scenario_obj) {
		
		if(Scenario_obj.isFailed()) {
			
			//take screenshot:
			String screenShotName = Scenario_obj.getName().replaceAll(" ", "_");
			byte [] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			
			Scenario_obj.attach(sourcePath, "image/png", screenShotName);
			
		}
		
	}

}














