package com.tetonshop.main;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.observer.entity.MediaEntity.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.tetonshop.homepage.Products;
import com.tetonshop.homepage.ProductsAdd_DeleteCart;
import com.tetonshop.homepage.Register;
import com.tetonshop.homepage.ResetPassword;
import com.tetonshop.report.ExtentReportsWithTestNG;
import graphql.org.antlr.v4.runtime.misc.Utils;
import com.tetonshop.homepage.AboutUs;
import com.tetonshop.homepage.Contact;
import com.tetonshop.homepage.FAQ;
import com.tetonshop.homepage.Login;

public class SeleniumTestManager {

	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("Extentreport.html");

	//	static WebDriver driver;
	//	static ExtentReports report;
	//	static ExtentTest test;
	static WebDriver driver = null;

	@BeforeTest 
	public static void main (String[] args) throws InterruptedException {
		try {

			//WebDriverManager.chromedriver().setup();
			//WebDriverManager.firefoxdriver().setup();

			final String SERVER_URL = "https://shop.tetonelectronics.com/";

			WebDriver driver = getChromeDriver(SERVER_URL); 

			//WebDriver webDriverManager;
			//webDriverManager = WebDriverManager.chromedriver();
			//webDriverManager.config().setCachePath("F:\\My Work\\Selenium\\selenium-java-3.141.59\\chromedriver_win32");

			//webDriverManager.setup();

			//WebDriver driver = getFirefoxDriver(SERVER_URL);          
		
			//AboutUs.createAboutUsTest(driver);
			//Products.createProductsTest(driver);
			//FAQ.createFAQTest(driver);
			//Contact.createContactTest(driver);
			//ProductsAdd_DeleteCart.createProductsAdd_DeleteCart(driver);
			//Register.createRegisterTest(driver);
			//ResetPassword.createResetPasswordTest(driver);
			//Login.createLoginTest(driver);
			ExtentReportsWithTestNG.createExtentReportsWithTestNG(driver);
			
//			ExtentTest Test = extent.createTest("Launch Browser and Website").assignAuthor("Mohammad").assignCategory("UI Test").assignDevice("DeskTop");
//			Test.log(Status.PASS,"user launched website");
//			Test.pass("user launched website verified");
		}
		catch(Exception e) {
			e.printStackTrace();
			try {
				driver.quit();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		//login(driver);

	}

	@Test
	private static WebDriver getChromeDriver(String serverUrl) {

		final String DRIVER_NAME = "webdriver.chrome.driver";
		System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
		//final String DRIVER_URL =  "F:\\My Work\\Work Tools\\Selenium\\selenium-java-3.141.59\\chromedriver_win32\\chromedriver.exe";

		//System.setProperty(DRIVER_NAME, DRIVER_URL);
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

//		report = new ExtentReports("C:\\Users\\Rubaet\\eclipse-workspace\\DemoWebAutomation\\report\\report.html", true);
//		test = report.startTest("Extent report demo");

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(serverUrl);    

		return driver;
	}

	private static WebDriver getFirefoxDriver(String serverUrl) {

		final String DRIVER_NAME = "webdriver.gecko.driver";
		//final String DRIVER_URL = "F:\\My Work\\Selenium\\selenium-java-3.141.59\\chromedriver_win32\\geckodriver.exe";

		//System.setProperty(DRIVER_NAME, DRIVER_URL);
		WebDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(serverUrl);

		return driver;
	}

//	@BeforeTest
//	public void BeforeTest() {
//		extent.attachReporter(spark);
//	}
//
//	@AfterSuite
//	public void AfterTest() {
//
//		extent.flush();
//	}

	//	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	//	{
	//		TakesScreenshot ts = (TakesScreenshot)driver;
	//		File source = ts.getScreenshotAs(OutputType.FILE);
	//		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
	//		FileUtils.copyFile(source, file);
	//		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	//	}
	
		@AfterTest
		public void tearDownTest() {
			//close browser
			driver.close();
			driver.quit();
			System.out.println("Test Completed Successfully");
		}

}