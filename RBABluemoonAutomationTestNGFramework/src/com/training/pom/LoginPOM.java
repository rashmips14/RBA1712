package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	private WebElement intranetId; 
	
	//@FindBy(id="password")
	//private WebElement password;
	
	@FindBy(xpath="//input[@class='ibm-btn-arrow-pri']")
	private WebElement signInBtn; 
	
	@FindBy(id="accept")
	private WebElement acceptBtn;
	
	public void sendUserName(String intranetId) {
		this.intranetId.clear();
		this.intranetId.sendKeys(intranetId);
	}
	
	/*public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}*/
	
	public void clickSignInBtn() {
		this.signInBtn.click(); 
	}
	public void clickAcceptBtn() {
		this.acceptBtn.click();
	}
}
