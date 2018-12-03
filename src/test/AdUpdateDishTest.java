package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdUpdateDishTest {

	WebDriver driver;
	
	@Before
	public void openAddDishPage() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/MealDelivery/admin/AdEditDishController?id=9");
		Assert.assertEquals("Edit Dish Page", driver.getTitle());
	}
	
	//TC1 update successfully
	@Test
	public void testAddSuccessful() throws InterruptedException {
		WebElement name = driver.findElement(By.id("dish_name"));
		WebElement description = driver.findElement(By.id("dish_des"));
		WebElement price = driver.findElement(By.id("dish_price"));
		WebElement button = driver.findElement(By.tagName("button"));
		name.sendKeys("Salmon sashimi test");
		description.sendKeys("This is salmon sashimi test");
		price.sendKeys("25");
		button.click();
		Thread.sleep(5000);
		String returnMsg = driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals("Successfully edit a dish!", returnMsg);
//		Assert.assertEquals("Edit Dish Confirm Page", driver.getTitle());
	}
	
	//TC2 Empty dish name
	@Test
	public void testEmptyDishName() throws InterruptedException {
		WebElement name = driver.findElement(By.id("dish_name"));
		WebElement description = driver.findElement(By.id("dish_des"));
		WebElement price = driver.findElement(By.id("dish_price"));
		WebElement button = driver.findElement(By.tagName("button"));
		name.sendKeys("");
		description.sendKeys("This is salmon sashimi");
		price.sendKeys("30");
		button.click();
		Thread.sleep(5000);
		String returnMsg = driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals("Failed to edit a dish!", returnMsg);
	}
	
	//TC3 Too long description
	@Test
	public void testLongDescription() throws InterruptedException {
		WebElement name = driver.findElement(By.id("dish_name"));
		WebElement description = driver.findElement(By.id("dish_des"));
		WebElement price = driver.findElement(By.id("dish_price"));
		WebElement button = driver.findElement(By.tagName("button"));
		name.sendKeys("Salmon sashimi test");
		description.sendKeys("This is salmon sashimiThis is salmon sashimiThis is salmon sashimiThis is salmon sashimiThis is salmon sashimiThis is salmon sashimiThis is salmon sashimiThis is salmon sashimiThis is salmon sashimiThis is salmon sashimiThis is salmon sashimiThis is salmon sashimiThis is salmon sashimiThis is salmon sashimiThis is salmon sashimiThis is salmon sashimiThis is salmon sashimiThis is salmon sashimiThis is salmon sashimiThis is salmon sashimiThis is salmon sashimiThis is salmon sashimiThis is salmon sashimiThis is salmon sashimi");
		price.sendKeys("30");
		button.click();
		Thread.sleep(5000);
		String returnMsg = driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals("Failed to edit a dish!", returnMsg);
	}
	
	//TC4 Price is not number
	@Test
	public void testPriceNotNumber() throws InterruptedException {
		WebElement name = driver.findElement(By.id("dish_name"));
		WebElement description = driver.findElement(By.id("dish_des"));
		WebElement price = driver.findElement(By.id("dish_price"));
		WebElement button = driver.findElement(By.tagName("button"));
		name.sendKeys("Salmon sashimi test");
		description.sendKeys("This is salmon sashimi");
		price.sendKeys("test");
		button.click();
		Thread.sleep(5000);
		String returnMsg = driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals("Failed to edit a dish!", returnMsg);
	}
	
	//TC5 Price is negative number
	@Test
	public void testPriceNegativeNumber() throws InterruptedException {
		WebElement name = driver.findElement(By.id("dish_name"));
		WebElement description = driver.findElement(By.id("dish_des"));
		WebElement price = driver.findElement(By.id("dish_price"));
		WebElement button = driver.findElement(By.tagName("button"));
		name.sendKeys("Salmon sashimi test");
		description.sendKeys("This is salmon sashimi");
		price.sendKeys("-100");
		button.click();
		Thread.sleep(5000);
		String returnMsg = driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals("Failed to edit a dish!", returnMsg);
	}
	
	@After
	public void closePage(){
	driver.quit();
	}
}
