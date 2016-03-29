package domestic_flight_resultlist;

import generalFunctions.CommonLocators;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonMethods.Flight_Domestic_oneway_Homepage;

public class DFR_Price  {
	CommonLocators cl=new CommonLocators();
	Flight_Domestic_oneway_Homepage fdh=new Flight_Domestic_oneway_Homepage(cl);

	WebDriver driver;
	String ele="flightprice";
	Actions action;
	
	@BeforeMethod
	public void Homepage()
	{
		cl.OpenBrowser();
	}

	@Test
	
	public void Price()
	{
		try {
			cl.DriverSetting("FlightPrice", ele);
			
			fdh.FDOSearchDeatails();
			cl.Mouseaction();
				
			//Xpath of the Price
			WebElement slider =cl.webElementId("xpath", ".//*[@id='price-range']/a[1]");
			
			//Xpath of the Flight list search page
			WebElement searchpage=cl.webElementId("xpath", ".//*[@id='flight_book']/div[2]");
			
			//class name od the result list 
		List<WebElement>ftlist= searchpage.findElements(By.className("tab-content"));
		
		//print 1 by 1 
		for (int j = 0; j < ftlist.size(); j++) {
			
			// count and print founded list
			WebElement result=cl.webElementId("xpath", ".//*[@id='flight_book']/div[1]/h4/i");
			System.out.println(result.getText());
			System.out.println("\n\t");			
			System.out.println(ftlist.get(j).getText());
			System.out.println("\n\t");		
			System.out.println("\n----------After Slider Move-------------");
												
			}
				
			for(int i=50;i<55;i++)
			{
				cl.draganddrop(slider, i,i);
				
				if (!ftlist.isEmpty()) {
	
			for (int j = 0; j < ftlist.size(); j++) {
				
				WebElement result=cl.webElementId("xpath", ".//*[@id='flight_book']/div[1]/h4/i");
				System.out.println(result.getText());
				System.out.println("\n\t");
				System.out.println(ftlist.get(j).getText());
				System.out.println("\n\t");
					
													
				}
				}
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	
	@AfterTest
	public void closeapp()
	{
		cl.CloseBrowser();
	}
}

