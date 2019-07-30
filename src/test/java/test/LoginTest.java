package test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
	public class LoginTestPage  {
		WebDriver driver;
		Logger logger;
		
		@BeforeMethod
		public void setUp(){

			System.setProperty("webdriver.chrome.driver", "D:\\Sankalp\\Demo\\Jenkins_Demo\\Driver\\chromedriver.exe");	
			driver = new ChromeDriver(); 
			logger = Logger.getLogger("Devops_Demo");
			PropertyConfigurator.configure("Log4j.properties");
			logger.info("Browser get opened");
			driver.get("https://demo.cyclos.org/#login");
			logger.info("Cyclos login page get opened");
			driver.manage().window().maximize();
			logger.info("Cyclos window get maximized");
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		@Test(priority=1)
		public void loginPageTitleTest(){
			String title=driver.getTitle();
			System.out.println("The title of the page is: "+title);
			logger.info("title get displayed");
			
		}
		
		@Test(priority=2)
		public void loginToCyclo() {
			driver.findElement(By.xpath("//input[@name='principal']")).sendKeys("demo");
			logger.info("Enter the username");
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("1234");
			logger.info("Enter the password");
			driver.findElement(By.xpath("//div[text()='Sign in']")).click();
			logger.info("clicked on sigin button");
			
		}
			
		
		@AfterMethod
		public void tearDown(){
			driver.quit();
			logger.info("After completing task browser get quit");
		}}}

