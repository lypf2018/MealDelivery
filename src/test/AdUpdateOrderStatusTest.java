package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdUpdateOrderStatusTest {
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
		WebElement status = driver.findElement(By.name("status1"));
		WebElement button = driver.findElement(By.name("submit"));
		status.sendKeys("undergoing");
		button.click();
		Thread.sleep(9000);
		String returnMsg = driver.findElement(By.name("selected")).getText();
		System.out.println(returnMsg);
		Assert.assertEquals("undergoing", returnMsg);
	}

	
	@After
	public void closePage(){
	driver.quit();
	}

}
