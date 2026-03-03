package com.comcast.hrm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.hrm.generic.webdriverutility.JavaUtility;
import com.comcast.hrm.generic.webdriverutility.WebDriverUtility;

public class CreateProjectPage {
	@FindBy(name="projectName")
	private WebElement projNameEd;
	
	@FindBy(name="createdBy")
	private WebElement projManagerEd;
	
	@FindBy(xpath = "//label[contains(text(),'Project Sta')]/following-sibling::select")
	private WebElement statusSelect;
	
	@FindBy(xpath = "//input[contains(@value,'Add')]")
	private WebElement addProjectBtn;
	
	public CreateProjectPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getProjNameEd() {
		return projNameEd;
	}

	public WebElement getProjManagerEd() {
		return projManagerEd;
	}

	public WebElement getStatusSelect() {
		return statusSelect;
	}
	
	public WebElement getAddProjectBtn() {
		return addProjectBtn;
	}

	public static String updatedProjectname ;
	public String createProject(String projectName, String managerName ,WebDriver driver, String projStatus) throws InterruptedException
	{
		JavaUtility jUtility = new JavaUtility();
		int randnumber = jUtility.getRandomNumber();
		updatedProjectname = projectName + randnumber; //It is the same for global and local var value.
		projNameEd.sendKeys(updatedProjectname);
		projManagerEd.sendKeys(managerName);
		Actions action = new Actions(driver);
		action.click(statusSelect).perform();
		WebDriverUtility wdUtility = new WebDriverUtility();
		wdUtility.select(statusSelect, projStatus);
		addProjectBtn.click();
		CommonElements ce = new CommonElements(driver);
		ce.verifyProjCtn(projStatus);
		return updatedProjectname;
	}
	public String getFinalProjName()
	{
		return updatedProjectname;
	}
}
