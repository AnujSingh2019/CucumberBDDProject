package Stepdefinition;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;

import PageObject.LoginPage;
import PageObject.addCustomer;
import PageObject.searchCustomer;
//import io.cucumber.core.logging.Logger;

public class BaseClass {

	public WebDriver driver;
	public LoginPage loginPg;
	public addCustomer addCust;
	public searchCustomer searchCust;
	public static Logger Log;
	
	
	public String generateEmailID()
	{
		return(RandomStringUtils.randomAlphabetic(5));
	}
}
