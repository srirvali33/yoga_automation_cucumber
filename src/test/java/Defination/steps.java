package Defination;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class steps {				

	private static ChromeDriver driver;
	WebElement element;
	@Given("open the browser and application")
	public void open_the_firefox_and_launch_the_application() {
	   
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Starting test " + new Object() {
		}.getClass().getEnclosingMethod().getName());
		driver.get("https://srirvali33.github.io/Yogawebsite/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50000, TimeUnit.SECONDS);
		
	}	

	@When("check the links")
	public void enter_the_username_and_password() {
		try {
			
			driver.findElementByLinkText("ABOUT US").click();
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			driver.findElementByLinkText("TRAINERS").click();
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			driver.findElementByLinkText("LOCATION").click();
			driver.manage().timeouts().implicitlyWait(50000, TimeUnit.SECONDS);
			driver.findElement(By.id("name")).sendKeys("testuser_3");
			driver.findElement(By.id("email")).sendKeys("Test@123");
			driver.findElement(By.id("exampleFormControlTextarea1")).sendKeys("Can i get appointment?");
			driver.findElementById("questionsubmit").click();
			WebElement msg=driver.findElement(By.id("message"));
			String receivedmsg=msg.getText();
			String expectedmsg="Your message was recorded!";
			Assert.assertEquals(receivedmsg,expectedmsg);
			
		} catch (Exception e) {
		}
		
		System.out.println("Ending test " + new Object() {
		}.getClass().getEnclosingMethod().getName());
	}

	@Then("Close the browser")
	public void reset_the_credential() {
		driver.quit();
	}	

}