package com.comcast.hrm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.hrm.generic.webdriverutility.WebDriverUtility;

public class CommonElements {
	@FindBy(xpath = "//*[name()='svg' and @data-icon='right-from-bracket']")
	private WebElement logoutBtn;

	@FindBy(xpath = "//div[contains(@class,'toast--success')]")
	private WebElement createdPop;

	@FindBy(xpath = "//div[contains(@class,'Toastify__toast--success')]")
	private WebElement createdPopTextEl;

	@FindBy(xpath="//button[@aria-label='close']")
	private WebElement closeDelPopupEl;
	
	public CommonElements(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public WebElement getCreatedPop() {
		return createdPop;
	}
	
	public WebElement getCreatedPopTextEl() {
		return createdPopTextEl;
	}

	public WebElement getCloseDelPopupEl() {
		return closeDelPopupEl;
	}

	public boolean verify(String projName) throws InterruptedException {
		if (createdPopTextEl.isEnabled()) {
			return true;
		} else {
			return false;
		}
	}

	public void logoutApp(WebDriver driver) {
		WebDriverUtility wdUtility = new WebDriverUtility();
		try {
			wdUtility.waitForElementPresent(driver, createdPop);
			createdPop.click();
		} catch (Exception e) {

		}
		wdUtility.waitForElementToBeclickable(driver, logoutBtn);
		Actions ac = new Actions(driver);
		ac.click(logoutBtn).perform();
	}

}
