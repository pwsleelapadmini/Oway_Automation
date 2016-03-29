package domestic_flight_resultlist;

import generalFunctions.CommonLocators;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonMethods.Flight_Domestic_oneway_Homepage;

public class DFR_PriceMatrix  {
	CommonLocators cl=new CommonLocators();
	Flight_Domestic_oneway_Homepage fdh=new Flight_Domestic_oneway_Homepage(cl);

	String ele="pricematrix";

	@BeforeMethod
	public void OpenOway()
	{
		cl.OpenBrowser();
		
	}
	
	@Test
	public void PriceMatrix()
	{
		try {
			
			cl.DriverSetting("FlightPriceMatrix", ele);
			fdh.FDOSearchDeatails();
			cl.Sleepthread(3000);
			
		WebElement result=cl.webElementId("xpath",".//*[@id='flight_book']/div[1]/h4/i");
//        	System.out.println(result.getText());
         	WebElement filghtbook=cl.webElementId("xpath",".//*[@id='flight_book']/div[2]/div[2]/div/div/div");
			List<WebElement> matrixlist= filghtbook.findElements(By.tagName("input"));
			for (int i = 0; i < matrixlist.size(); i++) {
				System.out.println(matrixlist.get(i).getText());
         		matrixlist.get(i).click();
         		List<WebElement> ftlist = cl.getElements("className","tab-content");
         			for (int j = 0; j < ftlist.size(); j++) {
         			System.out.println(result.getText());
					System.out.println(ftlist.get(j).getText());
					System.out.println("\n\t");
					
				}
         		matrixlist.get(i).click();
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	@AfterTest
	public void CloseOway() {
		cl.CloseBrowser();
	}
	

}
