package com.comcast.hrm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(xpath = "//a[text()='Projects']")
	private WebElement projectsLink;
	
	@FindBy(xpath = "//a[text()='Employees']")
	private WebElement employeesLink;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getProjectsLink() {
		return projectsLink;
	}

	public WebElement getEmployeesLink() {
		return employeesLink;
	}

}
