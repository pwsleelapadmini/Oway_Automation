package generalFunctions;


import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CommonLocators  {
	public static WebDriver driver=null;
 	public Actions action;
	public WebElement Element = null;
	public List<WebElement> Elements = null;
	public String path;
	Configuration cg=new Configuration();

	//this method to open Browser
	public void OpenBrowser()
{
		driver=new FirefoxDriver();
		
	driver.get(cg.URL);
	driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}
	public void  DriverSetting(String FloderName, String ele) throws IOException
{
		Date date = new Date() ;
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
		
		String path=(cg.path)+"/"+FloderName+"/"+ele+dateFormat.format(date) +".doc";
	PrintStream myconsole=new PrintStream(new File(path));
		System.setOut(myconsole);
	}
		
	//this method load 8 loacators
	public WebElement webElementId(String identifier,String locator)
	{
		int id=locatorType(identifier);
		WebElement e=null;
		switch (id) 
		{
		case 1:
			e=driver.findElement(By.className(locator));
			break;
		case 2:
			e=driver.findElement(By.cssSelector(locator));
			break;
		case 3:
			e=driver.findElement(By.id(locator));
			break;
		case 4:
			e=driver.findElement(By.linkText(locator));
			break;
		case 5:
			e=driver.findElement(By.name(locator));
			break;
		case 6:
			e=driver.findElement(By.partialLinkText(locator));
			break;
		case 7:
			e=driver.findElement(By.tagName(locator));
			break;
		case 8:
			e=driver.findElement(By.xpath(locator));
			break;

		default:
			System.out.println("locator not found");
			break;
		}
		return e;
	}
		
	//this method to click the locators
	public void Click(String identifier,String locator)
	{
		WebElement e=webElementId(identifier, locator);
		e.click();
		
	}
	
	//this method to perform Mouse Actions
	public void Mouseaction()
	{
		action=new Actions(driver);
	}
	
	//this method to move to element
	public void MovetoElement(String identifier,String locator)
	{
		WebElement e=webElementId(identifier, locator);
		action.moveToElement(e).click().build().perform();
	}
	public void draganddrop(WebElement ele,int i,int i1)
	{
		
			action.dragAndDropBy(ele, i, i1).build().perform();
		
	}
	public void selectsingleitem(String identifier, String locator )
	{
		WebElement e=webElementId(identifier, locator);
		Select esec=new Select(e);
		esec.selectByIndex(0);
		
	}
  	//this method to select ddl
	public void SelectItem(String identifier, String locator )
	{
		WebElement e=webElementId(identifier, locator);
		Select esec=new Select(e);
		
		
	}
		//this method locator Type
	public int locatorType(String identifire)
	{
		int id=1;
		if(identifire=="className")
		{
			id=1;
		}
		else if (identifire=="cssSelector") {
			id=2;
			
		}
		else if (identifire=="id") {
			id=3;
		}
		else if (identifire=="linkText") {
			id=4;
		}
		else if (identifire=="name") {
			id=5;
		}
		else if (identifire=="partialLinkText") {
			id=6;
		}
		else if (identifire=="tagName") {
			id=7;
		}
		else if (identifire=="xpath") {
			id=8;
		}
		else {
			System.out.println("Locator Type Invalid");
		}
		return id;
	}
	public List<WebElement> getElements( String identifier,String locator )
	{
		int ids=locatorTypes(identifier);
		List<WebElement> elements=null;
		switch (ids) 
		{
		case 1:
			elements=driver.findElements(By.className(locator));
			break;
		case 2:
			elements=driver.findElements(By.cssSelector(locator));
			break;
		case 3:
			elements=driver.findElements(By.id(locator));
			break;
		case 4:
			elements=driver.findElements(By.linkText(locator));
			break;
		case 5:
			elements=driver.findElements(By.name(locator));
			break;
		case 6:
			elements=driver.findElements(By.partialLinkText(locator));
			break;
		case 7:
			elements=driver.findElements(By.tagName(locator));
			break;
		case 8:
			elements=driver.findElements(By.xpath(locator));
			break;

		default:
			System.out.println("locator not found");
			break;
		}
		return elements;
	}
	
	public int locatorTypes(String identifire)
	{
		int ids=1;
		if(identifire=="className")
		{
			ids=1;
		}
		else if (identifire=="cssSelector") {
			ids=2;
			
		}
		else if (identifire=="id") {
			ids=3;
		}
		else if (identifire=="linkText") {
			ids=4;
		}
		else if (identifire=="name") {
			ids=5;
		}
		else if (identifire=="partialLinkText") {
			ids=6;
		}
		else if (identifire=="tagName") {
			ids=7;
		}
		else if (identifire=="xpath") {
			ids=8;
		}
		else {
			System.out.println("Locator Type Invalid");
		}
		return ids;
	}
	//thread sleep
	public void Sleepthread(long Sleeptime)
	{
		try {
			Thread.sleep(Sleeptime);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void geturl() throws InterruptedException
	{
		System.out.println(driver.getCurrentUrl());
 		driver.navigate().back();
		Thread.sleep(2000);
		
	}
	
	//popup
	public void PopUp()
	{
		String cwh=driver.getWindowHandle();
		System.out.println("Current Window Handle:"+driver.getWindowHandle());
	
	
	}
	//Sacreen Shots
	public void Screenshots() throws IOException{
		
	File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(srcfile,new File("D:/Owayscreen shorts/.png"));
		
	}
	//this method to close the Browser
			public void CloseBrowser()
			{
				driver.close();
				driver.quit();
			}
	
	
} 
