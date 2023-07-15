package pageLayerPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage_pageLayer {
	
	private WebDriver driver;
	
	// #1 creating By Locators: this is my Object Repository
	
	private By emailID = By.id("email");
	private By password = By.id("pass");
	private By signInButton = By.id("send2");
	private By forgotPasswordLink = By.xpath("//a[@class='action remind']//span[contains(text(),'Forgot Your Password?')]");
	
	// #2 creating constructor of the page:
	
	public LoginPage_pageLayer(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	// #3 creating page actions BUT BUT no assertions here, i.e. no trying to equate or calculate in pageLayer class
	
	public String getPageTitle() {
		
		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		return driver.getTitle();
	}
	
	
	public boolean isForgotPasswordLinkExit() {
		
		return driver.findElement(forgotPasswordLink).isDisplayed();
		
	}
	
	// entering username and password:
	
	public void enterUsername(String username) {
		
		driver.findElement(emailID).sendKeys(username);
		
	}
	
	public void enterPassword(String pword) {
		
		driver.findElement(password).sendKeys(pword);
		
	}
	
	// click on Sign-On button
	
	public void clickSignInButton() {
		
		driver.findElement(signInButton).click();
		
	}

}
