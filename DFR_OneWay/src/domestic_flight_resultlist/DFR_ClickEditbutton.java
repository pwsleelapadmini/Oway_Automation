package domestic_flight_resultlist;

import generalFunctions.CommonLocators;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonMethods.Flight_Domestic_oneway_Homepage;

public class DFR_ClickEditbutton {
	CommonLocators cl=new CommonLocators();
	Flight_Domestic_oneway_Homepage fdh=new Flight_Domestic_oneway_Homepage(cl);
String ele="clickedit";
	@BeforeMethod
	public void OpenOway()
	{
		cl.OpenBrowser();
	}
	
	@Test
	public void Edit()
	{
		try {
			cl.DriverSetting("ClickEdit", ele);
			
			fdh.FDOSearchDeatails();
			cl.Sleepthread(2000);
			
			WebElement edit=cl.webElementId("xpath", ".//*[@id='accordion2']/div/h4/a");
			cl.Sleepthread(2000);
			
			cl.Click("xpath", ".//*[@id='accordion2']/div/h4/a");
			WebElement updatebtn=cl.webElementId("xpath", ".//*[@id='search-domesticflights']");
			cl.Sleepthread(2000);
			
			if(!edit.isSelected())
			{
				System.out.println(updatebtn.getText());
				System.out.println("show the update panel");
				cl.Sleepthread(2000);
				cl.Screenshots();
						}
			else {
				System.out.println("Error");
				
			} 
		}
			
		 catch (Exception e) {
			// TODO: handle exception
		}

}

@AfterTest
public void CloseOway()
{
	cl.CloseBrowser();
}

}
