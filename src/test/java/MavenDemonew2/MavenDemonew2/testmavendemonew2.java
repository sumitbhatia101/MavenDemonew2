package MavenDemonew2.MavenDemonew2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testmavendemonew2 {
	
	static WebDriver driver;
	
	@BeforeTest
	public void SetUP() throws IOException, InterruptedException {

	

			Properties prop = new Properties();
			
			FileInputStream ip = new FileInputStream("F:\\Eclipse workspace\\newbee\\src\\newbee\\config.properties");
			
			prop.load(ip);
			
			System.out.println(prop.getProperty("browser"));
			
			String url =prop.getProperty("url");
			String browser =prop.getProperty("browser");
			
			if(browser.equals("Chrome")) {
			
			         System.setProperty("webdriver.chrome.driver", "C:\\Users\\sumit\\eclipse\\jee-2019-123\\eclipse\\ChromeDriver\\chromedriver.exe");
			         driver = new ChromeDriver();
			
			}
			
			else if (browser.equals("Firefox")) {
				
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\sumit\\eclipse\\jee-2019-123\\eclipse\\firefoxdriver\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
			driver.get(url);
			
			//driver.manage().timeouts().pageLoadTimeout(30, );
			
			Thread.sleep(3000);
			
			driver.findElement(By.name(prop.getProperty("firstname_name"))).sendKeys(prop.getProperty("name"));
			driver.findElement(By.name(prop.getProperty("lastname_name"))).sendKeys(prop.getProperty("nachname"));
			
			Select sel = new Select(driver.findElement(By.name(prop.getProperty("usertitle_name"))));
			sel.selectByVisibleText(prop.getProperty("title"));
			
		
			driver.findElement(By.name(prop.getProperty("userphone_name"))).sendKeys(prop.getProperty("tel"));
			driver.findElement(By.name(prop.getProperty("companyname_name"))).sendKeys(prop.getProperty("company"));
			driver.findElement(By.name(prop.getProperty("useremail_name"))).sendKeys(prop.getProperty("email"));
			
			Select sel2 = new Select(driver.findElement(By.name(prop.getProperty("companyemployees_name"))));
			sel2.selectByVisibleText(prop.getProperty("size"));
			
			//Thread.sleep(1000);
			
			
			//	Thread.sleep(5000);
			driver.findElement(By.xpath(prop.getProperty("iagree_xpath"))).click();
			
			//Thread.sleep(5000);
			driver.findElement(By.xpath(prop.getProperty("submit_xpath"))).click();
			
			
			//Thread.sleep(5000);
			
			
			
				        
			
			

		 
	}

	@Test
	public void test() throws InterruptedException {
		
	Thread.sleep(62000);
	//driver.manage().timeouts().pageLoadTimeout(30, Seconds );
	System.out.println(driver.getTitle());
	String x = driver.getCurrentUrl();
	
	System.out.println(x);
	
	Assert.assertEquals(x, "https://ap16.lightning.force.com/lightning/page/home");
	}
	
//	@Test
//	public void test2() {
//		boolean b = 
//		
//
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
}


