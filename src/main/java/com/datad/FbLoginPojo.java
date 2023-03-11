package com.datad;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FbLoginPojo extends BaseClass {
	BaseClass b = new BaseClass();
	
	public FbLoginPojo() {
		PageFactory.initElements(driver, this.b);
	}
	
	
	@FindBy(id="email")
	private WebElement userId;
	
	@FindBy(id="pass")
	private WebElement password;
	
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginbtn;


	public WebElement getUserId() {
		return userId;
	}


	public WebElement getPassword() {
		return password;
	}


	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
