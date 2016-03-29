package domestic_flight_resultlist;


import generalFunctions.CommonLocators;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonMethods.Flight_Domestic_oneway_Homepage;

public class DFR_FlightTimes {
	CommonLocators cl=new CommonLocators();
	Flight_Domestic_oneway_Homepage fdh=new Flight_Domestic_oneway_Homepage(cl);
    String ele="flighttimes";
	
@BeforeMethod
	public void OpenOway() {
		
	cl.OpenBrowser();
	
	}

	@Test
	public void FlightTime() {

		try {
			cl.DriverSetting("FlightTimes", ele);		
			fdh.FDOSearchDeatails();
			cl.Sleepthread(2000);

			WebElement flighttime = cl.webElementId("xpath",".//*[@id='deptTime']");

			List<WebElement> flighttimelist = flighttime.findElements(By.tagName("input"));

			for (int i = 0; i < flighttimelist.size(); i++) {

				cl.Sleepthread(2000);

				flighttimelist.get(i).click();

				WebElement searchlistpage = cl.webElementId("xpath",".//*[@id='flight_book']/div[2]");
				WebElement result = cl.webElementId("xpath",".//*[@id='flight_book']/div[1]/h4/i");
				List<WebElement> ftlist = searchlistpage.findElements(By.className("tab-content"));
			
				if (!ftlist.isEmpty()) {
					for (int j = 0; j < ftlist.size(); j++) {

						System.out.println(result.getText());
						System.out.println("\n\t");
						System.out.println(ftlist.get(j).getText());
						System.out.println("\n\t");
			}
				}
				flighttimelist.get(i).click();

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
