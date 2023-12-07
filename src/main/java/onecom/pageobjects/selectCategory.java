package onecom.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import onecom.AbstractComponents.AbstractComponent;

public class selectCategory extends AbstractComponent{
WebDriver driver;

	
	public selectCategory(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath="//a[@href='#Women']")
	WebElement women;
	@FindBy(xpath="//*[@id='Women']/div/ul/li/a[contains(text(),'Dress')]")
	WebElement dress;
	@FindBy(xpath="//div[@class='features_items']/div")
	List<WebElement> dresses;
	@FindBy(id="quantity")
	WebElement quantity;
	
	@FindBy(className="btn-success")
	WebElement continueShoping;
	@FindBy(xpath="//div[@class='features_items']/div")
	List<WebElement> babyHugDresses;
	@FindBy(xpath="//a[@href='/brand_products/Babyhug']")
	WebElement babyHug;
	@FindBy(className="add-to-cart")
	WebElement BHaddToCart;
	@FindBy(className="cart")
	WebElement addDressToCart;

	@FindBy(xpath="//p//a[@href='/view_cart']")
	WebElement viewCart;
	
	By viewProduct=By.xpath("//a[@href='/product_details/4']");
	By cart=By.xpath("//a[@data-product-id='12']/i");
	By viewcart=By.xpath("//p//a[@href='/view_cart']");
	By cs=By.className("btn-success");
	
	public void selectcategory()
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", women);
		women.click();
	}

	public void selectSubCategory()
	{
		
	dress.click();
	}
	public List<WebElement> dressList()
	{
		
		return dresses;
	}
	public List<WebElement> babyHugDress()
	{
		return babyHugDresses;
	}
	public WebElement getDressByName(String dress)
	{
		
		WebElement drs=dressList().stream().filter(d-> d.findElement(By.cssSelector("p")).getText().equalsIgnoreCase(dress)).findFirst().orElse(null);
		System.out.println(drs);
		return drs;
		
		
	}
	public void viewproduct(String d)
	{
		WebElement ds=getDressByName(d);
		//System.out.println(ds.getText());
		
		WebElement viewproduct2 = ds.findElement(viewProduct);
		System.out.println(viewproduct2);
		scrollToelement(viewproduct2);
		viewproduct2.click();
		
	}
	
	public void addDress() throws InterruptedException
	{
		quantity.clear();
		quantity.sendKeys("2");
		addDressToCart.click();
		waitforclickableElement(cs);
		continueShoping.click();
	}
	public void seelctBHcat()
	{
		scrollToelement(babyHug);
		babyHug.click();
	}
	
	public WebElement getbabyHugDress(String babydrs)
	{
		WebElement bhdrs=babyHugDress().stream().filter(d-> d.findElement(By.cssSelector("p")).getText().equals(babydrs)).findFirst().orElse(null);
		System.out.println(bhdrs);
		return bhdrs;
		
	}
	public void addBHTocart(String babydrs) throws InterruptedException
	{
		WebElement bh=getbabyHugDress(babydrs);
		WebElement addTocart2 = bh.findElement(cart);
		scrollToelement(addTocart2);
		addTocart2.click();
		waitforclickableElement(viewcart);
		viewCart.click();
		
		
	}
	
	

}
