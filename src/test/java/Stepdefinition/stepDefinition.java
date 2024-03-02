package Stepdefinition;

//import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.google.common.base.Verify;

import PageObject.LoginPage;
import PageObject.addCustomer;
import PageObject.searchCustomer;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class stepDefinition extends BaseClass {

	public WebDriver driver;
	public LoginPage loginPg;
	public addCustomer addCust;
	public searchCustomer searchCust;

	@Before
	public void envSetup()
	{
		//initialize logger
		Log=LogManager.getLogger("stepDefinition");
		System.out.println("Setup  Method executeted");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		Log.info("Setup method executed..");
	}

	@Given("user launch Chrome Browser")
	public void user_launch_chrome_browser() {


		loginPg=new LoginPage(driver);
		addCust=new addCustomer(driver);
		searchCust=new searchCustomer(driver);
		Log.info("Chrome Browser Launched..");

	}

	@When("user opens URL {string}")
	public void user_opens_url(String url) {

		driver.get(url);
		Log.info("URL opened..");

	}


	@When("user enters Email as {string} and enters Password as {string}")
	public void user_enters_email_as_and_enters_password_as(String emailadd, String password) {
		loginPg.EnterEmail(emailadd);
		//Thread.sleep(4000);
		loginPg.EnterPassword(password);
		Log.info("Login Page-User entered Username and Password.");
	}


	@And("clicks on Login")
	public void clicks_on_login()  {

		loginPg.LoginBtnClick();
		Log.info("Login Page-Clicked on Login button.");

	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		String actualTitle=driver.getTitle();
		System.out.println("Title of the page is: "+actualTitle);

		if(actualTitle.equals(expectedTitle))
		{
			Log.warn("Title verification after login-Passed");
			Assert.assertTrue(true);//Pass
		}
		else
		{
			Log.warn("Title verification after login-Failed");
			Assert.assertTrue(false);//Fail
		}

	}

	@When("user clicks on Logout link")
	public void user_clicks_on_logout_link() throws InterruptedException {
		Thread.sleep(2000);
		loginPg.LogoutBtnClick();
		Log.info("User clicked on Logout link");

	}

	@And("Close Browser")
	public void close_browser() {

		driver.close();
		//driver.quit();
		Log.info("Browser is closed");
	}

	///////////////////////////////////Add Customer Details////////////////////////////////////////////////////////////////////////////
	@Then("user can view Dashboard")
	public void user_can_view_dashboard() {
		String actualTitle=addCust.getPageTitle();
		String expectedTitle = "Dashboard / nopCommerce administration";

		if(actualTitle.equals(expectedTitle))
		{
			//log.info("user can view dashboard test passed.");
			Assert.assertTrue(true);

		}
		else
		{
			Assert.assertTrue(false);
			//log.warn("user can view dashboard test failed.");

		}

	}

	@When("user clicks on Customer Menu")
	public void user_clicks_on_customer_menu() throws InterruptedException {
		Thread.sleep(3000);
		addCust.clickOnCustomersMenu();
		Log.info("User clicked on Customer Menu");

	}

	@When("clicks on Customer Menu Item")
	public void clicks_on_customer_menu_item() throws InterruptedException {
		Thread.sleep(1000);
		addCust.clickOnCustomersMenuItem();
		Log.info("User clicked on Customer Menu Item");

	}

	@When("Click on Add New button")
	public void click_on_add_new_button() {
		addCust.clickOnAddnew();

	}

	@Then("user can view Add New Customer page")
	public void user_can_view_add_new_customer_page() {

		String actualTitle=addCust.getPageTitle();
		String expectedTitle = "Add a new customer / nopCommerce administration";

		if(actualTitle.equals(expectedTitle))
		{
			//log.info("user can view dashboard test passed.");
			Assert.assertTrue(true);

		}
		else
		{
			Assert.assertTrue(false);
			//log.warn("user can view dashboard test failed.");

		}


	}

	@When("user enters customer info")
	public void user_enters_customer_info() {
		//addCust.enterEmail("Test10@gmail.com");
		addCust.enterEmail(generateEmailID()+ "@gmail.com");
		addCust.enterPassword("Test1");
		addCust.enterFirstName("FName");
		addCust.enterLastName("LName");
		addCust.enterGender("Female");
		addCust.enterDob("6/23/1993");
		addCust.enterCompanyName("Company123");
		addCust.enterAdminContent("Admin Content");
		addCust.enterManagerOfVendor("Vendor 1");

	}

	@When("clicks on Save button")
	public void clicks_on_save_button() {
		addCust.clickOnSave();

	}

	@Then("user can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedMessage) {

		String bodyTagText= driver.findElement(By.tagName("Body")).getText();
		if (bodyTagText.contains(expectedMessage))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}

	///////////////////////////////////Search Existing Customer Details////////////////////////////////////////////////////////////////////////////	

	@When("user enters email address")
	public void user_enters_email_address() throws InterruptedException {
		searchCust.enterEmail("admin@yourStore.com");
		Thread.sleep(4000);
	}

	@When("clicks on Search button")
	public void clicks_on_search_button() {
		searchCust.clickOnSearch();
	}

	@Then("user can view  Customer details in page")
	public void user_can_view_customer_details_in_page() throws InterruptedException {

		/*String ExpectedEmail="victoria_victoria@nopCommerce.com";
	Assert.assertTrue( searchCust.searchCustomerByEmail(ExpectedEmail));*/
		searchCust.verifyEmailSearch("admin@yourStore.com");
	}



	@When("Enter customer FirstName")
	public void enter_customer_first_name() {

		searchCust.enterFirstName("Victoria ");
	}

	@When("Enter customer LastName")
	public void enter_customer_last_name() {

		searchCust.enterLastName("Terces");
	}


	@Then("User should found Name in the Search table")
	public void user_should_found_name_in_the_search_table() {
		String expectedName = "Victoria Terces";


		if( searchCust.searchCustomerByName(expectedName) ==true)
		{
			Assert.assertTrue(true);
		}
		else
			Assert.assertTrue(false);

	}

	@After
	public void teardown(Scenario sc)
	{
		System.out.println("Teardown Method executeted");
		
		if(sc.isFailed()==true)
		{
			//Convert web driver object to TakeScreenshot

			String fileWithPath = "C:\\Users\\talk2\\eclipse-workspace\\CucumberBDDFrameowrk\\screenshot\\failedScreenshot.png";
			TakesScreenshot scrShot =((TakesScreenshot)driver);

			//Call getScreenshotAs method to create image file
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

			//Move image file to new destination
			File DestFile=new File(fileWithPath);

			//Copy file at destination

			try {
				FileUtils.copyFile(SrcFile, DestFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		driver.quit();
	}

}



