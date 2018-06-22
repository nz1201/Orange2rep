package tests;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.base.CharMatcher;

public class Orange2 {
	WebDriver dr;
	String newWindow ="";
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/aa/Documents/seleniumDependancy/drivers/chromedriver");
		dr = new ChromeDriver();
	}

	@BeforeMethod
	public void get() {
		dr.get("http://opensource.demo.orangehrmlive.com");
	}

	@Test
	public void linkCheck() {
		// dr.findElement(By)
		WebElement links;
		
		List<WebElement> linkText = dr.findElements(By.xpath("//a"));
		int winNum=0;
		for (WebElement element : linkText) {
			element.click();
//			System.out.println(element);
//			Assert.assertNotNull(element);
			// links = element;//404
			
			String firstWin=dr.getWindowHandle();
			Set<String> window = dr.getWindowHandles();
		 winNum = window.size()-1;
		}Assert.assertTrue(winNum ==5);		
	}

	@Test
	public void login() throws InterruptedException {
		WebElement username = dr.findElement(By.id("txtUsername"));
		WebElement password = dr.findElement(By.id("txtPassword"));
		WebElement login = dr.findElement(By.id("btnLogin"));
		username.sendKeys("Admin");
		password.sendKeys("admin");
		login.click();
		dr.findElement(By.cssSelector("a#menu_pim_viewPimModule")).click();
		Thread.sleep(3000);
		dr.findElement(By.xpath("//form[@id='search_form']//input")).sendKeys("John Smith");
		Thread.sleep(3000);
		dr.findElement(By.cssSelector("input#searchBtn")).click();
		 String johnName = dr.findElement(By.xpath("(//td[@class='left']/a)[2]")).getText();
		 String smithLastName = dr.findElement(By.xpath("(//td[@class='left']/a)[3]")).getText();
		 String name = johnName+ " "+smithLastName;
		 String fullname = "John Smith";
		 Assert.assertEquals(name, fullname);
	}

	@AfterClass
	public void done() {
		dr.quit();
	}
}

