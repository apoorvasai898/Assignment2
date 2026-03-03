package com.comcast.hrm.generic.baseclass;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.hrm.generic.file.utility.ExcelUtility;
import com.comcast.hrm.generic.file.utility.FileUtility;
import com.comcast.hrm.generic.webdriverutility.WebDriverUtility;
import com.comcast.hrm.objectrepository.CommonElements;
import com.comcast.hrm.objectrepository.LoginPage;

public class BaseClass {
	public WebDriver driver = null;
	public static WebDriver sDriver;

	@BeforeSuite
	public void connectDatabse() {
		System.out.println("Connected to Dabtabase");
	}

	@BeforeClass
	public void launchBrowser() throws IOException {
		final Map<String, Object> chromePrefs = new HashMap<>();
		chromePrefs.put("credentials_enable_service", false);
		chromePrefs.put("profile.password_manager_enabled", false);
		chromePrefs.put("profile.password_manager_leak_detection", false); // <======== This is the important one

		final ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("prefs", chromePrefs);

		FileUtility fUtility = new FileUtility();
		String BROWSER = fUtility.getDataFromPropertyFile("browser");
		String URL = fUtility.getDataFromPropertyFile("url");

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver(chromeOptions);
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
	}

	@BeforeMethod
	public void login() throws IOException {
		FileUtility fUtil = new FileUtility();
		String username = fUtil.getDataFromPropertyFile("username");
		String password = fUtil.getDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.getUsernameEd().sendKeys(username);
		lp.getPasswordEd().sendKeys(password);
		lp.getSignInBtn().click();
	}

//	@AfterMethod
//	public void logout() throws InterruptedException {
//		CommonElements ce = new CommonElements(driver);
//		WebDriverUtility wdUtility = new WebDriverUtility();
//		wdUtility.waitForElementPresent(driver, ce.getLogoutBtn());
//		ce.logoutApp(driver);
//	}
//
//	@AfterClass
//	public void closeBrowser() throws InterruptedException {
//		driver.quit();
//	}

	@AfterSuite
	public void closeDbConnection() {
		System.out.println("DB CONNECTIOn CLOSED");
	}

}
