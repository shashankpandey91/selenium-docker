package com.newtour.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
	private WebDriver driver;
	private WebDriverWait wait;
	@FindBy(name="firstName")
	WebElement firstName;
	
	@FindBy(name="lastName")
	WebElement lastName;
	
	@FindBy(name="email")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement passwordtxt;
	
	@FindBy(name="confirmPassword")
	WebElement confirmPasswordtxt;
	
	@FindBy(name = "register")
	private WebElement submitbtn;

	public RegistrationPage(WebDriver driver) {
		super();
		this.driver = driver;
		this.wait=new WebDriverWait(driver,30);
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	public void goTo()
	{
		this.driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html#");
		this.wait.until(ExpectedConditions.visibilityOf(firstName));
		
	}
	public void enterUserDetails(String firstName, String lastName)
	{
		this.firstName.sendKeys(firstName);
		this.lastName.sendKeys(lastName);
		
	}
	public void enterUserCredential(String userName, String password)
	{
		this.userName.sendKeys(userName);
		this.passwordtxt.sendKeys(password);
		this.confirmPasswordtxt.sendKeys(password);
	}
	public void submit()
	{
		this.submitbtn.click();
	}

}
