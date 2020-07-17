package com.application;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;
public class AutomateTheWebApplication {  
  
	    public String url="http://automationpractice.com/index.php";
    	public WebDriver driver;
    	
    	@BeforeMethod
    	public void launchTheWebsite(){
    	System.setProperty("webdriver.chrome.driver", "D:\\cdd\\chromedriver.exe");
    	 driver = new ChromeDriver(); 
    	 driver.get(url);
    	//Maximize the browser  
    	driver.manage().window().maximize(); 
    	//The implicit wait will tell the web driver to wait for certain amount of time before it throws a "No Such Element Exception".
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	}
    	
    	@Test(priority = 0)
    	public void registrationTest() {
        // Click on the Sign-up button  
		driver.findElement(By.className("login")).sendKeys(Keys.ENTER);     
		driver.findElement(By.name("email_create")).sendKeys("hiralpaghadal101@gmail.com");  
		driver.findElement(By.name("SubmitCreate")).sendKeys(Keys.ENTER); 
		    
		WebElement radio2 = driver.findElement(By.id("id_gender2"));
		radio2.click();
		driver.findElement(By.name("customer_firstname")).sendKeys("Hiral");  
		driver.findElement(By.name("customer_lastname")).sendKeys("Paghadal");  
		driver.findElement(By.name("passwd")).sendKeys("hiral123456789");
		
		Select objSelect1 = new Select(driver.findElement(By.id("days")));
		objSelect1.selectByIndex(24);
		Select objSelect2 = new Select(driver.findElement(By.id("months")));
		objSelect2.selectByIndex(7);
		Select objSelect3 = new Select(driver.findElement(By.id("years")));
		objSelect3.selectByValue("1998");
		
		WebElement tcCheckbox = driver.findElement(By.id("newsletter"));
	     //Checking if the newsletter checkbox is enabled on the Webpage and printing its status
		 boolean tcCheckboxIsEnabled = tcCheckbox.isEnabled();
         System.out.println("Newsletter checkbox enabled: "+tcCheckboxIsEnabled);
         boolean tcCheckboxIsSelected = tcCheckbox.isSelected();
         System.out.println("Newsletter: "+tcCheckboxIsSelected);
         // Checking the option to Sign up for our newsletter!
         tcCheckbox.click();
         
		WebElement tcCheckbox2 = driver.findElement(By.id("optin"));
	    //Checking if the Receive special offers enabled is displayed on the Webpage and printing its status
		 boolean tcCheckboxIsEnabled2 = tcCheckbox.isEnabled();
         System.out.println("Receive special offers checkbox enabled: "+tcCheckboxIsEnabled2);
         boolean tcCheckboxIsSelected2 = tcCheckbox.isSelected();
         System.out.println("Receive special offers: "+tcCheckboxIsSelected2);
         //Checking the option to Receive special offers from our partners! 
		tcCheckbox2.click();
		
		
		driver.findElement(By.name("address1")).sendKeys("400 BlackStreet"); 
		driver.findElement(By.name("city")).sendKeys("Mumbai");
		Select objstate = new Select(driver.findElement(By.id("id_state")));
		objstate.selectByVisibleText("Alaska");
		driver.findElement(By.name("postcode")).sendKeys("40064");
		Select objcountry = new Select(driver.findElement(By.id("id_country")));
		objcountry.selectByVisibleText("United States");
		driver.findElement(By.name("other")).sendKeys("Very excited to shop");
		driver.findElement(By.name("phone")).sendKeys("1010101010");
		driver.findElement(By.name("phone_mobile")).sendKeys("1000000000");
		driver.findElement(By.name("alias")).sendKeys(" is Mumbai");
		driver.findElement(By.id("submitAccount")).sendKeys(Keys.ENTER); 
	
   } 
    	
    	
    	@Test(priority=1)
    	public void loginTest() {
    		driver.findElement(By.className("login")).sendKeys(Keys.ENTER);
    		driver.findElement(By.id("email")).sendKeys("hiralpaghadal101@gmail.com");  
    		driver.findElement(By.id("passwd")).sendKeys("hiral123456789");
    		driver.findElement(By.name("SubmitLogin")).sendKeys(Keys.ENTER); 
    		String actualUrl="http://automationpractice.com/index.php?controller=my-account";
    		String expectedUrl= driver.getCurrentUrl();
    		if(actualUrl.equalsIgnoreCase(expectedUrl)) {
    			System.out.println("Login Credentials valid...!!");
    		}
    		else {
    			System.out.println("Login Credentials invalid...!!");
    		}
    		try {
    			TimeUnit.SECONDS.sleep(20);
        	}
        		catch(InterruptedException e){
        			e.printStackTrace();
        		}
        	
    	}
    	
    	@Test(priority=2)
    	public void searchingandAddingToCartTest() {
    		driver.findElement(By.className("login")).sendKeys(Keys.ENTER);
    		driver.findElement(By.id("email")).sendKeys("hiralpaghadal101@gmail.com");  
    		driver.findElement(By.id("passwd")).sendKeys("hiral123456789");
    		driver.findElement(By.name("SubmitLogin")).sendKeys(Keys.ENTER); 
    		String actualUrl="http://automationpractice.com/index.php?controller=my-account";
    		String expectedUrl= driver.getCurrentUrl();
    		if(actualUrl.equalsIgnoreCase(expectedUrl)) {
    			System.out.println("Login Credentials valid...");
    		}
    		else {
    			System.out.println("Login Credentials invalid...!!");
    		}
    	
    		driver.findElement(By.name("search_query")).sendKeys("Dresses");
    		driver.findElement(By.name("submit_search")).sendKeys(Keys.ENTER);
    		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    		driver.findElement(By.xpath("//*[contains(text(),'Printed Chiffon Dress')]")).click();
    		driver.findElement(By.name("Submit")).sendKeys(Keys.ENTER);
    
    	}
 
    	@AfterMethod
    	public void closingTheBrowser() {
    		driver.quit();
    	}
}
