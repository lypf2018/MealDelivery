package test;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class checkOutTest {
	WebDriver driver;
	@Before
	public void openLoginPage() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/MealDelivery/login.jsp");
		Assert.assertEquals("Login Page", driver.getTitle());
	}
	
	@Test
	// test accessing the check out
	public void accessCheckOut() throws InterruptedException{
		WebElement inputEmail = driver.findElement(By.id("email"));
		WebElement inputPasswd = driver.findElement(By.id("password"));
		WebElement submit = driver.findElement(By.name("submit"));
		inputEmail.sendKeys("1");
		inputPasswd.sendKeys("1");
		submit.click();
		Thread.sleep(3000);
		Assert.assertEquals("Menu", driver.getTitle());
		WebElement cart = driver.findElement(By.id("cart"));
		cart.click();
		Thread.sleep(3000);
		Assert.assertEquals("Cart", driver.getTitle());
		WebElement checkout = driver.findElement(By.id("checkout"));
		checkout.click();
		Thread.sleep(3000);
		Assert.assertEquals("check out", driver.getTitle());
	}

	@After
	public void closePage(){
	driver.quit();
	}
}
