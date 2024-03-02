package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}


	@FindBy(id = "Email")
	WebElement email;

	@FindBy(id = "Password")
	WebElement password;

	@FindBy(xpath = "//button[@class='button-1 login-button']")
	WebElement LoginBtn;
	
	@FindBy(linkText="Logout")
	WebElement Logout;

	public void EnterEmail(String emailId)
	{
		email.clear();
		
		email.sendKeys(emailId);
		
	}

	public void EnterPassword(String Pwd) 
	{
		password.clear();
		//Thread.sleep(5000);
		password.sendKeys(Pwd);
	}

	public void LoginBtnClick()
	{
		
		LoginBtn.click();
	}

	public void LogoutBtnClick()
	{
		//Thread.sleep(5000);
		Logout.click();
	}

	}