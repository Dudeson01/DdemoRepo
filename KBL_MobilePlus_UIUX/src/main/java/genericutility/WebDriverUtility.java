package genericutility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {
	
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void rightClick(WebDriver driver) {
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	
	public void mouseHover(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement dest) {
		Actions act=new Actions(driver);
		act.dragAndDrop(src, dest).perform();
	}
	
	public void doubleClick(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	public void selectByIndex(WebElement element, int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	
	public void selectByValue(WebElement element, String value) {
		Select s=new Select(element);
		s.selectByValue(value);
	}
	
	public void selectByVisibleText(WebElement element, String text) {
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	public void switchToFrame(WebDriver driver, WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void switchToAlertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void getPhoto(WebDriver driver) throws IOException {
		JavaUtility jUtil=new JavaUtility();
		TakesScreenshot ts=(TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest =new File("./Screenshots/"+jUtil.getSystemTime()+".png");
		FileHandler.copy(temp, dest);
	} 
}
