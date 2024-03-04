package com.qa.TestScripts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.qa.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;	
public class TC_LoginPage extends BaseClass {
	@When ("I enter my username and password And I click on the Submit button")
    @Test(dataProvider="readData", priority=0)
	
	public void enterUsernameAndPassword (String Username, String Password) { 
    LoginPage lp=new LoginPage(driver);
	lp.enterUsername(Username);
    lp.enterPassword(Password);
    lp.clickLoginButton();

    String pageURL= driver.getCurrentUrl(); // If the page title is Swag Labs, perform a logout function.
    if (pageURL.equals("https://www.saucedemo.com/inventory.html"))
		{ 
			driver.findElement(By.id("react-burger-menu-btn")).click(); 
			driver.findElement(By.id("logout_sidebar_link")).click();
		}
         else 
		{
        	 lp.clickUsername(Username);
        	 lp.clickPassword(Password);
             
         
		}
}
	
	    @Then ("I should see the title of the page as {string}") 
		@Test(priority=2) 
		public void verifyTitle() 
		{
			/*String actualTitle = driver.getTitle(); 
			System.out.println(actual Title); 
			assert actualTitle.equals (expectedTitle);*/
	    	
       WebDriverWait wait = new WebDriverWait (driver, 10); wait.until(ExpectedConditions.titleContains("Swag Labs"));
       // Verify the title of the page 
       String expectedTitle = "Swag Labs"; 
       String actualTitle = driver.getTitle();

       if (actualTitle.equals(expectedTitle)) {
    	   System.out.println("Title verification successful");
       }
       else
       {
    	  System.out.println("Title verification failed");
       }
		}
		
	    
		@Then("I should see an error message")
		@Test(priority=3)
		public void verifyErrorMessage()
		{ 
			/* WebElement errorElement = driver.findElement(By.cssSelector(".error-message"));
			 assert errorElement.isDisplayed();*/
			 WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
			 String expectedErrorMessage="Epic sadface: Username and password do not match any user in this service";
			 String actualErrorMessage = errorMessage .getText(); 
			 if (actualErrorMessage.equals(expectedErrorMessage)) 
			 {
				 System.out.println("Error message verification successful");
			 }
			 else
			 {
				 System.out.println("Error message verification failed");
			 }
		}
		
		

	}



