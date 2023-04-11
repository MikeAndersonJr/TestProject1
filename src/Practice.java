import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Practice {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/michaelanderson/Documents/chromedriver_mac64/chromedriver/");
		Practice p = new Practice();
/*		p.keyPressAndNavigate();
		p.findElements();
		p.elementStatus();
		p.testCaseHomework();
		p.testcaseHomework1();
*/		p._3_29_Homework();

	}
	
	public void keyPressAndNavigate() throws InterruptedException {
		WebDriver d = new ChromeDriver();
		
		// maximize browser 
		d.manage().window().maximize();
		
		// declare implicitly wait for 5 seconds
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// go to amazon.comSearch coffee mug. 
		d.get("https://amazon.com");
		d.findElement(By.id("twotabsearchtextbox")).sendKeys("Coffee Mug"+ Keys.ENTER);
		Thread.sleep(500);
		
		// Navigate back then search pretty coffee mug.  
		d.navigate().back();
		d.findElement(By.id("twotabsearchtextbox")).sendKeys("pretty Coffee Mug"+ Keys.ENTER);
		Thread.sleep(500);
		
		// Navigate back then navigate forward 
		d.navigate().back();
		d.navigate().forward();
		
		// Refresh the page.
		d.navigate().refresh();
			
	}
	
	public void findElements() {
		WebDriver d1 = new ChromeDriver();
		
		//go to https://saucedemo.com
		d1.get("https://saucedemo.com");
		
		//log in with username = standard_user   password = secret_sauce   
		d1.findElement(By.id("user-name")).sendKeys("standard_user");
		d1.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		d1.findElement(By.id("login-button")).click();
		
		//find all the results and get them in a list, and print the size of the list.
		List<WebElement> items = d1.findElements(By.cssSelector(".inventory_item"));
		int listSize = items.size();
		System.out.println(listSize);
		
		// print the price of each result. Hint: loop through the list, get index and get text
		List<WebElement> itemPrices = d1.findElements(By.cssSelector(".inventory_item_price"));
		for(int i=0; i<itemPrices.size(); i++) {
			System.out.println(itemPrices.get(i).getText());
		}
	}

	
	public static void elementStatus() throws InterruptedException {
		WebDriver d3 = new ChromeDriver();
		d3.manage().window().maximize();
		d3.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// Test case 1.
		// go to https://indeed.com
		d3.get("https://indeed.com");
		
		// check if the search fields are enabled and displayed.
		WebElement whatField = d3.findElement(By.id("text-input-what"));
		WebElement whereField = d3.findElement(By.id("text-input-where"));
		
		System.out.println(whatField.isEnabled());
		System.out.println(whatField.isDisplayed());
		System.out.println(whereField.isEnabled());
		System.out.println(whereField.isDisplayed());
		
		if(whatField.isEnabled() && whatField.isDisplayed()) {
			System.out.println("what field is enabled and displayed!");
		}else {
			System.out.println("what field is not enabled and displayed.");
		}
		if(whereField.isEnabled() && whereField.isDisplayed()) {
			System.out.println("where field is enabled and displayed!");
		}else {
			System.out.println("where field is not enabled and displaeyed.");
		}
		
		// Test case 2.
		// go to http://practice.primetech-apps.com/practice/radio-button
		d3.get("http://practice.primetech-apps.com/practice/radio-button");
		
		// Find those available radio buttons.
		List<WebElement> radioButtons = d3.findElements(By.cssSelector(".form-check-input"));
		
		// Check if it’s displayed and enabled.
		for(WebElement singleRadio : radioButtons) {
			
			// if true, check if it’s selected.
			if(singleRadio.isDisplayed() && singleRadio.isEnabled()) {
				
				// if false select the button
				if(singleRadio.isSelected()) {
					System.out.println("Radio button is selected!");
				}else {
					System.out.println("Radio button is not selected.");
					Thread.sleep(500);
					singleRadio.click();
				}
			}else {
				System.out.println("Something not right, either not displayed or not enabled.");
			}
			Thread.sleep(500);
			
			// check if it’s selected.
			System.out.println("Is the radio button selected? " + singleRadio.isSelected());
		}
		
		
		// Test case 3.
		// go to http://practice.primetech-apps.com/practice/check-box
		d3.get("http://practice.primetech-apps.com/practice/check-box");
		
		// find the checkboxes and verify if it’s displayed, 
		List<WebElement> checkboxes = d3.findElements(By.cssSelector("input[class=form-check-input]"));
		for(WebElement singleCheckbox : checkboxes) {
			if(singleCheckbox.isDisplayed()) {
				System.out.println("Its displayed.");
				// if true, then verify if it’s enabled,
				if(singleCheckbox.isEnabled()) {
					System.out.println("Its enabled.");
					// if true, verify if it’s selected,
					if(singleCheckbox.isSelected()) {
						System.out.println("Its selected.");
					}else {
						System.out.println("Its not selected, so i am selecting it.");
						// if false, then check the boxes.
						singleCheckbox.click();
					}	
					}else {
						System.out.println("It is not enabled");
					}
				}else {
					System.out.println("It is not displayed.");
				}
				// Then verify if it’s checked.
				System.out.println("is checkbox now selected? " + singleCheckbox.isSelected());
			}
		}
	
	public void testCaseHomework() {
	WebDriver d4 = new ChromeDriver();
		// go to amazon.com 
		d4.get("https://amazon.com");
		
		// click on signin      
		d4.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		Thread.sleep(500);

		// verify that you are on sign in page (either by sign-in text or email field). 
		boolean verified = d4.findElement(By.xpath("//h1[@class='a-spacing-small']")).isSelected();
		if(verified = true) {
			System.out.println("Sign-in page: Verified!");
		}else {
			System.out.println("Sign-in page: Not verified.");
		}
		
		// navigate back, and navigate forward 
		d4.navigate().back();
		d4.navigate().forward();
		
		// verify that you are on sign in page (either by sign-in text or email field).
		if(verified = true) {
			System.out.println("Sign-in page: Verified!");
		}else {
			System.out.println("Sign-in page: Not verified.");
		}
		
		// click on create new account, verify you are on new account create page.  
		d4.findElement(By.id("createAccountSubmit")).click();
		Thread.sleep(500);
		boolean v = d4.findElement(By.xpath("//h1[@class='a-spacing-small']")).isSelected();
		if(v = true) {
			System.out.println("Create new Acccount: Verified!");
		}else {
			System.out.println("Create new account: Not Verified.");
		}
		
		// navigate back, verify you are on the sign-in page.   
		d4.navigate().back();
		if(verified = true) {
			System.out.println("Sign-in page: Verified!");
		}else {
			System.out.println("Sign-in page: Not verified.");
		}
		
		// navigate forward, verify you are on the create account page.
		d4.navigate().forward();
		if(v = true) {
			System.out.println("Create new Acccount: Verified!");
		}else {
			System.out.println("Create new account: Not Verified.");
		}
		
		// click on the Continue button without filling the form
		d4.findElement(By.xpath("//input[@id='continue']")).click();
		
		// verify error messages displayed and get text to verify:Enter your name.
		WebElement nameErrorMessage = d4.findElement(By.xpath("//div[contains(text(), 'Enter your name')]"));
		if(nameErrorMessage.isDisplayed()) {
			if(nameErrorMessage.getText().equals("Enter your name")) {
				System.out.println("Name error message displays and it matches.");
		}else {
			System.out.println("Error Message: Not displayed and does nor match.");
		}
		// Enter your email or mobile phone numberMinimum 6 characters required
			WebElement emailErrorMessage = d4.findElement(By.xpath("//div[contains(text(), 'Enter your email')]"));
			if(emailErrorMessage.isDisplayed()) {
				if(emailErrorMessage.getText().equals("Enter your email or mobile phone number")) {
					System.out.println("Email error message displays and it matches.");
			}else {
				System.out.println("Email error Message: Not displayed and does nor match.");
			}
				// Minimum 6 characters required
				WebElement passwordErrorMessage = d4.findElement(By.xpath("//div[contains(text(), 'Minimum 6 characters required')]"));
				if(passwordErrorMessage.isDisplayed()) {
					if(passwordErrorMessage.getText().equals("Minimum 6 characters required")) {
						System.out.println("Password error message displays and it matches.");
				}else {
					System.out.println("Password error Message: Not displayed and does nor match.");
				}
				}
			}
		}
	}

public void testcaseHomework1() {
	WebDriver d5 = new ChromeDriver();
	
	// maximize window.  
	d5.manage().window().maximize();
	// implicitly wait for 5 seconds.
	d5.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	// go to ebay.com.  
	d5.get("https://ebay.com");
	// search coffee mug.
	d5.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("coffee mug" + Keys.ENTER );
	// find all the results and store them in a list of webelements. 
	List<WebElement> results = d5.findElements(By.cssSelector(".srp-controls__count-heading"));
	// loop through all those and get the prices of each item and print it out.  
	List<WebElement> resultPrices = d5.findElements(By.cssSelector("s-item__price"));
	for(int i=0; i<resultPrices.size(); i++) {
		System.out.println(resultPrices.get(i).getText());
	}
	
	// then quit.
	d5.quit();
	
}
public void _3_29_Homework() {
	WebDriver d6 = new ChromeDriver();
	// go to amazon.com 
	d6.get("https:amazon.com");
    // get all the options in the departments select dropdown
	WebElement selectElement = d6.findElement(By.xpath("//select[@id='searchDropdownBox']"));
	Select choose = new Select(selectElement);
	WebElement firstSelectedOption = choose.getFirstSelectedOption();
	System.out.println(firstSelectedOption);
	
	
	
    // verify there are total 58 departments. 
	
	d6.close();



    // go to amazon.com
	d6.get("https://amazon.com");
	
    // verify that you are on the amazon home page. (verify with title). 
	String expectedTitle = "Amazon.com. Spend less. Smile more.";
	if(d6.getTitle().equals(expectedTitle)) {
		System.out.println("We are on the homepage!");
	}else {
		System.out.println("We are not on the home page.");
	}
	
    // verify dropdown value is by default "All Departments"
	String defaultDropdownValue = "All Departments";
	WebElement dropdown = d6.findElement(By.id("searchDropdownBox"));
	Select letSelect = new Select(dropdown);
	String actualSelectedOption = letSelect.getFirstSelectedOption().getText();
	if(actualSelectedOption.equals(defaultDropdownValue)) {
		System.out.println("Default dropdown value matches.");
	}else {
		System.out.println("Default dropdown value does not match.");
	}
	
    // select department Home & Kitchen, and search coffee mug.
	String searchItem = "Coffee mug";
	letSelect.selectByVisibleText("Home & Kitchen");
	d6.findElement(By.id("twotabsearchtextbox")).sendKeys(searchItem);
	d6.findElement(By.id("nav-search-submit-button")).click();
	
    // verify you are on coffee mug search results page (use title).
	String itemPageTitle = d6.getTitle();
	
	// Amazon.com: Coffee Mug 23 - 10 = 13
	int beginningIndex = itemPageTitle.length() - searchItem.length();
	
	if(itemPageTitle.substring(0, 0).equals(searchItem)) {
		System.out.println("Search item title match");
	}else {
		System.out.println("Search item title Does not Match");
	}
    // verify you are in Home & Kitchen department.
	WebElement dropdown2 = d6.findElement(By.id("searchDropdownBox"));
	Select letselect2 = new Select(dropdown2);
	String selectedOption = letselect2.getFirstSelectedOption().getText();
	if(selectedOption.equals("Home & Kitchen")) {
		System.out.println("Test Pass");
	}else {
		System.out.println("Test Fail");
	}
	d6.quit();

	// go to http://practice.primetech-apps.com/practice/alerts
	// Click on the 'Alert'  button and Accept the alert. 

	
	// go to http://practice.primetech-apps.com/practice/alerts 
	// Click on the 'Confirm Alert' button and Get the text of it. Then verify if the text equals to "Do you wish to continue or cancel?" then Accept the alert.  If not, cancel the Alert

//----------------------------------------------------------------------------------------------
	WebDriverWait wait = new WebDriverWait(d6, 5);
	
	// go to http://practice.primetech-apps.com/practice/alerts 
	d6.get("practice.primetech-apps.com/practice/alerts");
	
	// Click on the 'Prompt Alert' button and type PrimeTech
	String text = "PrimeTech";
	d6.findElement(By.id("promt")).click();
	wait.until(ExpectedConditions.alertIsPresent());
	Alert handle = d6.switchTo().alert();
	handle.sendKeys(text);
	
	// Then accept the Alert. 
	handle.accept();
	
	// Verify that a greeting message displays as "Hello <your input>! How are you today?".
	WebElement greetingTextElement = d6.findElement(By.id("demo"));
	wait.until(ExpectedConditions.visibilityOf(greetingTextElement));
	String greetingText = greetingTextElement.getText();
	if(greetingText.equals("Hello" + text + "! How are you today?")) {
		System.out.println("Test Pass!");
	}else {
		System.out.println("test Fail.");
	}
	
	// go to http://practice.primetech-apps.com/practice/alerts 
	// Click on the 'Prompt Alert' button and type PrimeTech. Then dismiss the Alert.
	// Verify that "User cancelled the prompt." text displays.


}
}

		

