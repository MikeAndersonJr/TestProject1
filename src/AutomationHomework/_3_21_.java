package AutomationHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class _3_21_ {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/michaelanderson/Documents/chromedriver_mac64/chromedriver/");
		_3_21_ p = new _3_21_();
		p.primetechPath();
		
	}
	public void primetechPath() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		// Go to http://practice.primetech-apps.com/practice/text-box
		driver.get("http://practice.primetech-apps.com/practice/text-box");
		
		// Find first name, last name, email, password, address fields, and type relevant information. 
		// (Create variables for those information and pass the variable to the sendkey() method).

		driver.findElement(By.cssSelector("input[id=firstName]")).sendKeys("Automation");
		driver.findElement(By.cssSelector("input[id=lastName]")).sendKeys("Automation");
		driver.findElement(By.cssSelector("input[id=email]")).sendKeys("jon.dow@gmail.com");
		driver.findElement(By.cssSelector("input[id=password]")).sendKeys("Automation");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Enable']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//textarea[@id='address']")).sendKeys("123 Automation RD");
		
		// Then click on submit button. (your inputs displays under user info section).
		driver.findElement(By.xpath("//button[contains(text(), 'Submit')]")).click();
		/*
		driver.findElement(By.xpath("//button[contains(text(), 'Enable')]")).click();
		Thread.sleep(500);
		driver.findElement(By.cssSelector("textarea[id=address]")).sendKeys("123 Automation Rd");
		Thread.sleep(500);
		
		// Then click on submit button. (your inputs displays under user info section).
		driver.findElement(By.cssSelector("button[type=submit]")).click();
		Thread.sleep(500);
		*/
		
		// Find your inputs and get text of each and store them into variables.
		String firstName = driver.findElement(By.cssSelector("div[class='firstName']")).getText();
		String lastName = driver.findElement(By.cssSelector("div[class='lastName']")).getText();
		String email = driver.findElement(By.cssSelector("div[class='email']")).getText();
		String password = driver.findElement(By.cssSelector("div[class='password']")).getText();
		String address = driver.findElement(By.cssSelector("div[class='address']")).getText();
		
		// Then compare your input with the displayed user information if they match.
		if(firstName.equals("Automation")) {
			System.out.println("Test Pass!");
		}else {
			System.out.println("Test Fail.");
		}
		
		if(lastName.equals("Automation")) {
			System.out.println("Test Pass!");
		}else {
			System.out.println("Test Fail.");
		}
		if(email.equals("jon.dow@gmail.com")) {
			System.out.println("Test Pass!");
		}else {
			System.out.println("Test Fail.");
		}
		if(password.equals("Automation")) {
			System.out.println("Test Pass!");
		}else {
			System.out.println("Test Fail.");
		}
		if(address.equals("123 Automation RD")) {
			System.out.println("Test Pass!");
		}else {
			System.out.println("Test Fail.");
		}
	}

}
