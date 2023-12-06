package onecom.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import onecom.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{
	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		super(driver);
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath="//a[@class='btn btn-default check_out']")
	WebElement checkout;
	@FindBy(className="btn-success")
	WebElement continueoncart;
	@FindBy(xpath="//p//a[@href='/login']")
	WebElement clickLogin;
	@FindBy(xpath="//a[@class='btn btn-default check_out']")
	WebElement placeorder;
	
	public void proceedToCheckout()
	{
		checkout.click();
	}
	public void continueOnCart()
	{
		continueoncart.click();
	}
	public void loginRegister()
	{
		clickLogin.click();
	}
  public void placeOrder()
  {
	  scrollToelement(placeorder);
	  placeorder.click();
  }
	
	
}
