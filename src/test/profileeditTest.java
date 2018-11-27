package test;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;



public class profileeditTest {
	WebDriver driver;
	@Before
	public void openLoginPage() throws InterruptedException{
	System.setProperty("webdriver.chrome.driver","chromedriver");
	driver = new ChromeDriver();
	driver.get("http://localhost:8080/mealdelivery/login.jsp");
	WebElement inputEmail = driver.findElement(By.id("email"));
	WebElement inputPasswd = driver.findElement(By.id("password"));
	WebElement submit = driver.findElement(By.name("submit"));
	inputEmail.sendKeys("1");
	inputPasswd.sendKeys("1");
	submit.click();
	if(driver.getTitle().equalsIgnoreCase("Menu")) {
		WebElement profile = driver.findElement(By.id("profile"));
		profile.click();
		Thread.sleep(2000);
		WebElement edit = driver.findElement(By.id("edit"));
		edit.click();
		Thread.sleep(2000);
	}
	}


	
	@Test
	public void testProfile_Lname() throws InterruptedException{
	WebElement inputLastname = driver.findElement(By.id("lastname"));
	WebElement inputFirstname = driver.findElement(By.id("firstname"));
	WebElement inputStreet = driver.findElement(By.id("street"));
	WebElement inputCity = driver.findElement(By.id("city"));
	WebElement inputState = driver.findElement(By.id("state"));
	WebElement inputZipcode = driver.findElement(By.id("zipcode"));
	WebElement inputPhone = driver.findElement(By.id("phone"));
	WebElement submit = driver.findElement(By.name("submit"));
	inputLastname.sendKeys("");
	inputFirstname.sendKeys("David");
	inputStreet.sendKeys("800 campbell road");
	inputCity.sendKeys("Dallas");
	inputState.sendKeys("TX");
	inputZipcode.sendKeys("75200");
	inputPhone.sendKeys("4436542215");
	submit.click();
	String message = driver.findElement(By.id("lastname")).getAttribute("validationMessage");
//	Alert alert = driver.switchTo().alert();
	Thread.sleep(2000);
	Assert.assertEquals("Please fill out this field.", message);
//	alert.accept();
	}
	@Test
	public void testProfile_Fname() throws InterruptedException{
	WebElement inputLastname = driver.findElement(By.id("lastname"));
	WebElement inputFirstname = driver.findElement(By.id("firstname"));
	WebElement inputStreet = driver.findElement(By.id("street"));
	WebElement inputCity = driver.findElement(By.id("city"));
	WebElement inputState = driver.findElement(By.id("state"));
	WebElement inputZipcode = driver.findElement(By.id("zipcode"));
	WebElement inputPhone = driver.findElement(By.id("phone"));
	WebElement submit = driver.findElement(By.name("submit"));
	inputLastname.sendKeys("Smith");
	inputFirstname.sendKeys("");
	inputStreet.sendKeys("800 campbell road");
	inputCity.sendKeys("Dallas");
	inputState.sendKeys("TX");
	inputZipcode.sendKeys("75200");
	inputPhone.sendKeys("4436542215");
	submit.click();
	String message = driver.findElement(By.id("firstname")).getAttribute("validationMessage");
//	Alert alert = driver.switchTo().alert();
	Thread.sleep(2000);
	Assert.assertEquals("Please fill out this field.", message);
//	alert.accept();
	}
	
	@Test
	public void testProfile_Street() throws InterruptedException{
	WebElement inputLastname = driver.findElement(By.id("lastname"));
	WebElement inputFirstname = driver.findElement(By.id("firstname"));
	WebElement inputStreet = driver.findElement(By.id("street"));
	WebElement inputCity = driver.findElement(By.id("city"));
	WebElement inputState = driver.findElement(By.id("state"));
	WebElement inputZipcode = driver.findElement(By.id("zipcode"));
	WebElement inputPhone = driver.findElement(By.id("phone"));
	WebElement submit = driver.findElement(By.name("submit"));
	inputLastname.sendKeys("Smith");
	inputFirstname.sendKeys("David");
	inputStreet.sendKeys("");
	inputCity.sendKeys("Dallas");
	inputState.sendKeys("TX");
	inputZipcode.sendKeys("75200");
	inputPhone.sendKeys("4436542215");
	submit.click();
	String message = driver.findElement(By.id("street")).getAttribute("validationMessage");
//	Alert alert = driver.switchTo().alert();
	Thread.sleep(2000);
	Assert.assertEquals("Please fill out this field.", message);
//	alert.accept();
	}
	
	@Test
	public void testProfile_City() throws InterruptedException{
	WebElement inputLastname = driver.findElement(By.id("lastname"));
	WebElement inputFirstname = driver.findElement(By.id("firstname"));
	WebElement inputStreet = driver.findElement(By.id("street"));
	WebElement inputCity = driver.findElement(By.id("city"));
	WebElement inputState = driver.findElement(By.id("state"));
	WebElement inputZipcode = driver.findElement(By.id("zipcode"));
	WebElement inputPhone = driver.findElement(By.id("phone"));
	WebElement submit = driver.findElement(By.name("submit"));
	inputLastname.sendKeys("Smith");
	inputFirstname.sendKeys("David");
	inputStreet.sendKeys("800 campbell road");
	inputCity.sendKeys("");
	inputState.sendKeys("TX");
	inputZipcode.sendKeys("75200");
	inputPhone.sendKeys("4436542215");
	submit.click();
	String message = driver.findElement(By.id("city")).getAttribute("validationMessage");
//	Alert alert = driver.switchTo().alert();
	Thread.sleep(2000);
	Assert.assertEquals("Please fill out this field.", message);
//	alert.accept();
	}
	
	@Test
	public void testProfile_State() throws InterruptedException{
	WebElement inputLastname = driver.findElement(By.id("lastname"));
	WebElement inputFirstname = driver.findElement(By.id("firstname"));
	WebElement inputStreet = driver.findElement(By.id("street"));
	WebElement inputCity = driver.findElement(By.id("city"));
	WebElement inputState = driver.findElement(By.id("state"));
	WebElement inputZipcode = driver.findElement(By.id("zipcode"));
	WebElement inputPhone = driver.findElement(By.id("phone"));
	WebElement submit = driver.findElement(By.name("submit"));
	inputLastname.sendKeys("Smith");
	inputFirstname.sendKeys("David");
	inputStreet.sendKeys("800 campbell road");
	inputCity.sendKeys("Dallas");
	inputState.sendKeys("");
	inputZipcode.sendKeys("75200");
	inputPhone.sendKeys("4436542215");
	submit.click();
	String message = driver.findElement(By.id("state")).getAttribute("validationMessage");
//	Alert alert = driver.switchTo().alert();
	Thread.sleep(2000);
	Assert.assertEquals("Please fill out this field.", message);
//	alert.accept();
	}
	
	@Test
	public void testProfile_Zipcode() throws InterruptedException{
	WebElement inputLastname = driver.findElement(By.id("lastname"));
	WebElement inputFirstname = driver.findElement(By.id("firstname"));
	WebElement inputStreet = driver.findElement(By.id("street"));
	WebElement inputCity = driver.findElement(By.id("city"));
	WebElement inputState = driver.findElement(By.id("state"));
	WebElement inputZipcode = driver.findElement(By.id("zipcode"));
	WebElement inputPhone = driver.findElement(By.id("phone"));
	WebElement submit = driver.findElement(By.name("submit"));
	inputLastname.sendKeys("Smith");
	inputFirstname.sendKeys("David");
	inputStreet.sendKeys("800 campbell road");
	inputCity.sendKeys("Dallas");
	inputState.sendKeys("TX");
	inputZipcode.sendKeys("");
	inputPhone.sendKeys("4436542215");
	submit.click();
	String message = driver.findElement(By.id("zipcode")).getAttribute("validationMessage");
//	Alert alert = driver.switchTo().alert();
	Thread.sleep(2000);
	Assert.assertEquals("Please fill out this field.", message);
//	alert.accept();
	}
	
	@Test
	public void testProfile_Phone() throws InterruptedException{
	WebElement inputLastname = driver.findElement(By.id("lastname"));
	WebElement inputFirstname = driver.findElement(By.id("firstname"));
	WebElement inputStreet = driver.findElement(By.id("street"));
	WebElement inputCity = driver.findElement(By.id("city"));
	WebElement inputState = driver.findElement(By.id("state"));
	WebElement inputZipcode = driver.findElement(By.id("zipcode"));
	WebElement inputPhone = driver.findElement(By.id("phone"));
	WebElement submit = driver.findElement(By.name("submit"));
	inputLastname.sendKeys("Smith");
	inputFirstname.sendKeys("David");
	inputStreet.sendKeys("800 campbell road");
	inputCity.sendKeys("Dallas");
	inputState.sendKeys("TX");
	inputZipcode.sendKeys("75200");
	inputPhone.sendKeys("");
	submit.click();
	String message = driver.findElement(By.id("phone")).getAttribute("validationMessage");
//	Alert alert = driver.switchTo().alert();
	Thread.sleep(2000);
	Assert.assertEquals("Please fill out this field.", message);
//	alert.accept();
	}
	
	@Test
	public void testProfile_Ziptype() throws InterruptedException{
	WebElement inputLastname = driver.findElement(By.id("lastname"));
	WebElement inputFirstname = driver.findElement(By.id("firstname"));
	WebElement inputStreet = driver.findElement(By.id("street"));
	WebElement inputCity = driver.findElement(By.id("city"));
	WebElement inputState = driver.findElement(By.id("state"));
	WebElement inputZipcode = driver.findElement(By.id("zipcode"));
	WebElement inputPhone = driver.findElement(By.id("phone"));
	WebElement submit = driver.findElement(By.name("submit"));
	inputLastname.sendKeys("Smith");
	inputFirstname.sendKeys("David");
	inputStreet.sendKeys("800 campbell road");
	inputCity.sendKeys("Dallas");
	inputState.sendKeys("TX");
	inputZipcode.sendKeys("eeee");
	inputPhone.sendKeys("4436542215");
	submit.click();
	String message = driver.findElement(By.id("zipcode")).getAttribute("validationMessage");
//	Alert alert = driver.switchTo().alert();
	Thread.sleep(2000);
	Assert.assertEquals("Please enter a number.", message);
//	alert.accept();
	}
	
	@Test
	public void testProfile_Success() throws InterruptedException{
		WebElement inputLastname = driver.findElement(By.id("lastname"));
		WebElement inputFirstname = driver.findElement(By.id("firstname"));
		WebElement inputStreet = driver.findElement(By.id("street"));
		WebElement inputCity = driver.findElement(By.id("city"));
		WebElement inputState = driver.findElement(By.id("state"));
		WebElement inputZipcode = driver.findElement(By.id("zipcode"));
		WebElement inputPhone = driver.findElement(By.id("phone"));
		WebElement submit = driver.findElement(By.name("submit"));
		inputLastname.sendKeys("Smith");
		inputFirstname.sendKeys("David");
		inputStreet.sendKeys("800 campbell road");
		inputCity.sendKeys("Dallas");
		inputState.sendKeys("TX");
		inputZipcode.sendKeys("75200");
		inputPhone.sendKeys("4436542215");
		submit.click();
		Thread.sleep(2000);
		if(driver.getTitle().equalsIgnoreCase("Customer Profile")) {
			WebElement lastname = driver.findElement(By.id("lastname"));
			WebElement firstname = driver.findElement(By.id("firstname"));
			WebElement street = driver.findElement(By.id("street"));
			WebElement city = driver.findElement(By.id("city"));
			WebElement state = driver.findElement(By.id("state"));
			WebElement zipcode = driver.findElement(By.id("zip"));
			WebElement phone = driver.findElement(By.id("phone"));
			
			Assert.assertEquals("Smith", lastname.getAttribute("innerText"));
			Assert.assertEquals("David", firstname.getAttribute("innerText"));
			Assert.assertEquals("800 campbell road", street.getAttribute("innerText"));
			Assert.assertEquals("Dallas", city.getAttribute("innerText"));
			Assert.assertEquals("TX", state.getAttribute("innerText"));
			Assert.assertEquals("75200", zipcode.getAttribute("innerText"));
			Assert.assertEquals("4436542215", phone.getAttribute("innerText"));
			
		}

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
