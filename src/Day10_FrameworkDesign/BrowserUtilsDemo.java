package Day10_FrameworkDesign;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.BrowserUtils;
import utils.DataReader;
import utils.Driver;

public class BrowserUtilsDemo {

	public static void main(String[] args) throws InterruptedException {
		indeedTest();
	}
	
WebDriver driver;

	static IndeedPage indeedPage;
	static BrowserUtils utils = new BrowserUtils();

	public static void indeedTest() throws InterruptedException {
		indeedPage = new IndeedPage();
		
		// go to indeed
		Driver.getDriver().get(DataReader.getProperty("indeedURL"));
		Thread.sleep(500);
		
		// find the where field and clear the text
		utils.waitForElementVisible(indeedPage.whereField);
		utils.clearText(indeedPage.whereField);
		
	}
}
