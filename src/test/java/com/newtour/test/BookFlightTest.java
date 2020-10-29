package com.newtour.test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.newtour.pages.FindFlightPage;
import com.newtour.pages.FlightConfirmationPage;
import com.newtour.pages.FlightDetailsPage;
import com.newtour.pages.RegistrationConfirmationPage;
import com.newtour.pages.RegistrationPage;

import test.BaseTest;

public class BookFlightTest extends BaseTest {

	private String noOfPassengers;
	private String expectedPrice;
	@Parameters({"noOfPassengers","expectedPrice"})
	@BeforeTest
	public void setupParameter(String noOfPassengers,String expectedPrice)
	{
		this.noOfPassengers=noOfPassengers;
		this.expectedPrice=expectedPrice;
		
	}
	
	@Test
	public void registrationPage()
	{
		RegistrationPage registrationPage= new RegistrationPage(driver);
		registrationPage.goTo();
		registrationPage.enterUserDetails("selenium", "docker");
		registrationPage.enterUserCredential("selenium", "docker");
		registrationPage.submit();
	}
	@Test(dependsOnMethods ="registrationPage" )
	public void registrationConfirmationPage()
	{
		RegistrationConfirmationPage registrationConfirmationPage= new RegistrationConfirmationPage(driver);
		registrationConfirmationPage.goToFlightDetailsPage();
	}
     @Test(dependsOnMethods = "registrationConfirmationPage")
	public void flightDetailsPage()
	{
    	 FlightDetailsPage flightDetailsPage=new FlightDetailsPage(driver);
    	 flightDetailsPage.selectPassengers(noOfPassengers);
    	 flightDetailsPage.goToFindFlightsPage();
		
	}
     @Test(dependsOnMethods = "flightDetailsPage")
     public void findFlightPage()
     {
    	 FindFlightPage findFlightPage= new FindFlightPage(driver);
    	 findFlightPage.submitFindFlightPage();
    	 findFlightPage.goToFlightConfirmationPage();
     }
     @Test(dependsOnMethods = "findFlightPage" )
     public void flightConfirmationPage()
     {
    	 FlightConfirmationPage flightConfirmationPage= new FlightConfirmationPage(driver);
    	String actualPrice= flightConfirmationPage.getPrice();
    	Assert.assertEquals(actualPrice, expectedPrice);
     }
    
}
