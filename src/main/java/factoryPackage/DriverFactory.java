// this class starts and initialises the driver

package factoryPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	
	// I will use the concept of thread local because in future I want to execute in the parallel mode
	// thread local is a JAVA 8 feature
	
	public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
	
	/*
	 * This method is used to initialise the threadLocalDriver on the basis of given browser
	 * @parameter == browser
	 * @returns == threadLocalDriver
	 */
	
	public WebDriver InitialiseDriver(String browser) {
		
//		if(browser == null) {
//			browser = "chrome";
//		}
		
		System.out.println(">>> Browser value is: " + browser);
		
		if(browser.equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			threadLocalDriver.set(new ChromeDriver());
			
		}else if(browser.equals("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			threadLocalDriver.set(new FirefoxDriver());
			
		}else if(browser.equals("safari")) {
			
			WebDriverManager.safaridriver().setup();
			threadLocalDriver.set(new SafariDriver());
			
		}else {
			
			System.out.println("!!! Please pass the correct browser value: " + browser);
			
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		
		return getDriver();
		
	}
	
	//create a method to get the driver
	/*
	 * Why "public static synchronized"??
	 * 
	 * if I am running multiple thread in parallel execution
	 * say 5 threads, then all the threads would be calling the getDriver() method,
	 * so all the threads should be in sync
	 */
	
	public static synchronized  WebDriver getDriver() {
		
		return threadLocalDriver.get();
		
	}

}
