package com.training.pom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Recurringpom {
private WebDriver driver; 
	
	public Recurringpom(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="email")
	private WebElement intranetId; 
	
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
	private WebElement CostsTab;
	@FindBy(linkText="Recurring cost")
	private WebElement RecurringTab;
	@FindBy(id="addcostGroup")
	private WebElement AddrecurringBtn;
	@FindBy(id="NexId")
	private WebElement NexId;
	@FindBy(xpath="//select[@id='Freq']")
	private WebElement Frequency;
	@FindBy(xpath="//input[@class='hasDatepicker']")
	private WebElement StartDt;
	@FindBy(id="recurcnt")
	private WebElement recurcnt;
	@FindBy(id="recuramt")
	private WebElement recuramt;
	@FindBy(id="AcctId")
	private WebElement AcctId;
	@FindBy(xpath="//select[@id='CmpnyCd']")
	private WebElement CmpnyCd;
	@FindBy(id="submit_btn")
	private WebElement Submit;
	@FindBy(xpath="//input[@id='StartDt']")
	private WebElement Sdate;	
	
public void sendUserName() throws IOException {
	this.intranetId.clear();
	//Step1:have to access the excel file
			File fexcel=new File("C:\\Screenshot\\RecurringData.xlsx");
			//open it
			FileInputStream fis=new FileInputStream(fexcel);
			//interface of apachepoi so xssf this is to work with xlsx format and hssf is interface to work with xls format
			//This is to open the workbook in the excel file
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			//this is to open the sheet in the excel file
			XSSFSheet sheet=wb.getSheet("Recurring");
			String intranetid=sheet.getRow(1).getCell(0).getStringCellValue();
			System.out.println("data in the 0th row and 0th column is" +intranetid);
			
			
			//String data2=sheet.getRow(0).getCell(1).getStringCellValue();
			//System.out.println("data in the 0th row and 1st column is" +data2);
			
	this.intranetId.sendKeys(intranetid);
}

public void clickSigninBtn() {
	this.signin.click(); 
}

public void clickAcceptBtn() {
this.acceptBtn.click();
}
public void clickGoBtn() {
this.selectGo.click();
System.out.println("clicked on Go");
}	
public void clickRecrruingBtn() throws InterruptedException {
	this.CostsTab.click(); 
	Thread.sleep(3000);
	this.RecurringTab.click();
	Thread.sleep(3000);
	this.AddrecurringBtn.click();
	Thread.sleep(3000);
}


public void AddRecurring() throws InterruptedException, IOException {
	File fexcel=new File("C:\\Screenshot\\RecurringData.xlsx");
	//open it
	FileInputStream fis=new FileInputStream(fexcel);
	//interface of apachepoi so xssf this is to work with xlsx format and hssf is interface to work with xls format
	//This is to open the workbook in the excel file
	XSSFWorkbook wb=new XSSFWorkbook(fis);
//this is to open the sheet in the excel file
	XSSFSheet sheet=wb.getSheet("Recurring");
	String NexId=sheet.getRow(1).getCell(2).getStringCellValue();
	this.NexId.sendKeys(NexId);
	String Frequency=sheet.getRow(1).getCell(3).getStringCellValue();
	this.Frequency.sendKeys(Frequency);
	Thread.sleep(3000);
	System.out.println("Frequency vaqlue");
    String ExpectedDate ="18/12/2019"; //dd/mm/yyyy
    String [] dateval = ExpectedDate.split("/");
    int monthToSelect = Integer.parseInt(dateval[1])		;
    String selectedMonth =driver.findElement(By.className("ui-datepicker-month")).getText();
    System.out.println(selectedMonth);

}

	//String recurcnt=sheet.getRow(1).getCell(4).getStringCellValue();
	//this.recurcnt.sendKeys(recurcnt);
	//String AcctId=sheet.getRow(1).getCell(5).getStringCellValue();
    //String CmpnyCd=sheet.getRow(1).getCell(7).getStringCellValue();

	
	//System.out.println("data in the 0th row and 0th column is" +intranetId, +Frequency,);
	
	
	//String data2=sheet.getRow(1).getCell(1).getStringCellValue();
	//System.out.println("data in the 0th row and 1st column is" +data2);
	
//this.NexID.sendKeys(NexID);

}


/*public void clickDropBtn() throws IOException{
	File fexcel=new File("C:\\Screenshot\\RecurringData.xlsx");
	FileInputStream fis=new FileInputStream(fexcel);
	XSSFWorkbook wb=new XSSFWorkbook(fis);
	XSSFSheet sheet=wb.getSheet("Recurring");
	CharSequence nodeid=sheet.getRow(1).getCell(1).getStringCellValue();
	System.out.println("data in the 1th row and 2th column is" +nodeid);
	
	
	this.nodeselect.click();
	 List<WebElement> list =nodemenu ;
	 System.out.println("get the size");
	 System.out.println(list.size());
	 for(int i=0;i<list.size();i++){
		 System.out.println(list.get(i).getText());
				 if(list.get(i).getText().contains(nodeid))
		 {
		 list.get(i).click();
		 }
	 
 }
 


*/


