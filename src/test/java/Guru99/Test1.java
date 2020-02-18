package Guru99;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class Test1 {
	public WebDriver driver;
 @Test
 public void checkingtitle()
 {
	 driver=DriverFactory.getDriver(DriverType.CHROME);
	 driver.manage().window().maximize();
	 driver.get(" http://live.demoguru99.com/");
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//li[@class='level0 nav-1 first']/a")).click();
		List<WebElement> products=driver.findElements(By.xpath("//h2[@class='product-name']"));
		System.out.println(products.size());
		products.stream().filter(e -> e.getText().contains("SONY XPERIA")).findFirst().get().click();
		//List<WebElement> addtocart=driver.findElements(By.cssSelector("div.actions > button"));
		/*for(int i=0;i<products.size();i++)
		{
			String names=products.get(i).getText();
			System.out.println(names);
			if(names.contains("SONY XPERIA"))
			{
				addtocart.get(i).click();
				break;
			}
		}*/
		WebElement quantity=driver.findElement(By.cssSelector("input[title='Qty"));
		quantity.click();
		quantity.clear();
		quantity.sendKeys("1000");
		driver.findElement(By.cssSelector("button[title='Update']")).click();
		String errormsg=driver.findElement(By.xpath("//p[@class='item-msg error']")).getText();
		//System.out.println(driver.findElement(By.cssSelector("#product-price-1 > span")).getText());
		System.out.println(errormsg);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.switchTo().frame(driver.findElement(By.id("flow_close_btn_iframe")));
		driver.findElement(By.id("closeBtn")).click();
		driver.switchTo().defaultContent();
 }
}
