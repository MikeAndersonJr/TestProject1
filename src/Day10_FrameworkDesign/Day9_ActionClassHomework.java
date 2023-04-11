package Day10_FrameworkDesign;

import java.awt.Desktop.Action;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day9_ActionClassHomework {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/michaelanderson/Documents/chromedriver_mac64/chromedriver/");
		dragdrop();
	}
	public static void dragdrop() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		Actions letsdo = new Actions(driver);
		
		// Go to "http://practice.primetech-apps.com/practice/drag-and-drop"
		driver.get("http://practice.primetech-apps.com/practice/drag-and-drop");
		
		// Verify Drag And Drop text displays
		if(driver.findElement(By.xpath("//h3[text()='Drag And Drop']")).isDisplayed()){
			System.out.println("text is there");
		}else {
			System.out.println("Text us not there");
		}
		
		// drag the Text element to target window
		WebElement sourceText = driver.findElement(By.id("text"));
		WebElement targetZone = driver.findElement(By.id("dropzone"));
		
		letsdo.dragAndDrop(sourceText, targetZone).build().perform();
		Thread.sleep(500);
		
		// drag the Textarea element to target window
		WebElement sourceTextArea = driver.findElement(By.id("textarea"));
		letsdo.dragAndDrop(sourceTextArea, targetZone).build().perform();
		Thread.sleep(500);
		
		// drag the Number element to target window
		WebElement sourceNumber = driver.findElement(By.id("Number"));
		letsdo.dragAndDrop(sourceNumber, targetZone);
		Thread.sleep(500);
		
		// delete all those dragged items from target window
		List<WebElement> removeButton = driver.findElements(By.cssSelector(".remove"));
		for(WebElement webElement : removeButton) {
			webElement.click();
			Thread.sleep(500);
		}
		
			
	}

}
