package com.qa.TestScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import com.qa.pages.LoginPage;
import com.qa.utility.xlsread;

import io.cucumber.java.en.Given;

public class BaseClass {
	public static WebDriver driver;
	LoginPage loginpage;
	
	@Given ("I am on the saucedemo login page")
	@BeforeTest
	public void iAmonLoginPage() throws InterruptedException { 
		// Initialize WebDriver and navigate to the saucedemo URL
		System.setProperty("webdriver.chrome.driver", "src/test/java/com/qa/resources/chromedriver.exe");
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/"); driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
	}
	@DataProvider()
	public String[][] readData() throws IOException
	{
	String path="src/test/java/com/qa/utility/excel_capstoneproject_3.xlsx";
	xlsread xls =new xlsread (path);
	int rowCount =xls.getRowCount("Sheet1"); int colCount =xls.getColCount ("Sheet1", rowCount);
	String inputdata[][]= new String[rowCount][colCount];
	for (int i=1;i<=rowCount; i++) {
	for (int j=0;j<colCount;j++){
	inputdata[i-1][j]=xls.getCellData("Sheet1", i, j);
	}
	}

	return inputdata;

}

	
	@AfterTest
    public void tearDown() {
       
            driver.quit();
        
    }
	
    }


