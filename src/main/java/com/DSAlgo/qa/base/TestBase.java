package com.DSAlgo.qa.base;
//Initialized my prop variable and reading my properties.Prop is a global variable that can be used	inside test class and child class also


	import java.beans.EventHandler;
	import io.github.bonigarcia.wdm.WebDriverManager;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.safari.SafariDriver;

import com.DSAlgo.qa.util.TestUtil;
	

	public class TestBase {
		
		private static final long PAGE_LOAD_TIMEOUT = 0;
		private static final long IMPLICIT_WAIT = 0;
		public static WebDriver driver;
		public static Properties prop;
		
		
		public TestBase() {	
			
			//Inside the Constructor of base class we are intilialising the properties
			
			try {
				prop= new Properties();
				FileInputStream ip = new FileInputStream("C:\\Users\\bassa\\eclipse-workspace\\Maven-TestNGPractice\\src\\main\\java\\com\\dsalgo"
						+"\\qa\\config\\config.properties");
				prop.load(ip);			
			}
			catch(FileNotFoundException e) {
				e.printStackTrace();
			}
			catch(IOException e) {
				e.printStackTrace();
			}				
		}

	//Initialization method
	@SuppressWarnings("deprecation")
	public static void initilization() {
		
		String browserName=prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("safari")) {

			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		}
			
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url")); 
	}

}
		




