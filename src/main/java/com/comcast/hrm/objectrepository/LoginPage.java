package com.comcast.hrm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(id="username")
	private WebElement usernameEd;
	
	@FindBy(id="inputPassword")
	private WebElement passwordEd;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement signInBtn;
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsernameEd() {
		return usernameEd;
	}

	public WebElement getPasswordEd() {
		return passwordEd;
	}

	public WebElement getSignInBtn() {
		return signInBtn;
	}
	
	public void signInToApp(String username, String password)
	{
		usernameEd.sendKeys(username);
		passwordEd.sendKeys(password);
		signInBtn.click();
	}


}
