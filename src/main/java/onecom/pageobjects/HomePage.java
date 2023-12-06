package onecom.pageobjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import onecom.AbstractComponents.AbstractComponent;

public class HomePage extends AbstractComponent {
WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(name="name")
	WebElement name;
	@FindBy(xpath="//*[@action='/signup']/input[@name='email']")
	WebElement email;
	@FindBy(xpath="//form[@action='/signup']//button[@type='submit']")
	WebElement signup;
	@FindBy(id="password")
	WebElement Password;
	@FindBy(id="newsletter")
	WebElement Newsletter;
	@FindBy(id="first_name")
	WebElement Firstname;
	@FindBy(id="last_name")
	WebElement LastName;
	@FindBy(id="address1")
	WebElement Address1;
	@FindBy(id="country")
	WebElement Country;
	@FindBy(id="state")
	WebElement State;
	@FindBy(id="city")
	WebElement City;
	@FindBy(id="zipcode")
	WebElement Zipcode;
	@FindBy(id="mobile_number")
	WebElement MobileNumber;
	@FindBy(xpath="//button[@data-qa='create-account']")
	WebElement CreateAccount;
	@FindBy(xpath="//a[@data-qa='continue-button']")
	WebElement Continue;
	@FindBy(xpath="//a[@href='/logout']")
	WebElement logOut;
	@FindBy(xpath="//form[@action='/signup']/p")
	WebElement errormessage;
	
    By create=By.xpath("//button[@data-qa='create-account']");

	public void gotTo() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"//src//main//java//onecom//resources//GlobalData.properties");
		prop.load(fis);
		String URL=prop.getProperty("URL");
		driver.get(URL);
	}
	public void signUp(String Name, String Email)
	{
		name.sendKeys(Name);
		email.sendKeys(Email);
		signup.click();
	}
	
	public void signUpPage(String pwd, String FN,String LN, String addrs,String cntry ,String st, String cty, String zip, String MN)
	{
																											
		sendValue(pwd,Password);
		scrollToelement(Newsletter);
		Newsletter.click();
		sendValue(FN,Firstname);
		sendValue(LN,LastName);
		sendValue(addrs,Address1);
		Select s=new Select(Country);
        s.selectByValue(cntry);
        sendValue(st,State);
		sendValue(cty,City);
		sendValue(zip,Zipcode);
		sendValue(MN,MobileNumber);
		scrollToelement(CreateAccount);;
		CreateAccount.click();
		
		Continue.click();
	} 
	public void logout()
	{
		logOut.click();
	}
	public void getErrorMessage() {
		errormessage.getText();	}

}
