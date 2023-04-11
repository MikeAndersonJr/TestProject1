package AutomationHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _3_16_homework {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/michaelanderson/Documents/chromedriver_mac64/chromedriver/");
		_3_16_homework h = new _3_16_homework();
		h.testcase1();
		h.testcase2();
		h.testcase3();


	}

	public void testcase1() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
	    // go to facebook.com
		driver.get("https://facebook.com");
		
	    // find the Email or phone number field and type Automation
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Automation");
		
	    // find the Password field and type Automation
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Automation");
		
	    // find the Login button and click on it.
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(1000);
		driver.quit();
	}
	
	public void testcase2() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();

		// go to facebook.com
		driver.get("https://facebook.com");
		Thread.sleep(1000);

	    // find the Create New Account button and click on it
		driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
		Thread.sleep(1000);
		
	    // find the FirstName,  LastName, Email and Password fields and type Automation
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Automation");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Automation");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("Automation");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("Automation");
		
	    // find the Sign Up button and click on it.
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();
		Thread.sleep(1000);
		driver.quit();
		
	}
	public void testcase3() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		String searchCriteria = "SDET";
		System.out.println("Search Criteria: "+searchCriteria);

		// go to indeed.com
		driver.get("https://indeed.com");
		Thread.sleep(1000);
		
		// get the current URL and store it in a variable called homeURL.
		String homeURL = driver.getCurrentUrl();
		System.out.println("Home URL: " +homeURL);
		
		// get the website title and store it in a variable homeTitle.
		String homeTitle = driver.getTitle();
		System.out.println("Home Title: "+homeTitle);
		
		// find the input field for WHAT and type SDET
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(searchCriteria);
		Thread.sleep(1000);

		// find the input field for where, clear the field first and type washington DC
//		driver.findElement(By.xpath("//input[@value='Elkridge, MD']")).clear();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//input[@name='l']")).sendKeys("Washington, DC");

		// find the Search button and click on it.
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		// get the current URL and store it as a variable searchURL.
		String searchURL = driver.getCurrentUrl();
		System.out.println("Search URL: " + searchURL);
		
		// get the website title and store it in a variable searchTitle.
		String searchTitle = driver.getTitle().toUpperCase();
		System.out.println("Search Title: " +searchTitle);
		
		// verify that searchURL does not equal to homeURL and contains the search criteria.
		if(!searchURL.equals(homeURL) && searchURL.contains(searchCriteria)) {
			System.out.println("Verification: Test Pass!");
		}else {
			System.out.println("Verification: Test Fail.");
		}
		
		// verify that searchTitle does not equal to homeTitle and has the search criteria.
		if(!searchTitle.equals(homeTitle) && searchTitle.contains(searchCriteria)) {
			System.out.println("Verification: Test Pass!");
		}else {
			System.out.println("Verification: Test Fail.");
		}
		
		// Get Text of the JobsInLocation field, store it in a variable,
		String jobsInLocation = driver.findElement(By.xpath("//h1[@class='jobsearch-SerpTitle i-unmask']")).getText();
		
		// then verify if it's equal to your search criteria.
		if(jobsInLocation.contains(searchCriteria)) {
			System.out.println("Verification: Equals");
		}else {
			System.out.println("Verification: Not Equal");
		}
		driver.quit();
	}
}
