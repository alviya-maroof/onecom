package onecom.tests;

import java.time.Duration;
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

import io.github.bonigarcia.wdm.WebDriverManager;
import onecom.pageobjects.HomePage;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
		HomePage l=new HomePage(driver);
		WebElement women = driver.findElement(By.xpath("//a[@href='#Women']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", women);
		driver.findElement(By.xpath("//a[@href='#Women']")).click();
		driver.findElement(By.xpath("//*[@id=\"Women\"]/div/ul/li/a[contains(text(),'Dress')]")).click();
		//driver.findElement(By.xpath("//div[@id='cbb']")).click();
        List<WebElement> dresses=driver.findElements(By.xpath("//div[@class='features_items']/div"));
        WebElement drs=dresses.stream().filter(dress-> dress.findElement(By.cssSelector("p")).getText().equals("Stylish Dress")).findFirst().orElse(null);
        WebElement viewproduct = drs.findElement(By.xpath("//i[@class='fa fa-plus-square']"));
//		//driver.navigate().refresh();
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewproduct);
        
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewproduct);
        drs.findElement(By.xpath("//i[@class='fa fa-plus-square']")).click();
        driver.findElement(By.id("quantity")).clear();
        driver.findElement(By.id("quantity")).sendKeys("2");
        driver.findElement(By.className("cart")).click();
        driver.findElement(By.className("btn-success")).click();
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        WebElement x=driver.findElement(By.xpath("//a[@href='/brand_products/Babyhug']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", x);
        driver.findElement(By.xpath("//a[@href='/brand_products/Babyhug']")).click();
        List<WebElement> babyhugprod=driver.findElements(By.xpath("//div[@class='features_items']/div"));
        Thread.sleep(2000);
        WebElement bhprod=babyhugprod.stream().filter(bp-> bp.findElement(By.cssSelector("p")).getText().equals("Half Sleeves Top Schiffli Detailing - Pink")).findFirst().orElse(null);
        WebElement element2 = driver.findElement(By.xpath("//a[@class='btn btn-default add-to-cart']"));
		//driver.navigate().refresh();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='btn btn-default add-to-cart']")));
        bhprod.findElement(By.xpath("//a[@class='btn btn-default add-to-cart']")).click();
        driver.findElement(By.xpath("//p//a[@href='/view_cart']")).click();
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
        driver.findElement(By.className("btn-success")).click();
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
        driver.findElement(By.xpath("//p//a[@href='/login']")).click();
		driver.findElement(By.name("name")).sendKeys("Alviya");
		driver.findElement(By.xpath("//*[@action='/signup']/input[@name='email']")).sendKeys("alvi.marf@gmail.com");
		driver.findElement(By.xpath("//form[@action='/signup']//button[@type='submit']")).click();
		 WebElement password = driver.findElement(By.id("password"));
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 jse.executeScript("arguments[0].value='Alviya@1234';", password);
		WebElement nw=driver.findElement(By.id("newsletter"));
		WebElement fn=driver.findElement(By.id("first_name"));
		jse.executeScript("arguments[0].value='Alviya';", fn);
		//driver.findElement(By.id("first_name")).sendKeys("Alviya");
		WebElement ln=driver.findElement(By.id("last_name"));
		jse.executeScript("arguments[0].value='Maroof';", ln);
//		driver.findElement(By.id("last_name")).sendKeys("Maroof");
		WebElement address=driver.findElement(By.id("address1"));
		jse.executeScript("arguments[0].value='Tank Lane,PO Box:Ishakchak,Zinfitech Technologies';", address);
//		driver.findElement(By.id("address1")).sendKeys("Tank Lane,PO Box:Ishakchak,Zinfitech Technologies");
//		Select s=new Select(driver.findElement(By.id("country")));
//		s.selectByValue("India");
		WebElement state=driver.findElement(By.id("state"));
		jse.executeScript("arguments[0].value='Bihar';", state);
//		driver.findElement(By.id("state")).sendKeys("Bihar");
		WebElement city=driver.findElement(By.id("city"));
		jse.executeScript("arguments[0].value='Bhagalpur';", city);
//		driver.findElement(By.id("city")).sendKeys("Bhagalpur");
		WebElement zip=driver.findElement(By.id("zipcode"));
		jse.executeScript("arguments[0].value='812001';", zip);
//		driver.findElement(By.id("zipcode")).sendKeys("812001");
		WebElement mobile=driver.findElement(By.id("mobile_number"));
		jse.executeScript("arguments[0].value='1234567890';", mobile);
//		driver.findElement(By.id("mobile_number")).sendKeys("8757445936");
		WebElement create= driver.findElement(By.xpath("//button[@data-qa='create-account']"));
		jse.executeScript("arguments[0].scrollIntoView(true);", create);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
		//driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
		driver.findElement(By.xpath("//li/a[@href='/view_cart']")).click();
		driver.findElement(By.className("check_out")).click();
		WebElement placeOrder = driver.findElement(By.xpath("//a[@class='btn btn-default check_out']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", placeOrder);
		placeOrder.click();
		driver.findElement(By.name("name_on_card")).sendKeys("Alviya maroof");
		driver.findElement(By.name("card_number")).sendKeys("123456");
		driver.findElement(By.name("cvc")).sendKeys("123");
		driver.findElement(By.name("expiry_month")).sendKeys("12");
		driver.findElement(By.name("expiry_year")).sendKeys("2029");
		driver.findElement(By.id("submit")).click();
		driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
		driver.findElement(By.xpath("//a[@href='/logout']")).click();
		
		System.out.println("Alviya");

	}

}
