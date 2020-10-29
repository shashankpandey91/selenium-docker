package test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	protected WebDriver driver;
	@BeforeTest
	public void setupDriver() throws MalformedURLException
	{
	String host="localhost";
		DesiredCapabilities dc;
		
		if(System.getProperty("browser")!=null && System.getProperty("browser").equals("firefox"))
		{
			dc= DesiredCapabilities.firefox();
		}
		else {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--no-sandbox") ;
			dc=DesiredCapabilities.chrome();
			
			
		}
		if(System.getProperty("HUB_HOST")!=null)
		{
			host=System.getProperty("HUB_HOST");
		}
String completeUrl="http://"+host+":4444/wd/hub";
this.driver= new RemoteWebDriver(new URL(completeUrl),dc);
	//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rushank\\selenium_jars\\chrome driver\\chromedriver.exe");
		//this.driver=new ChromeDriver();
	}
	
	@AfterTest
	public void tearDown()
	{
		 this.driver.quit();
	}
}
