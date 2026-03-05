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

	@FindBy(xpath = "//div[contains(@class,'toast--success')]/descendant::div[@role='alert']")
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

	public boolean verifyProjCtn(String projName) throws InterruptedException {
		
		System.out.println(".........................");
		System.out.println(projName);
		System.out.println(createdPopTextEl.getText());
		if (createdPopTextEl.isDisplayed()) {
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
