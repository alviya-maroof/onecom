package onecom.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import onecom.pageobjects.HomePage;

public class BaseTest {
	public WebDriver driver;
	public WebDriver initializeDriver() throws IOException
	{ 
		Properties prop=new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"//src//main//java//onecom//Resources//GlobalData.properties");
		prop.load(fis);
		String browser = System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
		String chromePath =prop.getProperty("chromedriverpath");
		String fire=prop.getProperty("firefoxdriverpath");
		
		
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",chromePath);
//		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			
			System.setProperty("webdriver.gecko.driver",
					fire);
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	@BeforeMethod
	public void launchApp() throws IOException
	{
        driver=initializeDriver();
		HomePage l=new HomePage(driver);
		l.gotTo();
	}
@AfterMethod
public void close()
{
	driver.close();
}
public List<HashMap<String, String>> getJsonDataToMap(String Filepath) throws IOException
{
	 String jsonContent = 	FileUtils.readFileToString(new File(Filepath), 
				StandardCharsets.UTF_8);
		
		
		ObjectMapper mapper = new ObjectMapper();
		  List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
	      });
		  return data;
		
}

}
