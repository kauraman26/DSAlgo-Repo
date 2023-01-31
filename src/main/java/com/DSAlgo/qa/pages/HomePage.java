package com.DSAlgo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.DSAlgo.qa.base.TestBase;
import com.DSAlgo.qa.pages.RegisterPage;
import com.DSAlgo.qa.pages.SignInPage;
import com.DSAlgo.qa.util.TestUtil;


public class HomePage extends TestBase {
	
	//Page Factory 
	
		//Sign-in button
		@FindBy(xpath="//a[@href='/login']")
		WebElement loginLnk;
		
		//Register button
		@FindBy(xpath="//a[@href='/register']")
		WebElement registerLnk;
		
		//Logout button
		@FindBy(xpath= "//a[@href='/logout']")
		WebElement logoutBtn;
		
		//Dropdown option
		@FindBy (xpath="//a[@href='#']")
		WebElement dropdown;		
		@FindBy (xpath="//div[@class='dropdown-menu show']")
		WebElement dropdown_array;
		@FindBy (xpath="//*[@id='navbarCollapse']//a[2]")
		WebElement dropdown_linkedlist;
		@FindBy (xpath="//*[@id='navbarCollapse']//a[3]")
		WebElement dropdown_stack;
		@FindBy (xpath="//*[@id='navbarCollapse']//a[4]")
		WebElement dropdown_queue;
		@FindBy (xpath="//*[@id='navbarCollapse']//a[5]")
		WebElement dropdown_tree;
		@FindBy (xpath="//*[@id='navbarCollapse']//a[6]")
		WebElement dropdown_graph;
		
		
		//DropDownOptions
		@FindBy(xpath= "//div[@class='dropdown-menu show']")
		WebElement HomePageDropdwn;
		
		//GetStarted button under DataStructure
		@FindBy(xpath = "//a[@href='data-structures-introduction']")
		WebElement GetStartedDSBtn;
		
		//You are logged in message
		@FindBy(xpath="//div[contains (text(),'You are logged in')]")
		WebElement loginSuccessMsg;
		
		//You are not logged in message
		@FindBy(xpath="//div[contains (text(),'You are not logged in')]")
		WebElement WithoutloginErrorMsg;
		
		//Get Started button for datastructure
		@FindBy (xpath="//a[text()='Get Started' and @href='data-structures-introduction']")
		WebElement getstartBtn_dataStructures;
		//Get Started button for array
		@FindBy (xpath="//a[text()='Get Started' and @href='array']")
		WebElement getstartBtn_array;
		//Get Started button for Linked List
		@FindBy (xpath="//a[text()='Get Started' and @href='linked-list']")
		WebElement getstartBtn_linkedlist;
		//Get Started button for Stack
		@FindBy (xpath="//a[text()='Get Started' and @href='stack']")
		WebElement getstartBtn_stack;
		//Get Started button for Queue
		@FindBy (xpath="//a[text()='Get Started' and @href='queue']")
		WebElement getstartBtn_queue;
		//Get Started button for tree
		@FindBy (xpath="//a[text()='Get Started' and @href='tree']")
		WebElement getstartBtn_tree;
		//Get Started button for graph
		@FindBy (xpath="//a[text()='Get Started' and @href='graph']")
		WebElement getstartBtn_graph;
		
		
		//Initializing Page Objects
		public HomePage() {
			PageFactory.initElements(driver, this);
		}
		
		
		//Actions
		public String LandedHomePage() {
			 return driver.getCurrentUrl();
		}
		
		public boolean LogoutUserBtn() {
			return logoutBtn.isDisplayed();
		}
		
		public RegisterPage ClickRegisterUserLnk() {
			registerLnk.click();
			return new RegisterPage();
		}
		
		public SignInPage ClickloginUserLnk() {
			loginLnk.click();
			return new SignInPage();
		}
		
		public boolean LoginSucessMessage() {
			return loginSuccessMsg.isDisplayed();
		}
		
		//Click on Dropdown on Home Page
		public void ClickOnDropdown() {			
			dropdown.click();
		}

		//get all the options displayed in dropdown
		//public String DropdownOptions() {
			// String dropdownText = HomePageDropdwn.getText();	
			// return dropdownText;
		//}
			
		
		//Click on Get Started button on DataStructure without logging in .It should alert the user with a message "You are not logged in"
		public void ClickGetStartedBtnWithoutLogin() {
			GetStartedDSBtn.click();	
		}
		//user should get alert  message "You are not logged in"
		public String UserNotLoggedMsg() {
			return WithoutloginErrorMsg.getText();
		}
		
		public String getPageTitle() {
			String title = driver.getTitle();
			return title;
		}
			
		
		public void selectValueFromdropdown(String string) {
			dropdown.click();
			switch (string) {
			case "Arrays":
				dropdown_array.click();
				break;
			case "Linkedlist":				
				dropdown_linkedlist.click();
				break;
			case "Stack":				
				dropdown_stack.click();
				break;
			case "Queue":				
				dropdown_queue.click();
				break;
			case "Tree":				
				dropdown_tree.click();
				break;
			case "Graph":
				dropdown_graph.click();
				break;
			}
		
		}	
		
}
