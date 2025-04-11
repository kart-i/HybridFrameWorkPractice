package stepDefinitions;

import PageObjects.LoginPage;
import PageObjects.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTestCases {
	
	LoginPage login;
	ProductsPage products;
	
	@Given ("the browser environment is {string} and the page is {string}")
	public void user_is_on_the_login_page(String browser,String url) {
		
	 login = new LoginPage(browser);	
	 login.startApp(url);
	 
	}
	
	@When("^the user enters (.*) and (.*) and click login$")
	public void the_user_enters_username_and_password(String username,String password) {
		
	 login.enterUsername(username);
	 login.enterPassword(password);
	 login.clickLogin();
	 
	}
	
	@Then("verify if the user is redirected to products page")
	public void verify_if_the_user_is_redirected_to_products_page() {
		
	 products = login.verifyTitle();
	 products.getTitleElement();
	   
	}
	@Then("verify if the error is displayed")
	public void verify_if_the_error_is_displayed() {
		login.verifyErrorText();
	}
		
}
	
