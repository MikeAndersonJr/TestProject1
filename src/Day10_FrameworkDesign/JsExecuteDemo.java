package Day10_FrameworkDesign;

import org.openqa.selenium.JavascriptExecutor;

import utils.DataReader;
import utils.Driver;

public class JsExecuteDemo {

	public static void main(String[] args) throws InterruptedException {
	
		IndeedPage indeedPage = new IndeedPage();
		Driver.getDriver().get(DataReader.getProperty("indeedURL"));;
		indeedPage.whatField.sendKeys("software test engineer");
		indeedPage.searchBtn.click();
		Thread.sleep(500);
		
		JavascriptExecutor js =(JavascriptExecutor) Driver.getDriver();
				js.executeScript("arguments(0).scrollIntoView(true):", indeedPage.uploadResumeLink);
}
}
