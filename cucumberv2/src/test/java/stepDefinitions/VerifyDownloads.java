package stepDefinitions;

import java.io.File;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Keyword.SeleniumActions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyDownloads extends SeleniumActions {
	
	@When ("the user click the url")
	public void verifyDownload() throws InterruptedException {
		startApp("https://practice.expandtesting.com/download");
		WebElement element = locateElement("XPATH","//a[@data-testid='1744264251943_AddtoCart']");
		Thread.sleep(3000);
		moveToElement(element);
		clickUsingJs(element);
	}
	
	@Then ("verify if the file is present") 
	public void isFileDownloaded() {
		 boolean fileExists = false;
		 File dir = new File(downloadPath);
		 File[] dirContents = dir.listFiles();

		 for (File file : dirContents) {
		    if (file.getName().equals(fileName)) {
		            fileExists = true;
		     }
		  }
		 Assert.assertTrue(fileExists, "Excel report was not downloaded.");	  
	}
	
		
	
	
	
	
	
	
	
}
