package stepDefinitions;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.HasCdp;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BrowserEnvironment {
	
	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private static final ThreadLocal<WebDriverWait> wait = new  ThreadLocal<WebDriverWait>();
	
	public void setWait() {
		wait.set(new WebDriverWait(getDriver(), Duration.ofSeconds(10)));
	}

	public WebDriverWait getWait() {
		return wait.get();
	}

	public String createTempDownloadFolder() {
	    String folderName = "TestDownloads_" + System.currentTimeMillis();
	    String downloadPath = System.getProperty("user.dir") + File.separator + folderName;
	    new File(downloadPath).mkdirs();
	    return downloadPath;
	}
	
	public void setDriver(String browser) {	
		
		String path = createTempDownloadFolder();
		HashMap<String, Object> prefs = new HashMap<>();
	    prefs.put("profile.default_content_settings.popups", 0);
	    prefs.put("download.default_directory", path);
	    prefs.put("download.prompt_for_download", false);
	    prefs.put("safebrowsing.enabled", true);
	    		
		switch (browser) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized"); 
			options.addArguments("--disable-notifications"); 
			options.addArguments("--incognito");
			options.addArguments("–-no-first-run");
			options.addArguments("–-no-default-browser-check");
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--disable-save-password-bubble");
			options.setExperimentalOption("prefs", prefs);
			driver.set(new ChromeDriver(options));
			
			ChromeDriver crDriver = (ChromeDriver) getDriver();	
			Map<String, Object> commandParams = new HashMap<>();
			commandParams.put("behavior", "allow");
			commandParams.put("downloadPath", path);
			crDriver.executeCdpCommand("Page.setDownloadBehavior", commandParams);			
			break;
		case "firefox":
			driver.set(new FirefoxDriver());
			break;
		case "edge":
			driver.set(new EdgeDriver());
			break;	
		case "ie":
			driver.set(new InternetExplorerDriver());
		default:
			break;
		}
	}
	public WebDriver getDriver() {
		return driver.get();
	}

}
