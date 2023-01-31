package com.DSAlgo.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.DSAlgo.qa.base.TestBase;
import com.DSAlgo.qa.pages.GetStartedPage;
import com.DSAlgo.qa.pages.HomePage;
import com.DSAlgo.qa.util.Loggerload;


public class GetStartedTest extends TestBase{
	
	GetStartedPage getStartedPage;
	HomePage homePage;
	
	public GetStartedTest() 
	{
		super();//call super class constructor
	}
	
	@BeforeMethod	
	public void setUp() 
	{	
		initilization();	
		getStartedPage = new GetStartedPage();	
	}
	
	@Test
	public void getStartedButtonClickTest()
	{		
		Loggerload.info("User is clicking on GetStarted button on Main Page");
		homePage= getStartedPage.clickOnGetStarted();
	}
	
	@Test
	public void validateUserLandingHomePageTest() 
	{
		String HomePageTitle = driver.getTitle();
		Loggerload.info("Title of current page is ***** " + HomePageTitle + " ****");
		Assert.assertEquals(HomePageTitle, "Numpy Ninja");
	}
		
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
