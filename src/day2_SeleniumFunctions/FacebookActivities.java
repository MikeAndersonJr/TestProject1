package day2_SeleniumFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookActivities {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/michaelanderson/Documents/chromedriver_mac64/chromedriver/");
		FacebookActivities fb = new FacebookActivities();
	//	fb.testcase1();
	//	fb.testcase2();
		fb.getTextPractice();
		
	}
	
	public void testcase1() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://facebook.com");
		driver.findElement(By.id("email")).sendKeys("automation");
		driver.findElement(By.id("pass")).sendKeys("automation");
		driver.findElement(By.name("login")).click();
		driver.close();
		
		
	}
	
	public void testcase2() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://facebook.com");
		driver.findElement(By.linkText("Create new account")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("firstname")).sendKeys("automation");
		driver.findElement(By.name("lastname")).sendKeys("automation");
		driver.findElement(By.name("reg_email__")).sendKeys("automation");
		driver.findElement(By.name("reg_passwd__")).sendKeys("automation");
		driver.findElement(By.name("websubmit")).click();
		driver.close();


	}
	
	public void getTextPractice() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://facebook.com");
		String loginText = driver.findElement(By.name("login")).getText();
		System.out.println("Log in button text is: "+loginText);
		if(loginText.equals("Log In")) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test Fails");
		}
		
	}

}
