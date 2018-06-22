package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;//importing testng

public class OrangeHRM {
	WebDriver dr;

	@BeforeMethod
	public void bMethod() {
		dr.get("http://opensource.demo.orangehrmlive.com/");
		System.out.println("before mehtod");
	}

	@AfterMethod
	public void aMethod() {
		System.out.println("after method");
	}

	@Test // annotaion. means if you r trying to do any kinda testing
	public void titleVerification() {
		String expectedTitle = "OrangeHRM";
		System.out.println("title is " + dr.getTitle());
		String s = "hi";
		s.equals("hello");
		Assert.assertEquals(dr.getTitle(), expectedTitle, "Orange title verification failed");// class for assertions.
																								// when expected and get
																								// title matches ,
		// assertions pass, if not it failed
		System.out.println("title verificaiton is done");
	}

	@BeforeClass // is attached to the method, runs before anything in the class
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "/Users/aa/Documents/seleniumDependancy/drivers/chromedriver");
		dr = new ChromeDriver();
		System.out.println("before class setup method");
	}

	@AfterClass
	public void closing() {
		System.out.println("finishing");
		dr.quit();
	}

	@Test
	public void loginTest() {
		System.out.println("login verification here");

		WebElement username = dr.findElement(By.id("txtUsername"));
		WebElement password = dr.findElement(By.id("txtPassword"));
		WebElement login = dr.findElement(By.id("btnLogin"));
		username.sendKeys("Admin");
		password.sendKeys("admin");
		login.click();

		String expectedUrl = "http://opensource.demo.orangehrmlive.com/index.php/dashboard";

		Assert.assertEquals(dr.getCurrentUrl(), expectedUrl, "Application login failed");
		// Assert.assertTrue(expectedUrl.equals(dr.getCurrentUrl()));//same as above
		// Assert.assertTrue(username.isDisplayed());

		// soft/hard assertion
		
		
	}
}
