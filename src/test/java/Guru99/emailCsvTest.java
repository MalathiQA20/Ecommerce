package Guru99;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvException;

import Guru99.emailcsvfilelocators;
public class emailCsvTest {
	public WebDriver driver;
	public emailcsvfilelocators email;
	@Test
	public void userLogin() throws IOException, CsvException 
	{
		driver=DriverFactory.getDriver(DriverType.CHROME);
		driver.get("http://live.demoguru99.com/index.php/backendlogin/");
		email=new emailcsvfilelocators(driver);
		email.loginasuser();
		email.exportCsvFile();
		email.readingCsv();
	}
	/*@Test
	public void printingCsvFile() throws IOException, CsvException
	{
		
	}*/

}
