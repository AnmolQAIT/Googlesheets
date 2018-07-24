package StepDefination;



import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ActionClasses.Hris;
import ActionClasses.Timesheet;
import TestRunner1.SheetsQuickstart;
import cucumber.api.java.en.*;

public class Steps
{
	WebDriver driver;
	Hris h;SheetsQuickstart api;
	Timesheet timesheet;
	
@Given("Login page Url")
public void login_page_Url() throws Throwable
{
 driver=new ChromeDriver();
    driver.get("https://hris.qainfotech.com/login.php");
    h=new Hris(driver);
}

@When("^User enters valid Creddentials$")
public void user_enters_valid_Creddentials()  throws Throwable
{
timesheet=h.Valid_Crendentials("anmolaggarwal","Anmol");
}

@Then("^User gets Login$")
public void user_gets_Login()  throws Throwable
{
	 Assert.assertFalse(timesheet.isloginpage());
	 api.Update("Hris_01");
}

@When("^i enter invalid credentials$")
public void i_enter_invalid_credentials()  throws Throwable {
    h.Invalid_Password("Invalid_USername","Invalid_PAssword");
}

@Then("^Error message should be displayed$")
public void error_message_should_be_displayed()  throws Throwable
{
    Assert.assertTrue(h.isloginpage());
    api.Update("Hris_02");
}

}
