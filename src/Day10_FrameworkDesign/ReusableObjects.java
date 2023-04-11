package Day10_FrameworkDesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.FacebookPage;
import day2_SeleniumFunctions.FacebookActivities;
import utils.DataReader;
import utils.Driver;

public class ReusableObjects {

		public static void main(String[] args) throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "/Users/michaelanderson/Documents/chromedriver_mac64/chromedriver/");
			ReusableObjects obj = new ReusableObjects();
			obj.testcase1();
			obj.testcase2();
			obj.getTextPractice();
			
		}
		
		FacebookPage fbPage;
		
		public void testcase1() {
			fbPage = new FacebookPage();
			
		     // go to facebook.com
			Driver.getDriver().get(DataReader.getProperty("testingUrl"));
			
		     // find the Email or phone number field and type Automation
			fbPage.FBemailField.sendKeys(DataReader.getProperty("facebookUsername"));
				
		     // find the Password field and type Automation
				fbPage.FBpassField.sendKeys(DataReader.getProperty("facebookPassword"));
				
		     // find the Login button and click on it.
				fbPage.FBloginBtn.click();
				Driver.quitDriver();
				
			}

		public void testcase2() throws InterruptedException {
			
			Driver.getDriver().get(DataReader.getProperty("appUrl"));
			Driver.getDriver().findElement(By.linkText("Create new account")).click();
			Thread.sleep(1000);
			Driver.getDriver().findElement(By.name("firstname")).sendKeys("automation");
			Driver.getDriver().findElement(By.name("lastname")).sendKeys("automation");
			Driver.getDriver().findElement(By.name("reg_email__")).sendKeys("automation");
			Driver.getDriver().findElement(By.name("reg_passwd__")).sendKeys("automation");
			Driver.getDriver().findElement(By.name("websubmit")).click();
			Driver.quitDriver();


		}
		
		public void getTextPractice() {
			
			Driver.getDriver().get(DataReader.getProperty("appUrl"));
			String loginText = Driver.getDriver().findElement(By.name("login")).getText();
			System.out.println("Log in button text is: "+loginText);
			if(loginText.equals("Log In")) {
				System.out.println("Test Pass");
			}else {
				System.out.println("Test Fails");
			}
			Driver.quitDriver();

	}

}
