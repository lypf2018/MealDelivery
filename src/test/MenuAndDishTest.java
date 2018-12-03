package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MenuAndDishTest {

	WebDriver driver;

	@Before
	public void openLoginPage() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8079/MealDelivery/login.jsp");
		Thread.sleep(2000);
		Assert.assertEquals("Login Page", driver.getTitle());
	}

	@Test
	public void testMenuDishPage() throws InterruptedException{
		WebElement inputEmail = driver.findElement(By.id("email"));
		WebElement inputPasswd = driver.findElement(By.id("password"));
		WebElement submit = driver.findElement(By.name("submit"));
		inputEmail.sendKeys("1");
		inputPasswd.sendKeys("1");
		submit.click();
		Thread.sleep(2000);
		Assert.assertEquals("Menu", driver.getTitle());
		WebElement link = driver.findElement(By.linkText("Dish1-1"));
		link.click();
		Thread.sleep(2000);
		Assert.assertEquals("Dish Detail", driver.getTitle());
	}

	@After
	public void closePage(){
	driver.quit();
	}
}
