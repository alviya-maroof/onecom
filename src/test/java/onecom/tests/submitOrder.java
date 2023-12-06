package onecom.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import onecom.TestComponents.BaseTest;
import onecom.pageobjects.CartPage;
import onecom.pageobjects.HomePage;
import onecom.pageobjects.Payment;
import onecom.pageobjects.selectCategory;

public class submitOrder extends BaseTest{

	@Test(dataProvider="getData")
	public void submitorder(HashMap<String,String> input) throws IOException, InterruptedException
	{
		
		selectCategory s=new selectCategory(driver);
		s.selectcategory();
		s.selectSubCategory();
		s.getDressByName(input.get("DressType"));
       s.viewproduct("Stylish Dress");
       s.addDress(); 
       s.products();
       s.seelctBHcat();
      s.getbabyHugDress(input.get("babyHugDress"));
        s.addBHTocart(input.get("babyHugDress"));
        CartPage c=new CartPage(driver);
        c.proceedToCheckout();
        c.continueOnCart();
        c.proceedToCheckout();
        c.loginRegister();
        HomePage l=new HomePage(driver);
        l.signUp(input.get("name"),input.get("email"));	
        l.signUpPage(input.get("pwd"),input.get("Fn"),input.get("LN"),input.get("adress"),input.get("country"),input.get("state"),input.get("city"),input.get("zip"),input.get("mobile"));
        l.viewCart();
        c.proceedToCheckout();
        c.placeOrder();
		Payment p=new Payment(driver);
		p.payment("Alviya", "123456", "123", "12", "2030");
		c.downloadInvoice();
		l.logout();
		

	}
	@DataProvider
	public Object[][] getData() throws IOException
	{

		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//onecom//data//order.json");
		return new Object[][]  {{data.get(0)}};
		
	}


}
