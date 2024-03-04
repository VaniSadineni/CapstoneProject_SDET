package com.qa.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;  
	public class LoginPage {
		
		
	    WebDriver driver;
		public LoginPage(WebDriver d) {
			this.driver=d;
			PageFactory.initElements(d, this);
		}
		
		@FindBy(id="user-name")
		WebElement usernameElement;
		public void enterUsername(String username) {
	        usernameElement.sendKeys(username);
		}
		@FindBy(id="password")
		WebElement passwordElement;
		public void enterPassword(String password) {
			passwordElement.sendKeys(password);
		}
		
		@FindBy(css=".btn_action")
		WebElement loginButtonElement;
		 public void clickLoginButton() {
		        loginButtonElement.click();
		    }
		
		@FindBy(css="h3[data-test='error']")
		 WebElement errorElement;
		  public String getErrorMessage() {
	        return errorElement.getText();
	    }
	    
	    @FindBy(id="user-name")
		WebElement usernameEle;
		public void clickUsername(String username) {
	        usernameElement.clear();
		}
		@FindBy(id="password")
		WebElement passwordEle;
		public void clickPassword(String password) {
			passwordElement.clear();
		}

		
		

	}



