package test;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class adminDeleteDishTest {
	WebDriver driver;
	@Before
	public void openAddPage() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/MealDelivery/administratorlogin.jsp");
		WebElement inputUsername = driver.findElement(By.id("username"));
		WebElement inputPasswd = driver.findElement(By.id("password"));
		WebElement submit = driver.findElement(By.name("submit"));
		inputUsername.sendKeys("1");
		inputPasswd.sendKeys("1");
		submit.click();
		WebElement backToDish = driver.findElement(By.id("backtodish"));
		backToDish.click();
		Thread.sleep(2000);
		Assert.assertEquals("Administrator Dish Manage Page", driver.getTitle());
	}
	@Test
	public void testDeleteS() throws InterruptedException{
		WebElement deleteId = driver.findElement(By.id("17")); // delete an exist dish, item 63 right now exist in my database
		deleteId.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(5000);
		String returnMsg = driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals("Successfully delete a dish!", returnMsg);
	}
	@After
	public void closePage(){
		driver.quit();
	}
}