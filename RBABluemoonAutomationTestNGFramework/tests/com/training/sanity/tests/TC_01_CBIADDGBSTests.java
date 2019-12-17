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
import com.training.pom.TC_01_CBIADDGBSPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC_01_CBIADDGBSTests {
	private WebDriver driver;
	private String baseUrl;
	private TC_01_CBIADDGBSPOM tC_01_CBIADDGBSPOM;
	
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
		tC_01_CBIADDGBSPOM = new TC_01_CBIADDGBSPOM(driver); 
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
	public void validloginTest() throws InterruptedException, IOException {
		tC_01_CBIADDGBSPOM.sendloginId();
		
		tC_01_CBIADDGBSPOM.clickSigninBtn();
		tC_01_CBIADDGBSPOM.clickAcceptBtn();
		
		tC_01_CBIADDGBSPOM.clickDropBtn();
		tC_01_CBIADDGBSPOM.clickGoBtn();
		Thread.sleep(3000);
		tC_01_CBIADDGBSPOM.clickCosts();
		tC_01_CBIADDGBSPOM.clickCentralizedCosts();
		tC_01_CBIADDGBSPOM.clickAddcost();
		
		
		
	}


}
