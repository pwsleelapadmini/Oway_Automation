package domestic_flight_resultlist;


import generalFunctions.CommonLocators;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonMethods.Flight_Domestic_oneway_Homepage;

public class DFR_ClickUpdatebtn  {
	CommonLocators cl=new CommonLocators();
	Flight_Domestic_oneway_Homepage fdh=new Flight_Domestic_oneway_Homepage(cl);


	String ele="clickupdate";
	WebElement Search;
	Select sec;
	 int startoption=1;
	 int endoption;
	 int number;
	
	
	@BeforeMethod
	public void OpenOway()
	{
		cl.OpenBrowser();
	}
	
	
@Test
public void Update()
{
	try {
		cl.DriverSetting("ClickUpdate",ele);
		 			
		fdh.FDOSearchDeatails();
		cl.Sleepthread(5000);
		//click Edit link
		cl.Click("className", "departure-title");
		
		//Select Trip
		WebElement Trip=cl.webElementId("xpath", ".//*[@id='trip_type']");
	
		sec=new Select(Trip);
		sec.selectByIndex(0);
		System.out.println(Trip.getText());
		System.out.println("\n\n");
	
			//Select Departure
			WebElement Departure =cl.webElementId("xpath","//*[@id='def123']");
			List<WebElement>Dlist=Departure.findElements(By.tagName("option"));
			for (int j = 1; j < Dlist.size(); j++) {
				 System.out.println("Departure");
				System.out.println(Dlist.get(j).getText());
				System.out.println("\n\t");
				Dlist.get(j).click();
				if(Dlist.get(j).isEnabled())
				{
					//Select Arrival
					WebElement Arrival=cl.webElementId("xpath",".//*[@id='df123']");
					List<WebElement>Alist=Arrival.findElements(By.tagName("option"));
					for (int k =1; k < Alist.size(); k++) {
						 System.out.println("Arrival");
						System.out.println(Alist.get(k).getText());
						System.out.println("\n\t");
						
						if(Alist.get(k).isEnabled())
						{
							cl.Sleepthread(3000);
							Alist.get(k).click();
							cl.Sleepthread(3000);
							
							//Date
							cl.Click("xpath", ".//*[@id='domestic_checkin_date']");
							
							//Adult
							WebElement adult=cl.webElementId("id", "adults");
							 sec=new Select(adult);
							 Random random=new Random();
							 startoption=1;
							 endoption=sec.getOptions().size();
							 number=startoption+random.nextInt(endoption-startoption);
							 System.out.println(adult.getAttribute("id"));
							 sec.selectByIndex(number);
							 System.out.println(number);
							 System.out.println("\n\t");
							
							//child
							WebElement child=cl.webElementId("id", "childs");
							sec=new Select(child);
							random=new Random();
							startoption=1;
							 endoption=sec.getOptions().size();
							 number=startoption+random.nextInt(endoption-startoption);
							 System.out.println(child.getAttribute("id"));
							 sec.selectByIndex(number);
							 System.out.println(number);
							 System.out.println("\n\t");
							
							cl.SelectItem("id", "infants");
							WebElement infants=cl.webElementId("id", "infants");
							 sec=new Select(infants);
							random=new Random();
							startoption=1;
							 endoption=sec.getOptions().size();
							 number=startoption+random.nextInt(endoption-startoption);
							 System.out.println(infants.getAttribute("id"));
							 sec.selectByIndex(number);
							 System.out.println(number);
							 System.out.println("\n\t");
							
							//Click Update
								cl.Click("xpath",".//*[@id='search-domesticflights']");
								cl.Sleepthread(3000);
								List<WebElement> ftlist = cl.getElements("className", "tab-content");
								System.out.println(ftlist.get(0).getText());
								 System.out.println("\n\t");
								 
								//Click Edit
								cl.Click("className", "departure-title");
								 Search=cl.webElementId("xpath", ".//*[@id='df123']");
							Alist=Search.findElements(By.tagName("option"));
					}
										
					}
					Search=cl.webElementId("xpath","//*[@id='def123']");
					Dlist=Search.findElements(By.tagName("option"));
					
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
