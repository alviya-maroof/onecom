package onecom.AbstractComponents;

import java.sql.Timestamp;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class AbstractComponent {
	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//a[@href='/products']")
	WebElement products;
	@FindBy(xpath="//li/a[@href='/view_cart']")
	WebElement cart;
	@FindBy(xpath="//a[@class='btn btn-default check_out']")
	WebElement invoice;
	
	public void waitforclickableElement(By findBy) {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.elementToBeClickable(findBy));
	}
	
	public void scrollToelement(WebElement ele)
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
	}
	public void products()
	{
		products.click();
	}
	public void sendValue(String value1, WebElement fieldname)
	{
		
		((JavascriptExecutor) driver).executeScript("arguments[0].value='"+value1+"';",fieldname);
	}
	public void viewCart()
	{
		cart.click();
	}
	public void downloadInvoice()
	{
		invoice.click();
	}
	 
	    public static String timeStamp() {
	    	
	    	long currentTimeMillis = System.currentTimeMillis();
  
	    	String email=currentTimeMillis+"@gmail.com";
	         
	        return email;
	    }  
	}  

	

