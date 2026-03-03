package com.comcast.hrm.createproj.emp.asssignproj;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.hrm.generic.baseclass.BaseClass;
import com.comcast.hrm.generic.file.utility.ExcelUtility;
import com.comcast.hrm.objectrepository.CommonElements;
import com.comcast.hrm.objectrepository.CreateEmployeePage;
import com.comcast.hrm.objectrepository.CreateProjectPage;
import com.comcast.hrm.objectrepository.HomePage;
import com.comcast.hrm.objectrepository.ProjectsPage;

public class CreateProjEmpAssignProToEmp extends BaseClass {
	@Test
	public void createProjAndEmp() throws EncryptedDocumentException, IOException, InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.getProjectsLink().click();
		ExcelUtility excutil = new ExcelUtility();
		String projectName = excutil.getDataFromExcel("proj", 1, 0);
		String managerName = excutil.getDataFromExcel("proj", 1, 1);
		String projectStatus = excutil.getDataFromExcel("proj", 1, 2);
		
		ProjectsPage projp = new ProjectsPage(driver);	
		projp.getCreateProjBtn().click();
		
		CreateProjectPage crprojp = new CreateProjectPage(driver);
		crprojp.createProject(projectName, managerName, driver, projectStatus);
		
		CommonElements ce = new CommonElements(driver);
		boolean projCreated = ce.verifyProjCtn(projectStatus);
		
		Assert.assertEquals(projCreated, false);
		
		hp.getEmployeesLink().click();
		
		
		CreateEmployeePage cremp = new CreateEmployeePage(driver);
		cremp.getCreateEmpLink().click();
		
		cremp.CreateEmpAndAssignProject(driver);
		
	}
}
