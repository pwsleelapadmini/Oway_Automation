package domestic_flight_resultlist;

import generalFunctions.CommonLocators;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonMethods.Flight_Domestic_oneway_Homepage;



public class DFR_SortingFlightList {
	static CommonLocators cl=new CommonLocators();
	static Flight_Domestic_oneway_Homepage fdh=new Flight_Domestic_oneway_Homepage(cl);
	
	Actions action;
	List<WebElement> ftlist;
	WebDriver driver;
	String ele="flightsorting";
	
	
	@BeforeMethod
	public void openapp()
	{
		cl.OpenBrowser();
	}
	
	@Test
	public void Sorting() throws IOException
	{
		cl.DriverSetting("FlightSorting", ele);
		fdh.FDOSearchDeatails();
		cl.Sleepthread(5000);
		WebElement searchlistpage = cl.webElementId("xpath","//*[@id='flight_book']/div[2]");
		WebElement SortBy=cl.webElementId("className", "tab-container");
		List<WebElement>triangle=SortBy.findElements(By.className("triangle_down"));
		for (int i = 0; i < triangle.size(); i++)
		{
			System.out.println(triangle.size());
     		
     		switch (i) {
			case 0:
				System.out.println("Low to High Depats List");
			System.out.println("\n");
				cl.MovetoElement("xpath", ".//*[@id='sort_depart1-l']/i");
				 ftlist = searchlistpage.findElements(By.className("tab-content"));
            	System.out.println(ftlist.get(0).getText());
            System.out.println("\n");
            	System.out.println(" High to Low Depats List");
            System.out.println("\n");
            	cl.MovetoElement("xpath", ".//*[@id='sort_depart1-l']/i");
            	System.out.println(ftlist.get(0).getText());
            System.out.println("\n");
				break;
			case 1:
				System.out.println("Low to High Arrival List");
			System.out.println("\n");
				cl.MovetoElement("xpath", ".//*[@id='sort_arrival1-l']/i");
				ftlist = searchlistpage.findElements(By.className("tab-content"));
            	System.out.println(ftlist.get(0).getText());
            System.out.println("\n");
            	System.out.println(" High to Low Arrival List");
            System.out.println("\n");
            	cl.MovetoElement("xpath", ".//*[@id='sort_arrival1-l']/i");
            	System.out.println(ftlist.get(0).getText());
            System.out.println("\n");
            	break;
			case 2:
				System.out.println("Low to High Duration List");
			System.out.println("\n");
				cl.MovetoElement("xpath", ".//*[@id='sort_duration1-l']/i");
            	 ftlist = searchlistpage.findElements(By.className("tab-content"));
            	System.out.println(ftlist.get(0).getText());
            System.out.println("\n");
            	System.out.println(" High to Low Duration List");
            System.out.println("\n");
            	cl.MovetoElement("xpath", ".//*[@id='sort_duration1-l']/i");
            	System.out.println(ftlist.get(0).getText());
            System.out.println("\n");
            	break;
			case 3:
				System.out.println("Low to High Class List");
			System.out.println("\n");
				cl.MovetoElement("xpath", ".//*[@id='sort_class1-l']/i");
            	 ftlist = searchlistpage.findElements(By.className("tab-content"));
            	System.out.println(ftlist.get(0).getText());
            System.out.println("\n");
            	System.out.println(" High to Low Class List");
            System.out.println("\n");
            	cl.MovetoElement("xpath", ".//*[@id='sort_class1-l']/i");
            	System.out.println(ftlist.get(0).getText());
            System.out.println("\n");
            	break;
			case 4:
				System.out.println("Low to High Price List");
			System.out.println("\n");
				cl.MovetoElement("xpath", ".//*[@id='sort_price1-l']/i");
            	 ftlist = searchlistpage.findElements(By.className("tab-content"));
            	System.out.println(ftlist.get(0).getText());
            	System.out.println("\n");
            	System.out.println(" High to Low Price List");
            	System.out.println("\n");
            	cl.MovetoElement("xpath", ".//*[@id='sort_price1-l']/i");
            	System.out.println(ftlist.get(0).getText());
            	System.out.println("\n");
            	break;
			default:
				System.out.println(" not found");
				break;
			}
   	
	
		}
	}

}
