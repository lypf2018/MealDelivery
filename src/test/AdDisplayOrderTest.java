package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdDisplayOrderTest {

	WebDriver driver;
	
	@Before
	public void openAddDishPage() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/MealDelivery/admin/showOrder");
		Assert.assertEquals("ad show order", driver.getTitle());
	}
	
	@Test
	public void testUpdateStatusSuccessful() throws InterruptedException {
		WebElement link = driver.findElement(By.name("click1"));
		link.click();
		Thread.sleep(5000);
		String returnMsg = driver.findElement(By.tagName("h3")).getText();
		Assert.assertEquals("Order Number: 1", returnMsg);
	}
	

	@After
	public void closePage(){
		driver.quit();
	}
}
