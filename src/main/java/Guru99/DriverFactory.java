package Guru99;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class DriverFactory {
	
	private static final Map<DriverType,Supplier<WebDriver>> drivermap =new HashMap();
	
	public static final Supplier<WebDriver> chromeDriverSupplier = () -> {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Siva\\Downloads\\SeleniumChromeDriver\\chromedriver.exe");
		String downloadFilepath = "C:\\Users\\Siva\\Downloads";
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFilepath);
		ChromeOptions options = new ChromeOptions();
	       options.setExperimentalOption("prefs", chromePrefs);
	       options.addArguments("disable-infobars");
	      options.addArguments("--test-type");
	       options.addArguments("--disable-extensions"); //to disable browser extension popup
	       options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		return new ChromeDriver(options);
	};
	
	
	public static final Supplier<WebDriver> firefoxDriverSupplier = () -> {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Siva\\Downloads\\geckodriver-v0.16.1-win64\\geckodriver.exe");
		return new ChromeDriver();
	};
	static {
		 drivermap.put(DriverType.CHROME, chromeDriverSupplier);
	     drivermap.put(DriverType.FIREFOX, firefoxDriverSupplier);
	}
	
	public static final WebDriver getDriver(DriverType type)
	{
		return drivermap.get(type).get();
	}
	
	}


