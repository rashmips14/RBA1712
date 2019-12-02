package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.BARejectPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class BARejectTests {
	private WebDriver driver;
	private String baseUrl;
	private BARejectPOM barejectPOM;
	
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		barejectPOM = new BARejectPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException, IOException {
		barejectPOM.sendUserName();
		//loginPOM.sendPassword("admin@123");
		barejectPOM.clickSigninBtn();
		
		barejectPOM.clickAcceptBtn();
		
		
		barejectPOM.clickDropBtn();
		
		barejectPOM.clickGoBtn();
		
		Thread.sleep(3000);
		barejectPOM.clickBills();
		barejectPOM.rejectcostSetName();
		screenShot.captureScreenShot("RejectthroughcostsetName");
		
		
		/*barejectPOM.generalReject();
		Thread.sleep(1000);
		screenShot.captureScreenShot("Approved");
		barejectPOM.cancelReject();
		
		barejectPOM.debitbillReject(); 
		screenShot.captureScreenShot("DebitbillCancel");
		barejectPOM.rejectcostSetName();
		screenShot.captureScreenShot("RejectthroughcostsetName");*/
		
		
		
	}

}
