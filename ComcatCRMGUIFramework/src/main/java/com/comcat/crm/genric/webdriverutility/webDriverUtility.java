package com.comcat.crm.genric.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class webDriverUtility {
	public void waitforPageLoad(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void waitForElementPrasent(WebDriver driver,WebElement element) {
	WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOf(element));
	
}
	public void switchToTabOnURL(WebDriver driver,String partialUrl) {
		Set<String> set=driver.getWindowHandles();
		Iterator<String> it =set.iterator();
		while(it.hasNext()) {
		String windowID = it.next();
			driver.switchTo().window(windowID);
			String actUrl=driver.getCurrentUrl();
			if(actUrl.contains(partialUrl)) {
				break;
			}
	}
	}
		public void switchToTabOnTitle(WebDriver driver,String partialTitle) {
			Set<String> set=driver.getWindowHandles();
			Iterator<String> it =set.iterator();
			while(it.hasNext()) {
			String windowID = it.next();
				driver.switchTo().window(windowID);
				String actUrl=driver.getCurrentUrl();
				if(actUrl.contains(partialTitle)) {
					break;
				}
			}  
		}

public void switchToFrame(WebDriver driver,int index) {
	driver.switchTo().frame(index);
}
public void switchToFrame(WebDriver driver, String nameID) {
	driver.switchTo().frame(nameID);
}	
public void switchToFrame(WebDriver driver, WebElement element) {
	driver.switchTo().frame(element);
}
public void switchtoAlertAndAccept(WebDriver driver){
	driver.switchTo().alert().accept();
}
public void switchtoAlertAndCancel(WebDriver driver){
	driver.switchTo().alert().dismiss();
}
public void selectBasedOnText(WebElement element,String text)
{
	Select sel= new Select(element);
	sel.selectByVisibleText(text);
}

public void selectBasedOnValue(WebElement element,String value)
{
	Select sel= new Select(element);
	sel.selectByValue(value);
}

public void selectBasedOnIndex(WebElement element,int Index)
{
	Select sel= new Select(element);
	sel.selectByIndex(Index);

}
public void mousemovement(WebDriver driver,WebElement element) {
	Actions act=new Actions(driver);
	act.moveToElement(element).perform();

}
public void doubleClick(WebDriver driver,WebElement element) {
	Actions act=new Actions(driver);
	act.doubleClick(element).perform();	
	

}			
}

