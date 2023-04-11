package Day3_advancedLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class xpathDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/michaelanderson/Documents/chromedriver_mac64/chromedriver/");
		xpathDemo x = new xpathDemo();
		x.etsyxpathPractice();
		
	}
	public void etsyxpathPractice() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		// Go to etsy.com
		driver.get("https://etsy.com");
		Thread.sleep(1000);

		// Click on Sign in.
		driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--small wt-btn--transparent wt-mr-xs-1 inline-overlay-trigger signin-header-action select-signin']")).click();
		Thread.sleep(1000);
		
		// Click on Register.
		driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--secondary wt-btn--small inline-overlay-trigger register-header-action select-register']")).click();
		Thread.sleep(1000);
		
		// Enter an email address, (jon.dow@gmail.com)
		driver.findElement(By.xpath("//input[@id='join_neu_email_field']")).sendKeys("jon.dow@gmail.com");
		
		// Enter first name.
		driver.findElement(By.xpath("//input[@id='join_neu_first_name_field']")).sendKeys("Automation");
		
		// Enter password.
		driver.findElement(By.xpath("//input[@id='join_neu_password_field']")).sendKeys("Automation");
		Thread.sleep(1000);
		
		// Click on Register.
		driver.findElement(By.xpath("//button[@name='submit_attempt']")).click();
		Thread.sleep(1000);
		
		// Verify you get the error message: "Sorry, the email you have entered is already in use."
		String expectedErrorMessage = "Sorry, the email you have entered is already in use.";
		String actualErrorMessage = driver.findElement(By.xpath("//div[@id='aria-join_neu_email_field-error']")).getText();
		
		if(actualErrorMessage.equals(actualErrorMessage)) {
			System.out.println("Verified");
		}else {
			System.out.println("Unverified");
		}
	}

	}




