package Guru99;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import Guru99.Data;
import junit.framework.Assert;
import Guru99.DriverFactory;
import Guru99.DriverType;


public class Homepage {
	
	public WebDriver driver;
	private Homepagelocators hp;
	public Data data;
	@BeforeTest
	@Parameters({"userData"})
	public void setup(String userData)throws JsonParseException, JsonMappingException, IOException
	{
		driver=DriverFactory.getDriver(DriverType.CHROME);
		data=Data.get(userData);
		driver.get(Data.getUrl());
	}
	@BeforeClass
	public void intializingPageObject()
	{
		 hp=new Homepagelocators(driver);
	}
	
	@Test
	
	public void testCase1() throws IOException
	{
		String actualtitle="THIS IS DEMO SITE FOR   ";
		String expectedtitle=hp.verifytitle();
		Assert.assertEquals(expectedtitle, actualtitle);
		//hp.clickMobile();
		hp.verifyMobileByName(Data.getOption());
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("C://Users//siva//screenshot.png"));
	}
	
	@Test
	public void testCase2()
	{
		String listprice=hp.listprice();
		hp.clicksony();
		String detailprice=hp.detailprice();
		Assert.assertEquals(listprice, detailprice);
	}
	@Test
	public void testCase3()
	{
		hp.additemstocart(Data.getProduct());
		hp.addQuantity(Data.getQty());
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		hp.handlingPopup();
		String expectederrormsg=Data.getErrormsg();
		String actual=hp.captureErrorMsg();
		try
		{
		Assert.assertEquals(expectederrormsg ,actual);
	}catch(Exception e)
		{
		e.printStackTrace();
		}
		hp.emptyCart();
		String expectedcarterrormsg=Data.getCarterrormsg();
		String actualmsg=hp.emptyCartErrorMsg();
		System.out.println(actualmsg);
		try
		{
		Assert.assertEquals(expectedcarterrormsg ,actualmsg);
	}catch(Exception e)
		{
		e.printStackTrace();
		}
}
	/*@AfterTest
	public void tearDown()
	{
		driver.close();
	}*/
}
