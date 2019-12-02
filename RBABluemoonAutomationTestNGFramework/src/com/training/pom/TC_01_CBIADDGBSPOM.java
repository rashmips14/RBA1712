package com.training.pom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TC_01_CBIADDGBSPOM {
private WebDriver driver; 
	
	public TC_01_CBIADDGBSPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement loginId; 
	
	@FindBy(xpath="//input[@class='ibm-btn-arrow-pri']")
	private WebElement signin;
	
	@FindBy(id="accept")
	private WebElement acceptBtn;
	@FindBy(xpath="//span[@class='dijitReset dijitInline dijitSelectLabel']")
	private WebElement nodeselect;
	@FindBy(xpath="//div[@id='selNode_menu']")
	private List<WebElement> nodemenu;
	@FindBy(xpath="//input[@class='ibm-btn-arrow-pri']")
	private WebElement selectGo;
	@FindBy(xpath="//strong[contains(text(),'- CBI')]")
	private WebElement checkCBI;
	@FindBy(linkText="Costs")
	private WebElement Coststab;
	@FindBy(linkText="Centralized costs")
	private WebElement CentralizedCoststab;
	@FindBy(css="#addcost")
	private WebElement AddCostbutton;
	@FindBy(css="#ProjId")
	private WebElement ProjectId;
	
	
	//Select Countrydrop=new Select(country);
	
	
		public void sendloginId() throws IOException {
		this.loginId.clear();
		//Step1:have to access the excel file
				File fexcel=new File("C:\\Screenshot\\CBIADDGBSData.xlsx");
				//open it
				FileInputStream fis=new FileInputStream(fexcel);
				//interface of apachepoi so xssf this is to work with xlsx format and hssf is interface to work with xls format
				//This is to open the workbook in the excel file
				XSSFWorkbook wb=new XSSFWorkbook(fis);
				//this is to open the sheet in the excel file
				XSSFSheet sheet=wb.getSheet("Sheet1");
				String intranetid=sheet.getRow(0).getCell(0).getStringCellValue();
				System.out.println("data in the 0th row and 0th column is" +intranetid);
				
				
				//String data2=sheet.getRow(0).getCell(1).getStringCellValue();
				//System.out.println("data in the 0th row and 1st column is" +data2);
				
		this.loginId.sendKeys(intranetid);
	}
		
	public void clickSigninBtn() {
		this.signin.click(); 
	}
	
	public void clickAcceptBtn() {
		this.acceptBtn.click();
	}
	public void clickDropBtn() throws IOException {
		File fexcel=new File("C:\\Screenshot\\CBIADDGBSData.xlsx");
		FileInputStream fis=new FileInputStream(fexcel);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("Sheet1");
		String nodeid=sheet.getRow(1).getCell(0).getStringCellValue();
		System.out.println("data in the 0th row and 0th column is" +nodeid);
		
		
		
		this.nodeselect.click();
		 List<WebElement> list =nodemenu ;
		 System.out.println("get the size");
		 System.out.println(list.size());
		 for(int i=0;i<list.size();i++){
			 System.out.println(list.get(i).getText());
			
			 if(list.get(i).getText().contains(nodeid))
			 {
			 list.get(i).click();
			 break;
		 
		 }
			 
	}
	
	}

	 public void clickGoBtn() {
			this.selectGo.click();
			System.out.println("clicked on Go");
		   }
		  public void clickCosts() {
			  try {
			  if(this.checkCBI.getText().contains("- CBI")) {
				  this.Coststab.click();
			  }
			  
			  }
			  catch(Exception e) {
				System.out.println("Logged in User is not CBI");
				
			  }
		  }
		  public void clickCentralizedCosts()
		  {
			  this.CentralizedCoststab.click();
		  }
		  public void clickAddcost() {
			 try {
				 if(this.AddCostbutton.isDisplayed()) {
					 this.AddCostbutton.click();
					 System.out.println("Clicked on Add costs");
					 String addwindow=driver.getWindowHandle();
					 driver.switchTo().window(addwindow);
					 this.ProjectId.sendKeys("1232");
					 
					 System.out.println("Entered Project id ");
				 }
			 }
			 catch(Exception e){
				 System.out.println("Add costs not exists"); 
			 }
		  }
		  
		  public void enterDataInAddpopup() {
			  
		  }

}
