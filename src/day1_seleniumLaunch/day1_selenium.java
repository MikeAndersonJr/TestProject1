package day1_seleniumLaunch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day1_selenium {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/michaelanderson/Documents/chromedriver_mac64/chromedriver/");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://amazon.com");
		
		System.out.println("Home Page Title: " +driver.getTitle());
		System.out.println("Home Page URL is: "+driver.getCurrentUrl());
		
	//	Thread.sleep(1000); // stops jvm for the given number of seconds... (1).
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Coffe Mug");
		// if a function returns something, we can store data in a variable or we can do a chain action.
		driver.findElement(By.id("nav-search-submit-text")).click();
		
		// Find by name
//		driver.findElement(By.name("q")).sendKeys("Software test engineer");
		
		// Find by linktext
		driver.findElement(By.linkText("customer service")).click();
		
		
		
		
		
		
		
		
		// Chain action
		String str = "Hello world";
		str.substring(3).trim().concat("I love java");

	}

}
