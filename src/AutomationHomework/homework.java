package AutomationHomework;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class homework {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/michaelanderson/Documents/chromedriver_mac64/chromedriver/");
		homework h = new homework();
	//	h.testcase1();
		h.testcase2();


	}
	
	public void testcase1() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		// Go to etsy.com
		driver.get("https://etsy.com");
		Thread.sleep(1000);

		// Find Sign in button and click on it
		driver.findElement(By.className("select-signin")).click();
		Thread.sleep(1000);
		
		// Find email address field and type "automation"
		driver.findElement(By.id("join_neu_email_field")).sendKeys("automation");
		
		// Find the password field and type "automation"
		driver.findElement(By.id("join_neu_password_field")).sendKeys("automation");
		
		// Find the sign in button and click on it
		driver.findElement(By.name("submit_attempt")).click();
		driver.quit();

		
	}
	
	public void testcase2() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		String searchCriteria = "SDET";
		 // go to indeed.com
		driver.get("https://indeed.com");
		Thread.sleep(1000);

		 // get the current URL and store it in a variable called homeURL.
		String homeURL = driver.getCurrentUrl();

		 // get the website title and store it in a variable homeTitle.
		String homeTitle = driver.getTitle();
		
		 // find the input field for WHAT and type SDET
		driver.findElement(By.id("text-input-what")).sendKeys("SDET");
		
		 // find the Search button and click on it.
		driver.findElement(By.className("yosegi-InlineWhatWhere-primaryButton")).click();

		 // get the current URL and store it a variable searchURL.
		String searchURL = driver.getCurrentUrl();
		
		 // get the website title and store it in a variable searchTitle.
		String searchTitle = driver.getTitle();
		
		 // verify that searchURL does not equal to homeURL and contains the search criteria.
		if(!searchURL.equals(homeURL) && searchURL.contains(searchCriteria)) {
			System.out.println("search URL does not match and contain search criteria. Test Pass!");
		}else {
			System.out.println("Search URL matches or does not contain search criteria. Test Fail");
		}
		
		 // verify that searchTitle does not equal to homeTitle and has the search criteria.
		if(!searchTitle.equals(homeTitle) && searchTitle.contains(searchCriteria)) {	
			System.out.println("Search title does not match and contain search criteria.Test Pass!");
		}else {
			System.out.println("Search title matches or does not contain search criteria. Test Fail");
		}
			
		 // Get Text of the JobsInLocation field, store it in a variable, then verify if it's equals to your search criteria.
		String jobsInLocation = driver.findElement(By.id("text-input-where")).getText();
		System.out.println("Jobs In Location Text: "+jobsInLocation);
		
		if(jobsInLocation.contains(searchCriteria)) {
			System.out.println("Jobs in location text contains search criteria. Test Pass!");
			
		}else {
			System.out.println("Jobs in location text does not contain search criteria. Test Fail");
		}
		
		
		
		String searchCriteriasubtext = jobsInLocation.substring(0,searchCriteria.length());
		System.out.println("searchCriteriaSubText"+" "+searchCriteria.length());

	}
}
