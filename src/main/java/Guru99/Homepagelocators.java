package Guru99;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Homepagelocators {
	public WebDriver driver;
	
	@FindBy(css="h2")
	private WebElement title;
	
	@FindBy(xpath="//li[@class='level0 nav-1 first']/a")
	private WebElement Mobile;
	
	@FindBy(css="select[title='Sort By']")
	private WebElement SortBy;
	
	@FindBy(css="#product-price-1 > span")
	private WebElement Sonyprice;
	
	@FindBy(css="#product-collection-image-1")
	private WebElement Clicksony;
	
	@FindBy(css="span.price")
	private WebElement detailpageprice;
	
	@FindBy(css="h2.product-name")
	List<WebElement> productnames;
	
	@FindBy(css="div.actions > button")
	List< WebElement> addtocart;
	@FindBy(css="input[title='Qty']")
	private WebElement quantity;
	
	@FindBy(css="button[title='Update']")
	private WebElement update;
	
	@FindBy(xpath="//p[@class='item-msg error']")
	private WebElement errormsg;
	
	@FindBy(id="flow_close_btn_iframe")
	private WebElement iframe;
	private WebElement closeBtn;
	private WebElement empty_cart_button;
	
	@FindBy(tagName="h1")
	private WebElement emptycartmsg;
	
	public Homepagelocators(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String verifytitle()
	{
		return title.getText();
	}

	public void verifyMobileByName(String option)
	{
		Mobile.click(); 
		Select dropdown=new Select(SortBy);
		dropdown.selectByVisibleText(option);
		
	}
	
	public String listprice()
	{
		return Sonyprice.getText();
		
	}
	
	public void clicksony()
	{
		Clicksony.click();
	}
	
	public String detailprice()
	{
		
		return detailpageprice.getText();
	}
	
	public void additemstocart(String product)
	{
		Mobile.click();
		for(int i=0;i<productnames.size();i++)
		{
			String names=productnames.get(i).getText();
			if(names.contains(product))
			{
				addtocart.get(i).click();
				break;
			}
		}
	}
	public void addQuantity(String qty)
	{
		quantity.click();
		quantity.clear();
		quantity.sendKeys(qty);
		update.click();
	}
	public void handlingPopup()
	{
		driver.switchTo().frame(iframe);
		closeBtn.click();
		driver.switchTo().defaultContent();
	}
	public String captureErrorMsg()
	{
		return errormsg.getText();
	}
    public void emptyCart()
    {
    	empty_cart_button.click();
    }
    public String emptyCartErrorMsg()
    {
    	return emptycartmsg.getText();
    }
}
