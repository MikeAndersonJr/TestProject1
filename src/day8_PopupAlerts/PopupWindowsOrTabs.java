package day8_PopupAlerts;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopupWindowsOrTabs {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/michaelanderson/Documents/chromedriver_mac64/chromedriver/");
		newTabDemo();
		windowHandlesExample();
	}

	public static void newTabDemo() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		// go to http://practice.primetech-apps.com/practice/browser-windows
		driver.get("http://practice.primetech-apps.com/practice/browser-windows");
		String mainWindowId = driver.getWindowHandle();
		System.out.println(mainWindowId);
		
		// Click on ‘New Tab’ button.
		driver.findElement(By.id("newTab")).click();
		
		// Then get the window handles and print what are they
		Set<String> windowIds = driver.getWindowHandles();
		for(String windowId : windowIds) {
			System.out.println("Window Id is: " + windowId);
		}
		
		// iterator example: "iterator" | "item1" | "item2" |
		Iterator<String> ids = windowIds.iterator();
		String firstWindowId = ids.next();
		String secondWindowId = ids.next();
		System.out.println("First window id: " + firstWindowId);
		System.out.println("Second window id: " + secondWindowId);

		driver.switchTo().window(secondWindowId);
		Thread.sleep(500);
		String newTabTextOnSecondWindow = driver.findElement(By.xpath("//h1[text()='New Tab']")).getText();
		System.out.println(newTabTextOnSecondWindow);
		driver.close(); // closes current window
		driver.switchTo().window(firstWindowId);
		Thread.sleep(500);
		String mainWindowText = driver.findElement(By.xpath("//h3[text()='Browser Windows']")).getText();
		System.out.println("Main Window Browser Text is: " + mainWindowText);
		if(driver.getWindowHandle().equals(mainWindowId)) {
			System.out.println("Test Pass!");
		}else {
			System.out.println("Test Fail");
		}
		driver.quit();
	}
		
//-----------------------------------------------------------------------------
	public static void windowHandlesExample() {
		WebDriver drivers = new ChromeDriver();
		
		// go to http://practice.primetech-apps.com/practice/browser-windows1.
		drivers.get("http://practice.primetech-apps.com/practice/browser-windows");

		// Get the main window ID and store it in a String called mainWindowId, 
		String mainWindowId = drivers.getWindowHandle();

		// 2. Click on the ‘New Tab’ button
		drivers.findElement(By.id("newTab")).click();

		// 3. Get window IDs and store it into a Set
		Set<String> windowIds = drivers.getWindowHandles();

		// 4. Get the first window ID from the Set 
		Iterator<String> iterate = windowIds.iterator();
		String firstWindowId = iterate.next();
		
		// Verify it matches with the main window id in step 1.
		if (firstWindowId.equals(mainWindowId)) {
			System.out.println("First window id match the main window id.");
		}else {
			System.out.println("First window id does not match the main window id.");
		}
		
		//Then get the second window id and store it in variable called secondWindowId.
		String secondWindowId = iterate.next();
		
		// 5. Switch to the second window 
		drivers.switchTo().window(secondWindowId);

		// 6. Verify that there is a button called ‘New Tab’
		if (drivers.findElement(By.id("newTab")).isDisplayed()) {
			System.out.println("New tab button is available on the second window");
		}else {
			System.out.println("New tab button is not available on the second window");
		}
		
		// 7. Close the window,  
		drivers.close();
		
		// Switch back to the main window, 
		drivers.switchTo().window(mainWindowId);

		// Verify you are on the main window. 
		if (drivers.getWindowHandle().equals(mainWindowId)) {
			System.out.println("We are back to the main window.");
		}else {
			System.out.println("We are lost.");
		}
	
}
}
