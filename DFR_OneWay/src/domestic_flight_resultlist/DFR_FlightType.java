package domestic_flight_resultlist;
import generalFunctions.CommonLocators;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import commonMethods.Flight_Domestic_oneway_Homepage;

public class DFR_FlightType  {
	static CommonLocators cl=new CommonLocators();
	static Flight_Domestic_oneway_Homepage fdh=new Flight_Domestic_oneway_Homepage(cl);
	String ele="flighttype";

	@BeforeMethod
	public void OpenOway()
	{
		cl.OpenBrowser();
	}
	
	@Test
	public void FlightType()
	{
		try {
			cl.DriverSetting("FlightType",ele);
			fdh.FDOSearchDeatails();
			cl.Sleepthread(3000);
			//this method "flight type"
			WebElement flighttype=cl.webElementId("xpath", ".//*[@id='cabin_class']");
				cl.Click("xpath", ".//*[@id='cabin_class']");
				cl.Sleepthread(3000);
				List<WebElement>flighttypelist=flighttype.findElements(By.tagName("input"));
				cl.Sleepthread(3000);
						
			for (int i = 0; i < flighttypelist.size(); i++) {
				System.out.println(flighttypelist.get(i).getAttribute("value"));
				cl.Sleepthread(3000);
				flighttypelist.get(i).click();
				WebElement searchlistpage=cl.webElementId("xpath", ".//*[@id='flight_book']/div[2]");
			 	cl.Sleepthread(3000);
				List<WebElement>ftlist=searchlistpage.findElements(By.className("tab-content"));
				if(!ftlist.isEmpty())
				{
					for (int j = 0; j < ftlist.size(); j++) {
						cl.Sleepthread(3000);
						System.out.println(ftlist.get(j).getText());
					}
				}
				flighttypelist.get(i).click();
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@AfterTest
	public void closeOway()
	{
		cl.CloseBrowser();
	}
	
}
