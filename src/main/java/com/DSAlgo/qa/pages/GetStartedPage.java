package com.DSAlgo.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.DSAlgo.qa.base.TestBase;
import com.DSAlgo.qa.pages.HomePage;
import com.DSAlgo.qa.util.TestUtil;

public class GetStartedPage extends TestBase{
	
	//Page Factory-OR:	
		@FindBy(xpath="//a[@href='/home']")
		WebElement getStartedBtn;
				
	//Constructor ,initializing the PageObjects
		public GetStartedPage() 
		{
			PageFactory.initElements(driver, this); 
		} 
	
	//Click on Get Started button method
	public HomePage clickOnGetStarted() {			
			getStartedBtn.click();
			return new HomePage();
		}
	
	
	
}
