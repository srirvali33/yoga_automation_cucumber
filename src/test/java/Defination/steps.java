package Defination;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class steps {				

	private static ChromeDriver driver;
	private static  FirefoxDriver driver2;
	WebElement element;
	@Given("open the chrome browser and application")
	public void open_the_chrome_and_launch_the_application() {
	   
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Starting test " + new Object() {
		}.getClass().getEnclosingMethod().getName());
		driver.get("https://srirvali33.github.io/Yogawebsite/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50000, TimeUnit.SECONDS);
		
	}	
	
	@Given("open the firefox browser and application")
	public void open_the_firefox_and_launch_the_application() {
	   
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        driver2 = new FirefoxDriver(capabilities);
		System.out.println("Starting test " + new Object() {
		}.getClass().getEnclosingMethod().getName());
		driver2.get("https://srirvali33.github.io/Yogawebsite/");
		driver2.manage().window().maximize();
		driver2.manage().timeouts().pageLoadTimeout(50000, TimeUnit.SECONDS);
		
	}	

	@When("I check the links")
	public void check_the_links() {
		try {
			
			driver.findElementByLinkText("ABOUT US").click();
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			driver.findElementByLinkText("TRAINERS").click();
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			
			
		} catch (Exception e) {
		}
		
		System.out.println("Ending test " + new Object() {
		}.getClass().getEnclosingMethod().getName());
	}
	
	@When("I check the links in firefox browser")
	public void check_the_links_in_firefox_browser() {
		try {
			
			driver2.findElementByLinkText("ABOUT US").click();
			driver2.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			driver2.findElementByLinkText("TRAINERS").click();
			driver2.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			
			
		} catch (Exception e) {
		}
		
		System.out.println("Ending test " + new Object() {
		}.getClass().getEnclosingMethod().getName());
	}

	@Then("Close the chrome browser")
	public void close_the_chrome() {
		driver.quit();
	}
	
	@Then("Close the firefox browser")
	public void close_the_firefox() {
		driver2.quit();
	}
	
	@Then("Check the message received")
	public void Check_the_message_received() {
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
	}

}
