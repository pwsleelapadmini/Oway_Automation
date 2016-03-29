package domestic_flight_resultlist;


import generalFunctions.CommonLocators;
import generalFunctions.Configuration;


import java.util.List;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonMethods.Flight_Domestic_oneway_Homepage;

public class DFR_FlightStops {
	static CommonLocators cl=new CommonLocators();
static Flight_Domestic_oneway_Homepage fdh=new Flight_Domestic_oneway_Homepage(cl);
	String ele="flightstop";

	@BeforeMethod
	public void OpenOway() {
		cl.OpenBrowser();
	}

	@Test
	public void FlightStops() {
	
		try {
			
			cl.DriverSetting("FlightStop", ele);
			
			fdh.FDOSearchDeatails();
			cl.Sleepthread(2000);

			WebElement flightstop = cl.webElementId("xpath","//*[@id='flight-stops-filter']/div");

			List<WebElement> flightstoplist = flightstop.findElements(By.tagName("input"));

			for (int i = 0; i < flightstoplist.size(); i++) {
				cl.Sleepthread(2000);
				flightstoplist.get(i).click();

				WebElement searchlistpage = cl.webElementId("xpath","//*[@id='flight_book']/div[2]");
				WebElement result = cl.webElementId("xpath","//*[@id='flight_book']/div[1]/h4/i");
				List<WebElement> ftlist = searchlistpage.findElements(By.className("tab-content"));

				if (!ftlist.isEmpty()) {
					for (int j = 0; j < ftlist.size(); j++) {
						System.out.println(result.getText());
						System.out.println("\n\t");
						System.out.println(ftlist.get(j).getText());
						System.out.println("\n\t");
					}
				}
				flightstoplist.get(i).click();
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
