package Day9_ActionsClass;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day8_HomeworkReview {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/michaelanderson/Documents/chromedriver_mac64/chromedriver/");
		ReusableObjects obj = new ReusableObjects();
		obj.guru99Homework();
		obj.iframeHomework();
	}
	WebDriver driver;
	
	public void guru99Homework() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		// go to http://demo.guru99.com/popup.php
		driver.get("http://demo.guru99.com/popup.php");
		
		// Get title and store it in a variable. 
		String mainPageTitle = driver.getTitle();
		String mainPageWindowId  = driver.getWindowHandle();
		
		// Click on Click Here button and switch over to next window, provide an email click Submit.
		driver.findElement(By.linkText("Click Here")).click();
		Thread.sleep(500);
		Set<String> windowIds = driver.getWindowHandles();
		for(String str : windowIds) {
			if(!str.equals(mainPageWindowId)) {
				driver.switchTo().window(str);
			}
		}
		driver.findElement(By.name("emailid")).sendKeys("Jon.dow@gmail.com");
		driver.findElement(By.name("btnLogin")).click();
		
		// Get text of the user ID and password and store them in variables, print them out. 
		String userId = driver.findElement(By.xpath("//td[text()='User ID :']//following-sibling::td")).getText();
			// Alternative xpath:
			// 1. //tr[4]//td[2]
			// 2. //td[@align='center'])[3]
			// 3. //td[contains(text(), 'mngr')]
		
		String password = driver.findElement(By.xpath("//td[text()='Password :']//following-sibling::td")).getText().trim();
		System.out.println("User Id: " + userId);
		System.out.println("Password: " + password);
		
		// Then verify the text “This access is valid only for 20 days.”  
		String message = driver.findElement(By.xpath("//h3[contains(text(), 'This access')]")).getText();
		if(message.equals("This access is valid only for 20 days.")) {
			System.out.println("Test Pass.");
		}else {
			System.out.println("Test fail");
		}
		
		// Close the window.  
		driver.close();
		
		// Go back to main window, and get title then verify it equals to your stored title.     
		driver.switchTo().window(mainPageWindowId);
		if(driver.getTitle().equals(mainPageTitle)) {
			System.out.println("We are back to the main page!");
		}else {
			System.out.println("We are lost.");
		}
		
		// Quite driver. 
		driver.quit();
		
	}
	
		public void iframeHomework() throws InterruptedException {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 5);
			
		// go to http://practice.primetech-apps.com/practice/frames
			driver.get("http://practice.primetech-apps.com/practice/frames");
			
		// Verify that there is a page header text as “Frames”.
			boolean isframetxt = driver.findElement(By.xpath("//h3[text()='Frames']")).isDisplayed();
			if(isframetxt) {
				System.out.println("Frame text is there.");
			}else {
				System.out.println("Frame text is NOT there.");
			}
			
		// Find the iFrame element and switch into it
			driver.switchTo().frame("iframe1");
			
		// Find firstname, lastname, address, city, state, and zipcode, and type relative information.
			driver.findElement(By.id("firstName")).sendKeys("John");
			driver.findElement(By.id("lastName")).sendKeys("Smith");
			driver.findElement(By.id("address")).sendKeys("1234 Main St.");
			driver.findElement(By.id("city")).sendKeys("Columbia");
			Select letsSelect = new Select(driver.findElement(By.id("state")));
			letsSelect.selectByVisibleText("Maryland");
			driver.findElement(By.id("zipCode")).sendKeys("21045");
			Thread.sleep(500);
		// Click on submit button.
			WebElement submitBTN = driver.findElement(By.xpath("//button[@type='submit']"));
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", submitBTN);
			
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(submitBTN)).click();
			
		// Verify you see “You have submitted below information:” message.
			boolean infoText = driver.findElement(By.xpath("//h3[text()='You have submited below information']")).isDisplayed();
			if(infoText) {
				System.out.println("Info text is there.");
			}else {
				System.out.println("Info text is not there.");
			}
		// Switch back to main frame
			driver.switchTo().parentFrame();
			
		// Verify that there is a page header text as “Frames”.
			boolean istxt = driver.findElement(By.xpath("//h3[text()='Frames']")).isDisplayed();
			if(istxt) {
				System.out.println("Page header text as Frames.");
			}else {
				System.out.println("Page header text NOT as Frames.");
			}
		}
	}


