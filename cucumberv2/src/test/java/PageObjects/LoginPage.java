package PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Keyword.SeleniumActions;

import stepDefinitions.BrowserEnvironment;

public class LoginPage extends SeleniumActions{
	
	WebDriver driver;
	
	SeleniumActions seAct = new SeleniumActions();
	BrowserEnvironment browser = new BrowserEnvironment();
	
	
	public LoginPage(String dr) {	
	  browser.setDriver(dr);
	  this.driver =  browser.getDriver();
	  PageFactory.initElements(driver, this);
	  
	}
	
	@FindBy(id="user-name")
	WebElement usernameInputField;
	  
	@FindBy(id="password")
	WebElement passwordInputField;
	  
	@FindBy(id="login-button")
	WebElement loginButton;
	  
	@FindBy(xpath="//div[contains(@class,'error-message-container')]")
	WebElement errorText;
	  
	  
	  
	public void enterUsername(String username) {
		if(username.equals(("\"\""))) {
			username = "";
			seAct.clearAndType(usernameInputField, username);
		}else {
			seAct.clearAndType(usernameInputField, username);
		}
	}
	public void enterPassword(String password) {
		if(password.equals(("\"\""))) {
			password = "";
			seAct.clearAndType(passwordInputField, password);
		}else {
			seAct.clearAndType(passwordInputField, password);
		}
	   seAct.clearAndType(passwordInputField, password);	
	}
	 
	public void clickLogin() {
	   seAct.click(loginButton);	 
	}
	
	public ProductsPage verifyTitle() {
	   return new ProductsPage(this.driver);	
	}
	
	public void verifyErrorText() {
		String expectedError;
		if(seAct.getAttribute(usernameInputField, "value").isEmpty()){
			expectedError = "Epic sadface: Username is required";			
		}else if(seAct.getAttribute(passwordInputField, "value").isEmpty()) {
		    expectedError = "Epic sadface: Password is required";
		}else if(seAct.getAttribute(usernameInputField, "value").isEmpty() && seAct.getAttribute(passwordInputField, "value").isEmpty()){
			expectedError = "Epic sadface: Username is required";			
		}else{
		    expectedError = "Epic sadface: Username and password do not match any user in this service";
		}    
	   
	    String Actualerror = seAct.getElementText(errorText);
	    Assert.assertEquals(Actualerror, expectedError);
	}
	
	
	
	

}
