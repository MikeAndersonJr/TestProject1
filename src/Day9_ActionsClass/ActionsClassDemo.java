package Day9_ActionsClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsClassDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/michaelanderson/Documents/chromedriver_mac64/chromedriver/");
		
		actionsDemo();
	}
	
	public static void actionsDemo() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		Actions letsdo = new Actions(driver);
		
		// Go to Etsy.com
		driver.get("https://Etsy.com");
		
		// Hover Over on Jewelry & Accessories
		WebElement jewelryTab = driver.findElement(By.xpath("//span[contains(text(), 'Jewelry & Accessories')]"));
		letsdo.moveToElement(jewelryTab).build().perform();
		Thread.sleep(500);
		
		// Mouseover on Bags & Purses
		WebElement bagsPurses = driver.findElement(By.xpath("//span[contains(text(), 'Bags & Purses')]"));
		letsdo.moveToElement(bagsPurses).build().perform();
		Thread.sleep(500);
		
		// Mouseover to Shoulder Bags
		WebElement shoulderBags = driver.findElement(By.xpath("//a[contains(text(), 'Shoulder Bags')]"));
		letsdo.moveToElement(bagsPurses).build().perform();
		Thread.sleep(500);

		// Click on the shoulder bags
		shoulderBags.click();
		
		// Verify you are on the Shoulder bags page
		if(driver.findElement(By.xpath("//h1[text()= 'Shoulder Bags']")).isDisplayed()){
			System.out.println("We are on the Bag page.");
	}else {
		System.out.println("We are not on the Bag page");
	}

}
}
