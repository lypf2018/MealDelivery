package test;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class adminAddDishTest {
	WebDriver driver;
	@Before
	public void openAddPage() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","chromedriver");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/MealDelivery/DishMngController?type=menu");
		Assert.assertEquals("Add Dish Page", driver.getTitle());
	}
	@Test
	public void testAddS() throws InterruptedException{
		WebElement dishName = driver.findElement(By.id("dish_name"));
		WebElement dishDescription = driver.findElement(By.id("dish_des"));
		WebElement dishPrice = driver.findElement(By.id("dish_price"));
		WebElement dishCategory = driver.findElement(By.id("dish_category"));
		WebElement submit = driver.findElement(By.name("submit"));
		dishName.sendKeys("1");
		dishDescription.sendKeys("1");
		dishPrice.sendKeys("1");
		dishCategory.sendKeys("1");
		submit.click();
		Thread.sleep(5000);
		String returnMsg = driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals("Successfully add a new dish!", returnMsg);
	}
	@Test
	public void testAddF() throws InterruptedException{
		WebElement dishName = driver.findElement(By.id("dish_name"));
		WebElement dishDescription = driver.findElement(By.id("dish_des"));
		WebElement dishPrice = driver.findElement(By.id("dish_price"));
		WebElement dishCategory = driver.findElement(By.id("dish_category"));
		WebElement submit = driver.findElement(By.name("submit"));
		dishName.sendKeys("");
		dishDescription.sendKeys("");
		dishPrice.sendKeys("");
		dishCategory.sendKeys("");
		submit.click();
		Thread.sleep(2000);
		String returnMsg = driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals("Failed to add a new dish!", returnMsg);
	}
	@After
	public void closePage(){
		driver.quit();
	}
}
