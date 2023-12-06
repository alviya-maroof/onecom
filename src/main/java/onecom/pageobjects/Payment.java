package onecom.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Payment {
	
	WebDriver driver;
	public Payment(WebDriver driver)
	{
		//super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(name="name_on_card")
	WebElement name;
	@FindBy(name="card_number")
	WebElement cardnumber;
	@FindBy(name="cvc")
	WebElement cvc;
	@FindBy(name="expiry_month")
	WebElement expirymonth;
	@FindBy(name="expiry_year")
	WebElement expiryyear;
	@FindBy(id="submit")
	WebElement submit;
	
	public void payment(String nm, String num,String cv,String mnth, String year)
	{
		name.sendKeys(nm);
		cardnumber.sendKeys(num);
		cvc.sendKeys(cv);
		expirymonth.sendKeys(mnth);
		expiryyear.sendKeys(year);
		submit.click();
	}
	//driver.findElement(By.name("name_on_card")).sendKeys("Alviya maroof");
//	driver.findElement(By.name("card_number")).sendKeys("123456");
//	driver.findElement(By.name("cvc")).sendKeys("123");
//	driver.findElement(By.name("expiry_month")).sendKeys("12");
//	driver.findElement(By.name("expiry_year")).sendKeys("2029");
//	driver.findElement(By.id("submit")).click();
	

}
