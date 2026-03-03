package com.comcast.hrm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void waitForPageToLoad(WebDriver driver,String timeOut)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void waitForElementPresent(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementToBeclickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void maximize(WebDriver driver) 
	{
		driver.manage().window().maximize();
	}
	
	public void switchToNewBrowserTab(WebDriver driver,String partialUrl)
	{
		Set<String> winIds = driver.getWindowHandles();
		for(String id:winIds)
		{
			driver.switchTo().window(id);
			if(driver.getCurrentUrl().contains(partialUrl))
			{
				break;
			}
		}
	}
	
	public void switchToTabBasedOnURL(WebDriver driver,String url)
	{
		Set<String> winIds = driver.getWindowHandles();
		Iterator<String> it = winIds.iterator();
		while(it.hasNext())
		{
			String winId = it.next();
			driver.switchTo().window(winId);
			
			String actualUrl = driver.getCurrentUrl();
			if(actualUrl.equals(url))
			{
				break;
			}
		}
	}
	
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver,String nameOrID)
	{
		driver.switchTo().frame(nameOrID);
	}
	
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	
	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void switchToAlertAndDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void select(WebElement element,String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void select(WebElement element,int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	public void selectByValue(WebElement element,String value)
	{
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	public void clickOn(WebDriver driver ,WebElement element)
	{
		Actions action = new Actions(driver);
		action.click(element).build().perform();
	}
		
	public void mouseMoveOnElement(WebDriver driver,WebElement element)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	public void doubleClick(WebDriver driver,WebElement element)
	{
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
	}
	
//	public void acceptAlert(WebDriver driver)
//	{
//		driver.switchTo().alert().accept();
//	}

}
