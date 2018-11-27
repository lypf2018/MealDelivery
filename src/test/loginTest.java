package test;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginTest {
	WebDriver driver;
	@Before
	public void openLoginPage() throws InterruptedException{
	System.setProperty("webdriver.chrome.driver","chromedriver");
	driver = new ChromeDriver();
	driver.get("http://localhost:8080/mealdelivery/login.jsp");
	Assert.assertEquals("Login Page", driver.getTitle());
	}
	@Test
	public void testLoginS() throws InterruptedException{
	WebElement inputEmail = driver.findElement(By.id("email"));
	WebElement inputPasswd = driver.findElement(By.id("password"));
	WebElement submit = driver.findElement(By.name("submit"));
	inputEmail.sendKeys("1");
	inputPasswd.sendKeys("1");
	submit.click();
	Thread.sleep(5000);
	Assert.assertEquals("Menu", driver.getTitle());
	}
	@Test
	public void testLoginF_name() throws InterruptedException{
	WebElement inputEmail = driver.findElement(By.id("email"));
	WebElement inputPasswd = driver.findElement(By.id("password"));
	WebElement submit = driver.findElement(By.name("submit"));
	inputEmail.sendKeys("");
	inputPasswd.sendKeys("unknow");
	submit.click();
	Alert alert = driver.switchTo().alert();
	Thread.sleep(2000);
	Assert.assertEquals("Email must be filled out", alert.getText());
	alert.accept();
	}
	@Test
	public void testLoginF_pw() throws InterruptedException{
	WebElement inputEmail = driver.findElement(By.id("email"));
	WebElement inputPasswd = driver.findElement(By.id("password"));
	WebElement submit = driver.findElement(By.name("submit"));
	inputEmail.sendKeys("unknow");
	inputPasswd.sendKeys("");
	submit.click();
	Alert alert = driver.switchTo().alert();
	Thread.sleep(2000);
	Assert.assertEquals("Password must be filled out", alert.getText());
	alert.accept();
	}
	@Test
	public void testLoginF_nouser() throws InterruptedException{
		WebElement inputEmail = driver.findElement(By.id("email"));
		WebElement inputPasswd = driver.findElement(By.id("password"));
		WebElement submit = driver.findElement(By.name("submit"));
		inputEmail.sendKeys("unknow");
		inputPasswd.sendKeys("1");
		submit.click();
		Thread.sleep(2000);
		Assert.assertEquals("Register", driver.getTitle());
	}
	@Test
	public void testLoginF_unmatch() throws InterruptedException{
		WebElement inputEmail = driver.findElement(By.id("email"));
		WebElement inputPasswd = driver.findElement(By.id("password"));
		WebElement submit = driver.findElement(By.name("submit"));
		inputEmail.sendKeys("1");
		inputPasswd.sendKeys("unknow");
		submit.click();
		Thread.sleep(2000);
		Assert.assertEquals("Register", driver.getTitle());
	}
//	@Test
//	public void testSearchBox() throws InterruptedException{
//	WebElement searchBox = driver.findElement(By.id("searchInput"));;
	//searchBox.sendKeys("Software testing");
//	Thread.sleep(5000);
//	searchBox.submit();
//	Thread.sleep(5000);
//	Assert.assertEquals("Software testing - Wikipedia", driver.getTitle());
//	}
	@After
	public void closePage(){
	driver.quit();
	}

}
