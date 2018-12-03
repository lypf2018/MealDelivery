package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogoutTest {

	WebDriver driver;

	@Before
	public void openLoginPage() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/MealDelivery/login.jsp");
		WebElement inputEmail = driver.findElement(By.id("email"));
		WebElement inputPasswd = driver.findElement(By.id("password"));
		WebElement submit = driver.findElement(By.name("submit"));
		inputEmail.sendKeys("1");
		inputPasswd.sendKeys("1");
		submit.click();
		Thread.sleep(2000);
		Assert.assertEquals("Menu", driver.getTitle());
	}

	@Test
	public void testLogout() throws InterruptedException{
		WebElement logout = driver.findElement(By.id("logout"));
		logout.click();
		Thread.sleep(2000);
		Assert.assertEquals("Login Page", driver.getTitle());
	}

	@After
	public void closePage(){
	driver.quit();
	}

}
