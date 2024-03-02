package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchCustomer {
	
	WebDriver ldriver;
	
	public searchCustomer(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}

	//Find the locators of the objects on page
		@FindBy(xpath = "//input[@id='SearchEmail']")
		WebElement emailaddressfield;
	
		@FindBy(xpath = "//button[@id='search-customers']")
		WebElement SearchBtn;
		@FindBy(xpath="//table[@role='grid']")
		WebElement searchResult;

		@FindBy(xpath="//table[@id='customers-grid']//tbody/tr")
		List<WebElement> tableRows;
		
		@FindBy(xpath="//*[@id=\"customers-grid\"]/tbody/tr/td[2]")
		WebElement emailActualText;
		
		@FindBy(id="SearchFirstName")
		WebElement firstName;

		@FindBy(id="SearchLastName")
		WebElement lastName;

		

		/*@FindBy(xpath="//table[@id='customers-grid']//tbody/tr[1]/td")
		List<WebElement> tableColumns;*/
	
		public void enterEmail(String email)
		{
			emailaddressfield.sendKeys(email);
		}
	
	
		public void clickOnSearch()
		{
			SearchBtn.click();
		}
		
		public boolean searchCustomerByEmail(String email) 
		{
			boolean found = false;

			//total no. of rows in a grid
			int ttlRows = tableRows.size();

           
			//total no. of columns
			//int ttlColumns = tableColumns.size();

			for(int i=1;i<=ttlRows;i++)//to iterate all the rows of the grid
			{
				System.out.println("Searching row:" +i );

				WebElement webElementEmail = ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i  + "]/td[2]"));
				String actualEmailAdd = webElementEmail.getText();
				System.out.println(actualEmailAdd);

				if(actualEmailAdd.equals(email))
				{
					found=true;
				}

			}
			return found;
		}

		
		public void verifyEmailSearch(String Email) throws InterruptedException
		{
			Thread.sleep(3000);
			String emailText=emailActualText.getText();
			//return emailText;
			
	
		}
		
		
///////////////////////search customer by name///////////////////////////////
//action method to enter first name
public void enterFirstName(String firstNameText)
{
firstName.sendKeys(firstNameText);
}

//action method to enter last name
public void enterLastName(String LastNameText)
{
lastName.sendKeys(LastNameText);
}

public boolean searchCustomerByName(String name)
{
boolean found = false;

//total no. of rows in a grid
int ttlRows = tableRows.size();


for(int i=1;i<=ttlRows;i++)//to iterate all the rows of the grid
{
WebElement webElementName = ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i  + "]/td[3]"));
String actualName = webElementName.getText();

if(actualName.equals(name))
{
	found=true;
	break;
}


}

return found;

}
}