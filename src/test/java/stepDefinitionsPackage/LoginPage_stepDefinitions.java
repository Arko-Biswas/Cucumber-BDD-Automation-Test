package stepDefinitionsPackage;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import factoryPackage.DriverFactory;
import io.cucumber.java.en.*;
import pageLayerPackage.LoginPage_pageLayer;
import utilitiesPackage.ExcelReader;

public class LoginPage_stepDefinitions {
	
	private String pageTitle;
	
	// we need the methods on LoginPage_pageLayer
	// creating a private object
	
	private LoginPage_pageLayer LoginPage_pageLayer_obj = new LoginPage_pageLayer(DriverFactory.getDriver());
	// the constructor of the "LoginPage_pageLayer class" expects a driver in the parameter, which we can get from DriverFactory class 
	
	@Given("I am on login page")
	public void i_am_on_login_page() {
	    
		DriverFactory.getDriver().get("https://magento.softwaretestingboard.com/customer/account/");
	    
	}

	@When("I get the title of the page")
	public void i_get_the_title_of_the_page() {
	    
		pageTitle = LoginPage_pageLayer_obj.getPageTitle();
		System.out.println(">>> Page title is: " + pageTitle);
		
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedPageTitle) {
	    
		Assert.assertTrue(pageTitle.contains(expectedPageTitle));
	    
	}

	@Then("forgot password link should be displayed")
	public void forgot_password_link_should_be_displayed() {
	    
		Assert.assertTrue(LoginPage_pageLayer_obj.isForgotPasswordLinkExit());
	    
	}

	@When("I enter username {string}")
	public void i_enter_usernamename(String username) {
	    
		LoginPage_pageLayer_obj.enterUsername(username);
	    
	}

	@When("I enter password {string}")
	public void i_enter_password(String password) {
	    
		LoginPage_pageLayer_obj.enterPassword(password);
	    
	}
	
	@When("I enter username and password from sheetname {string} and rownumber {int}")
	public void i_enter_username_and_password_from_sheetname_and_rownumber(String sheetName, int rowNumber) throws InvalidFormatException, IOException {
		
		ExcelReader ExcelReader_obj = new ExcelReader();
		
		List<Map<String, String>> testData = 
				ExcelReader_obj.getData("/Users/arkobiswas/Developer/eclipse-workspace/CucumberPOMSeries/src/test/resources/testData.xlsx", sheetName);
		
		String username = testData.get(rowNumber).get("username");
		String password = testData.get(rowNumber).get("password");
		
		LoginPage_pageLayer_obj.enterUsername(username);
		LoginPage_pageLayer_obj.enterPassword(password);
	    
	}

	@When("I click on Sign In button")
	public void i_click_on_sign_in_button() {
	    
		LoginPage_pageLayer_obj.clickSignInButton();
	    
	}

}
