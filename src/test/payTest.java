package test;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class payTest {
	WebDriver driver;
	@Before
	public void openLoginPage() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/MealDelivery/login.jsp");
		Assert.assertEquals("Login Page", driver.getTitle());
	}
	
	@Test
	// test pay
	public void payCheck() throws InterruptedException{
		WebElement inputEmail = driver.findElement(By.id("email"));
		WebElement inputPasswd = driver.findElement(By.id("password"));
		WebElement submit = driver.findElement(By.name("submit"));
		inputEmail.sendKeys("fengyz318@gmail.com");
		inputPasswd.sendKeys("fyzfyz");
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
		WebElement pay = driver.findElement(By.id("pay"));
		pay.click();
		Thread.sleep(3000);
		Assert.assertEquals("Cart", driver.getTitle());
	}
	@Test
	// if the cart is empty
	public void emptyCartCheck() throws InterruptedException{
		WebElement inputEmail = driver.findElement(By.id("email"));
		WebElement inputPasswd = driver.findElement(By.id("password"));
		WebElement submit = driver.findElement(By.name("submit"));
		inputEmail.sendKeys("fengyz318@gmail.com");
		inputPasswd.sendKeys("fyzfyz");
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
		WebElement pay = driver.findElement(By.id("pay"));
		pay.click();
		Thread.sleep(3000);
		Assert.assertEquals("Cart Empty", driver.getTitle());
	}

	@After
	public void closePage(){
	driver.quit();
	}
}
