package Guru99;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class emailcsvfilelocators {
	public WebDriver driver;
	
	private WebElement username;
	private WebElement login;
	@FindBy(css="input.form-button")
	private WebElement loginbutton;
	@FindBy(css="a[title='close']")
	private WebElement alert1;
	@FindBy(css="ul#nav > li > a")
	private WebElement sales;
	@FindBy(css="li.level1 > a")
	private WebElement orders;
	@FindBy(css="button[title='Export']")
	private WebElement export;
	public emailcsvfilelocators(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginasuser()
	{
		username.click();
		username.sendKeys("user01");
		login.click();
		login.sendKeys("guru99com");
		loginbutton.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	public void exportCsvFile()
	{
		alert1.click();
		sales.click();
		orders.click();
		export.click();
		
	}
	public void readingCsv() throws IOException, CsvException
	{
		
		Reader r=new FileReader("C:\\Users\\Siva\\Downloads\\orders.csv");
		CSVReader reader=new CSVReader(r);
		String[] cell ;

		try{
		  while((cell=reader.readNext())!=null){
		       for(String rec:cell){
		           System.out.println(rec);
		       }
		  }
		}catch(NullPointerException z){
		    System.out.print("Your custom error message");
		}finally {
			reader.close();
		}
	}
}
