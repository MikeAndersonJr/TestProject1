package AutomationHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Day10_FrameworkDesign.ReusableObjects;
import Pages.FacebookPage;
import utils.DataReader;
import utils.Driver;

public class _4_5_homework {
		
		public static void main(String[] args) throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "/Users/michaelanderson/Documents/chromedriver_mac64/chromedriver/");
			ReusableObjects obj = new ReusableObjects();
			obj.testcase1();
			obj.testcase2();
			
			
		}
		
	//	WebDriver a;
		
	public void testCase1() {
		WebDriver a = new ChromeDriver();
		 // go to amazon.com 
		a.get("https://amazon.com");
	     // get all the options in the departments select dropdown
		 // verify there are total 58 departments. And print them out.
		
	}
	
	public void testCase2() {
	    	 // go to amazon.com
		     // verify that you are on the amazon home page. (verify with title). 
		     // verify dropdown value is by default "All Departments"
		     // select department Home & Kitchen, and search coffee mug.
		     // verify you are on coffee mug search results page (use title).
		     // verify you are in Home & Kitchen department.
	    	
	    }
	    
	

	}


