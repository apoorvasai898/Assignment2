package com.comcast.hrm.objectrepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.hrm.generic.file.utility.ExcelUtility;
import com.comcast.hrm.generic.webdriverutility.JavaUtility;
import com.comcast.hrm.generic.webdriverutility.WebDriverUtility;

public class CreateEmployeePage {
	@FindBy(xpath = "//span[text()='Add New Employee']")
	private WebElement createEmpLink;
	
	@FindBy(xpath = "//label[contains(text(),'Name*')]/following-sibling::input")
	private WebElement empNameEd;
	
	@FindBy(xpath = "//label[text()='Email*']/following-sibling::input")
	private WebElement empemailEd;
	
	@FindBy(xpath = "//label[text()='Phone*']/following-sibling::input")
	private WebElement empphoneEd;
	
	@FindBy(xpath = "//label[contains(text(),'Username')]/following-sibling::input")
	private WebElement empUNEd;
	
	@FindBy(xpath = "//label[contains(text(),'Desig')]/following-sibling::input")
	private WebElement empDesgEd;
	
	@FindBy(xpath = "//label[contains(text(),'Experience')]/following-sibling::input[@type='text']")
	private WebElement empExpEd;
	
	@FindBy(xpath = "//label[contains(text(),'Project')]/following-sibling::select")
	private WebElement projectSlEl;
	
	@FindBy(xpath = "//input[@value='Add']")
	private WebElement addBtn;
	
	public CreateEmployeePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateEmpLink() {
		return createEmpLink;
	}
	
	public WebElement getEmpNameEd() {
		return empNameEd;
	}

	public WebElement getEmpemailEd() {
		return empemailEd;
	}

	public WebElement getEmpphoneEd() {
		return empphoneEd;
	}

	public WebElement getEmpUNEd() {
		return empUNEd;
	}

	public WebElement getEmpDesgEd() {
		return empDesgEd;
	}

	public WebElement getEmpExpEd() {
		return empExpEd;
	}

	public WebElement getProjectSlEl() {
		return projectSlEl;
	}

	public WebElement getAddBtn() {
		return addBtn;
	}

	public void CreateEmpAndAssignProject(WebDriver driver) throws EncryptedDocumentException, IOException
	{
		ExcelUtility exutility = new ExcelUtility();
		JavaUtility jUtility = new JavaUtility();
		int randomNumber = jUtility.getRandomNumber();
		String empName = exutility.getDataFromExcel("emp", 1, 0) + randomNumber;
		String empEmail = exutility.getDataFromExcel("emp", 1, 1);
		String empPhone = exutility.getDataFromExcel("emp", 1, 2);
		String empUN = empName;
		
		String empDesg = exutility.getDataFromExcel("emp", 1, 4);
		String empExp = exutility.getDataFromExcel("emp", 1, 5);
//		int empExpInt =Integer.parseInt(empDesg);
		
		empNameEd.sendKeys(empName);
		empemailEd.sendKeys(empEmail);
		empphoneEd.sendKeys(empPhone);
		empUNEd.sendKeys(empUN);
		empDesgEd.sendKeys(empDesg);
		empExpEd.sendKeys(empExp);
		
		Actions a = new Actions(driver);
		a.click(projectSlEl).perform();
		
		CreateProjectPage crpPage = new CreateProjectPage(driver);
		
		String updProjName = crpPage.getFinalProjName();
		WebDriverUtility wdUtil = new WebDriverUtility();
		wdUtil.select(projectSlEl, updProjName);
		
		addBtn.click();
	}

}
