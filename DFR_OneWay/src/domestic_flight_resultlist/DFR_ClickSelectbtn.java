package domestic_flight_resultlist;
import generalFunctions.CommonLocators;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import commonMethods.Flight_Domestic_oneway_Homepage;

public class DFR_ClickSelectbtn {
	CommonLocators cl=new CommonLocators();
	Flight_Domestic_oneway_Homepage fdh=new Flight_Domestic_oneway_Homepage(cl);

	 WebDriver driver;
	String ele="clickselect";
	
	@BeforeMethod
	public void OpenOway()
	{
		cl.OpenBrowser();
}
	
	@Test
	public void SelectBtn()
	{
		try {
			cl.DriverSetting("ClickSelect",ele);	 			
			fdh.FDOSearchDeatails();
			cl.Sleepthread(3000);
			WebElement result=cl.webElementId( "xpath",".//*[@id='flight_book']/div[1]/h4/i");
         	System.out.println(result.getText());
         	
          	List<WebElement> FlightresultPage=cl.getElements("id", "flight_book_btn");
			for (int i = 0; i < FlightresultPage.size(); i++) {
				if(FlightresultPage.get(i).isDisplayed())
				{
					System.out.println(FlightresultPage.get(i).getText());
					FlightresultPage.get(i).click();
					cl.geturl();
					FlightresultPage=cl.getElements("id", "flight_book_btn");
			}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	@AfterTest
	public void Close()
	{
		cl.CloseBrowser();
	}

}
