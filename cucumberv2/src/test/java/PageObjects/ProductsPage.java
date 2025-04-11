package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Keyword.SeleniumActions;

public class ProductsPage extends SeleniumActions {
	
	WebDriver driver;
	SeleniumActions seAct = new SeleniumActions();
	
	@FindBy(xpath="//span[@class='title']")
	WebElement title;
	
	public ProductsPage(WebDriver dr) {
		this.driver = dr;
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void getTitleElement() {
		
	 String headerTitle = seAct.getElementText(title);
	 Assert.assertEquals(headerTitle, "Products");
	 System.out.println("hello");
	
	}
	
	
	
	
	

}
