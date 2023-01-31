package com.DSAlgo.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.DSAlgo.qa.base.TestBase;
import com.DSAlgo.qa.pages.GetStartedPage;
import com.DSAlgo.qa.pages.HomePage;
import com.DSAlgo.qa.pages.RegisterPage;
import com.DSAlgo.qa.pages.SignInPage;
import com.DSAlgo.qa.util.Loggerload;
import com.DSAlgo.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	
	GetStartedPage getStartedPage;
	HomePage homePage;
	SignInPage signInPage;
	RegisterPage registerPage;
	TestUtil testUtil;
	public HomePageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initilization();
	
		homePage = new HomePage();		
		getStartedPage =new GetStartedPage();	
		 
		//Clicking on get started button and getting homePage object in return
		homePage = getStartedPage.clickOnGetStarted();
	}
	@Test (priority=1)
	public void VerifyUserLandedHomePageTest() {
		Loggerload.info("Verifying user landed on home page after clicking on Get Started button");
		String homeURL= homePage.LandedHomePage();
		Assert.assertEquals(homeURL, prop.getProperty("home_url"), "User has not landed on HomePage");
	}
	
	@Test(priority = 3)
	public void loginLnkClickTest() {
		Loggerload.info("Clicking on Login button on Home Page");
		signInPage=homePage.ClickloginUserLnk();	
	}
	

	public void ValidateUserLandedLoginPageClickingRegisterBtn() {
		Loggerload.info("Clicking on Login button from HomePage User landed on Login Page");
		//String SignInPageTitle = signInPage.getPageTitle();
		String RegisterPageTitle = testUtil.getPageTitle();
		Loggerload.info("Title of current page is : " + RegisterPageTitle);
		Assert.assertEquals(RegisterPageTitle, "Registration", "Title does not match");
		
	}
	
	@Test (priority =2)
	public void RegisterLnkClickTest() {
		Loggerload.info("Clicking on Register button on Home Page");
		registerPage= homePage.ClickRegisterUserLnk();
	}
	
	public void ValidateUserLandedRegisterPageClickingRegisterBtn() {
		Loggerload.info("Clicking on Register button from HomePage User landed on Register Page");
		String SignInPageTitle = testUtil.getPageTitle();
		Loggerload.info("Title of current page is : " + SignInPageTitle);
		Assert.assertEquals(SignInPageTitle, "Login", "Title do not match");
	}
	
	//@Test
	//public void DropdownOptionsValidationTest() {
		//homePage.ClickOnDropdown();
		//String dropdownoptions = homePage.DropdownOptions();
		//System.out.println(dropdownoptions);
		//Assert.assertEquals(dropdownoptions.contains("Linked List"),true);		
	//}
	@Test
	public void UserClickGetStartedBtnWithoutLogin() {
		Loggerload.info("User is clicking on GetStarted button under DataStructure without Login");
		homePage.ClickGetStartedBtnWithoutLogin();
	}
	
	@Test
	public void UserSelectValueFromDropdownTest() {
		Loggerload.info("User is selecting one of the option from dropdown");
		homePage.selectValueFromdropdown("Arrays");
	}
	@Test
	public void UserNotLoggedInValidationMsgTest() {
		Loggerload.info("User got Error message on clicking GetStarted button under Data Structure without Login");
		String ErrorMsg = homePage.UserNotLoggedMsg();
		Assert.assertEquals(ErrorMsg, "You are not logged in");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
	
