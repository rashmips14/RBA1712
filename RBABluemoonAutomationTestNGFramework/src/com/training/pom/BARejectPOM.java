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
import org.openqa.selenium.support.ui.Select;




public class BARejectPOM {
private WebDriver driver; 
	
	public BARejectPOM(WebDriver driver) {
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
	@FindBy(xpath="//strong[contains(text(),'- BA')]")
	private WebElement checkBA;
	@FindBy(xpath="//strong[contains(text(),'- BFA')]")
	private WebElement checkBFA;
	@FindBy(linkText="Bills")
	private WebElement billsTab;
	@FindBy(xpath="//select[@id='monthList']")
	private WebElement month;
	@FindBy(xpath="//select[@id='costType']")
	private WebElement Typeofcost;
	@FindBy(xpath="//select[@id='ActionType']")
	private WebElement Action;
	@FindBy(xpath="//select[@id='costsetTypeValue1']")
	private WebElement GroupBy;
	@FindBy(xpath="//input[@id='filter']")
	private WebElement Go;
	@FindBy(xpath="//b[contains(text(),'No data')]")
	private WebElement Nodatamessage;
	@FindBy(xpath="//b[contains(text(),'No Data')]")
	private WebElement Nodatamessagecancel;
	
	
	@FindBy(xpath="//tr[1]//td[7]//button[2]")
	private WebElement Reject;
	@FindBy(xpath="//tr[1]//td[7]//button[1]")
	private WebElement Approve;
	
	@FindBy(xpath="//tr[1]//td[4]//a[1]")
	private WebElement AcctIdlink;
	
	@FindBy(xpath="//td[@id='nexID']")
	private WebElement nexIDforcostsetName;
	/*//@FindBy(xpath="//a[contains(text(),'ICA')]")
	@FindBy(xpath="//tr[1]//td[5]//a[1]")
	private WebElement ICAlink;
	//@FindBy(xpath="//a[contains(text(),'VIEW')]")
	@FindBy(xpath="//tr[1]//td[6]//a[1]")
	private WebElement Viewlink;
	@FindBy(xpath="//div[@id='dialog_ActIDdept']//span[@class='dijitDialogCloseIcon']")
	private WebElement ClickonAcctcloseIcon;
	@FindBy(xpath="//span[@class='dijitDialogCloseIcon']")
	private WebElement ClickoncloseIcon;
	@FindBy(xpath="//span[@class='dijitDialogCloseIcon dijitDialogCloseIconHover']")
	private WebElement ClickonViewCloseIcon; */
	
	
	// acct: //tr[1]//td[4]//a[1]
		// ica: //tr[1]//td[5]//a[1]
			// view://tr[1]//td[6]//a[1] 
	
	//Select Countrydrop=new Select(country);
	
	
		public void sendUserName() throws IOException {
		this.intranetId.clear();
		//Step1:have to access the excel file
				File fexcel=new File("C:\\Screenshot\\BABFAData.xlsx");
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
				
		this.intranetId.sendKeys(intranetid);
	}
		
	public void clickSigninBtn() {
		this.signin.click(); 
	}
	
	public void clickAcceptBtn() {
		this.acceptBtn.click();
	}
	public void clickDropBtn() throws IOException{
		File fexcel=new File("C:\\Screenshot\\BABFAData.xlsx");
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
  public void clickBills() {
	  try {
	  if(this.checkBA.getText().contains("- BA")) {
		  this.billsTab.click();
	  }
	  
	  }
	  catch(Exception e) {
		 if(this.checkBFA.getText().contains("- BFA")) {
			 this.billsTab.click();
		 }
		  
	  }
  }
  public void rejectcostSetName() throws IOException
  {

  File fexcel=new File("C:\\Screenshot\\BABFAData.xlsx");
  			//open it
  			FileInputStream fis=new FileInputStream(fexcel);
  			//interface of apachepoi so xssf this is to work with xlsx format and hssf is interface to work with xls format
  			//This is to open the workbook in the excel file
  			XSSFWorkbook wb=new XSSFWorkbook(fis);
  			//this is to open the sheet in the excel file
  			XSSFSheet sheet=wb.getSheet("Sheet1");
  			String Monthname=sheet.getRow(0).getCell(4).getStringCellValue();
  			System.out.println("data in the 0th row and 4th column is" +Monthname);
                           String CostSetNameexc=sheet.getRow(0).getCell(5).getStringCellValue();
  			System.out.println("data in the 0th row and 5th column is" +CostSetNameexc);
  			Select Typeofcostdrop=new Select(Typeofcost);
  			Typeofcostdrop.selectByVisibleText("General");
  Select monthdrop=new Select(month);
  monthdrop.selectByVisibleText(Monthname);
  this.Go.click();
  

	try {

  if(this.nexIDforcostsetName.getText().contains(CostSetNameexc)){
  this.Reject.click();
  System.out.println("clicked on Reject");
	driver.switchTo().alert().dismiss();
	System.out.println("Alert is displayed");
	
	System.out.println("clicked on cancel");
  }
  
}
catch(Exception e) {
	
	System.out.println("No Such CostSetName Exists");
}
	

  }
	public void generalReject() throws InterruptedException, IOException {
		
		Select Actiondrop=new Select(Action);
		Actiondrop.selectByVisibleText("PendingApproval");
		Select GroupBydrop=new Select(GroupBy);
		GroupBydrop.selectByVisibleText("CostSetName");
		Select Typeofcostdrop=new Select(Typeofcost);
		Typeofcostdrop.selectByVisibleText("General");
		//List<WebElement> list2= Typeofcostdrop.getOptions();
	      // System.out.println("get the size");
	       //System.out.println(list2.size());
	       Select monthdrop=new Select(month);
	       List<WebElement> list1= monthdrop.getOptions();
	       System.out.println("get the size");
	       System.out.println(list1.size());
	       
	      // for(int j=0;j<list2.size();j++) {
	    	   
	      // list2.get(j).click();
	       
	       Thread.sleep(2000);
	       File fexcel=new File("C:\\Screenshot\\BABFAData.xlsx");
			//open it
			FileInputStream fis=new FileInputStream(fexcel);
			//interface of apachepoi so xssf this is to work with xlsx format and hssf is interface to work with xls format
			//This is to open the workbook in the excel file
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			//this is to open the sheet in the excel file
			XSSFSheet sheet=wb.getSheet("Sheet1");
			String Act=sheet.getRow(0).getCell(1).getStringCellValue();
			System.out.println("data in the 0th row and 0th column is" +Act);
	       
		//Typeofcostdrop.selectByVisibleText("General");
       // Select monthdrop=new Select(month);
       /* monthdrop.selectByVisibleText("April");
        this.Go.click();
        System.out.println("Clicked on Go");
        if(this.CostSetName.getText().contains("01781S744_20190422_001")) {
        	this.Reject.click();
        	System.out.println("Clicked on Reject");*/
        
     
       for(int i=0;i<list1.size();i++){
			// System.out.println(list1.get(i).getText());
			 list1.get(i).click();
			 this.Go.click();
			 Thread.sleep(2000);
			// System.out.println(this.CostSetNameSize.size());
			 
			try {
				if(this.Nodatamessage.getText().equalsIgnoreCase("No data")){
					System.out.println("CostSetName Not exists to approve/reject");
					
				}			
				
			}
			
			 
			catch (Exception e)
			{
				this.AcctIdlink.isDisplayed();
				
				//this.CostSetName.getText().contains("01781S744_20190422_001");
				/*this.AcctIdlink.click();
				Thread.sleep(3000);
				this.ClickonAcctcloseIcon.click();
				this.ICAlink.click();
				this.ClickoncloseIcon.click();
				this.Viewlink.click();
				Thread.sleep(3000);
				
				this.ClickonViewCloseIcon.click();;*/
				if(Act!=null) {
					this.Approve.click();
					System.out.println("clicked on Approve");
					break;
				}
				else {
				this.Reject.click();
				System.out.println("clicked on Reject");
				driver.switchTo().alert().dismiss();
				System.out.println("Alert is displayed");
				
				System.out.println("clicked on cancel");
				break;
				}
			}
       }
			 
			 //Boolean ispresent=this.Nodatamessage.getText().contains("No data for this Month"); 
			 
			// if(ispresent==false) {
				// this.CostSetName.getText().contains("01781S744_20190716_004");
				// this.Reject.click();
			// }
			
			 
			
			 
			 
				
				 
			 
			// break;
		 
       }
       public void cancelReject() throws InterruptedException, IOException {
   		
   		
   		//Select GroupBydrop=new Select(GroupBy);
   		//GroupBydrop.selectByVisibleText("CostSetName");
   		Select Typeofcostdrop=new Select(Typeofcost);
   		Typeofcostdrop.selectByVisibleText("Cancel");
   		
   	       Select monthdrop=new Select(month);
   	       List<WebElement> list1= monthdrop.getOptions();
   	       System.out.println("get the size");
   	       System.out.println(list1.size());
   	       
   	       Thread.sleep(2000);
   	    File fexcel=new File("C:\\Screenshot\\BABFAData.xlsx");
		//open it
		FileInputStream fis=new FileInputStream(fexcel);
		//interface of apachepoi so xssf this is to work with xlsx format and hssf is interface to work with xls format
		//This is to open the workbook in the excel file
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		//this is to open the sheet in the excel file
		XSSFSheet sheet=wb.getSheet("Sheet1");
		String Act=sheet.getRow(0).getCell(2).getStringCellValue();
		System.out.println("data in the 0th row and 2nd column is" +Act);
   	       
        
          for(int i=0;i<list1.size();i++){
   			// System.out.println(list1.get(i).getText());
   			 list1.get(i).click();
   			 this.Go.click();
   			 Thread.sleep(2000);
   			// System.out.println(this.CostSetNameSize.size());
   			 
   			try {
   				if(this.Nodatamessagecancel.getText().equalsIgnoreCase("No data")){
   					System.out.println("CostSetName cancel Not exists to approve/reject");
   					
   				}			
   				
   			}
   			
   			 
   			catch (Exception e)
   			{
             this.AcctIdlink.isDisplayed();
				
				
				if(Act!=null) {
					this.Approve.click();
					System.out.println("clicked on Approve");
					break;
				}
				else {
				this.Reject.click();
				System.out.println("clicked on Reject");
				driver.switchTo().alert().dismiss();
				System.out.println("Alert is displayed");
				
				System.out.println("clicked on cancel");
				break;
   			}
          }
          }
   			 
   			 //Boolean ispresent=this.Nodatamessage.getText().contains("No data for this Month"); 
   			 
   			// if(ispresent==false) {
   				// this.CostSetName.getText().contains("01781S744_20190716_004");
   				// this.Reject.click();
   			// }
   			
   			 
   			
   			 
   			 
   				
   				 
   			 
   			// break;
   		 
          }
          public void debitbillReject() throws InterruptedException, IOException {
         		
         		
         		//Select GroupBydrop=new Select(GroupBy);
         		//GroupBydrop.selectByVisibleText("CostSetName");
         		Select Typeofcostdrop=new Select(Typeofcost);
         		Typeofcostdrop.selectByVisibleText("DebitBilling");
         		
         	       Select monthdrop=new Select(month);
         	       List<WebElement> list1= monthdrop.getOptions();
         	       System.out.println("get the size");
         	       System.out.println(list1.size());
         	       
         	       Thread.sleep(2000);
         	      File fexcel=new File("C:\\Screenshot\\BABFAData.xlsx");
         			//open it
         			FileInputStream fis=new FileInputStream(fexcel);
         			//interface of apachepoi so xssf this is to work with xlsx format and hssf is interface to work with xls format
         			//This is to open the workbook in the excel file
         			XSSFWorkbook wb=new XSSFWorkbook(fis);
         			//this is to open the sheet in the excel file
         			XSSFSheet sheet=wb.getSheet("Sheet1");
         			String Act=sheet.getRow(0).getCell(3).getStringCellValue();
         			System.out.println("data in the 0th row and 2nd column is" +Act);
         	       
              
                for(int i=0;i<list1.size();i++){
         			// System.out.println(list1.get(i).getText());
         			 list1.get(i).click();
         			 this.Go.click();
         			 Thread.sleep(2000);
         			// System.out.println(this.CostSetNameSize.size());
         			 
         			try {
         				if(this.Nodatamessage.getText().equalsIgnoreCase("No data")){
         					System.out.println("CostSetName cancel Not exists to approve/reject");
         					
         				}			
         				
         			}
         			
         			 
         			catch (Exception e)
         			{
         				this.AcctIdlink.isDisplayed();
        				
        				
        				if(Act!=null) {
        					this.Approve.click();
        					System.out.println("clicked on Approve");
        					break;
        				}
        				else {
        				this.Reject.click();
        				System.out.println("clicked on Reject");
        				driver.switchTo().alert().dismiss();
        				System.out.println("Alert is displayed");
        				
        				System.out.println("clicked on cancel");
        				break;
         			}
         			 
         			 //Boolean ispresent=this.Nodatamessage.getText().contains("No data for this Month"); 
         			 
         			// if(ispresent==false) {
         				// this.CostSetName.getText().contains("01781S744_20190716_004");
         				// this.Reject.click();
         			// }
         			
         			 
         			
         			 
         			 
         				
         				 
         			 
         			// break;
         		 
                }
             
      			 
			 
		
	}
  
  }
}

