package commonMethods;

import org.openqa.selenium.WebElement;



import generalFunctions.CommonLocators;
import generalFunctions.Configuration;

public class Flight_Domestic_oneway_Homepage   {
	 CommonLocators gcl;
	
		//create Constructor
		public Flight_Domestic_oneway_Homepage (CommonLocators fccl)
	{
		gcl=fccl;
		
	}
		
	
	public void FDOSearchDeatails()
	{
		gcl.Mouseaction();
		
		//to click From text box
		gcl.webElementId("xpath", ".//*[@id='intorgcity1']");
		gcl.Click("xpath", ".//*[@id='intorgcity1']");
		gcl.MovetoElement("xpath", ".//*[@id='intorgcity1']");
		
		//to select the city
		gcl.webElementId("xpath", ".//*[@id='internationalselect_dom_hot_cities']/div[1]/li/div");
		gcl.Click("xpath", ".//*[@id='internationalselect_dom_hot_cities']/div[1]/li/div");
		gcl.MovetoElement("xpath", ".//*[@id='internationalselect_dom_hot_cities']/div[1]/li/div");
		
		//to click To text box
		gcl.webElementId("xpath", ".//*[@id='intdescity1']");
		gcl.Click("xpath", ".//*[@id='intdescity1']");
		gcl.MovetoElement("xpath", ".//*[@id='intdescity1']");
				
				
		//to select the city
		gcl.webElementId("xpath", ".//*[@id='internationalselect_dom_hot_cities1']/div[3]/li/div");
		gcl.Click("xpath", ".//*[@id='internationalselect_dom_hot_cities1']/div[3]/li/div");
		gcl.MovetoElement("xpath", ".//*[@id='internationalselect_dom_hot_cities1']/div[3]/li/div");
		
		//Select Date
		gcl.webElementId("xpath", ".//*[@id='dom_checkin_date']");
		gcl.Click("xpath", ".//*[@id='dom_checkin_date']");
		
		//select adult
		gcl.webElementId("xpath", ".//*[@id='dom_adults']");
		gcl.Click("xpath", ".//*[@id='dom_adults']");
		gcl.SelectItem("xpath", ".//*[@id='dom_adults']");
		
		//select child
		gcl.webElementId("xpath", ".//*[@id='dom_child']");
		gcl.Click("xpath", ".//*[@id='dom_child']");
		gcl.SelectItem("xpath", ".//*[@id='dom_child']");
		
		//select Infant
		gcl.webElementId("xpath", ".//*[@id='dom_infant']");
		gcl.Click("xpath", ".//*[@id='dom_infant']");
		gcl.SelectItem("xpath", ".//*[@id='dom_infant']");
		
		//Click Search
		gcl.webElementId("xpath", ".//*[@id='search-domesticflights']");
		gcl.Click("xpath", ".//*[@id='search-domesticflights']");
		
		
	}
	
	public void Edit()
	{
		
		gcl.Sleepthread(5000);
		
		WebElement edit=gcl.webElementId("xpath", ".//*[@id='accordion2']/div/h4/a");
		gcl.Sleepthread(3000);
		
		gcl.Click("xpath", ".//*[@id='accordion2']/div/h4/a");
		WebElement updatebtn=gcl.webElementId("xpath", ".//*[@id='search-domesticflights']");
		gcl.Sleepthread(5000);
		
		if(!edit.isSelected())
		{
			System.out.println(updatebtn.getText());
			System.out.println("show the update panel");
			gcl.Sleepthread(5000);
			
		}
		else {
			System.out.println("Error");
		} 
		
	
	}

	
}
