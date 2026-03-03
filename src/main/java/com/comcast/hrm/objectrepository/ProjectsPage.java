package com.comcast.hrm.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.hrm.generic.webdriverutility.WebDriverUtility;

public class ProjectsPage {
	@FindBy(xpath = "//span[text()='Create Project']/preceding-sibling::i")
	private WebElement createProjBtn;

	@FindBy(xpath = "//h2[contains(text(),'List of')]/parent::div/following-sibling::div//select[@class='form-control']")
	private WebElement searchBySelectEl;

	@FindBy(xpath = "//input[@placeholder='Search by Project Name']")
	private WebElement searchInpEl;

	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement delBtn;

	public ProjectsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateProjBtn() {
		return createProjBtn;
	}

	public WebElement getSearchBySelectEl() {
		return searchBySelectEl;
	}

	public WebElement getSearchInpEl() {
		return searchInpEl;
	}

	public WebElement getDelBtn() {
		return delBtn;
	}

	public void deleteTheProj(WebDriver driver, String searchBy, String projName) {
		WebDriverUtility wdUtil = new WebDriverUtility();
		searchBySelectEl.click();
		wdUtil.select(searchBySelectEl, searchBy);
		searchInpEl.sendKeys(projName);
		driver.findElement(By.xpath("//td[text()='" + projName + "']/following-sibling::td//a[@class='delete']"))
				.click();
		delBtn.click();
	}

}