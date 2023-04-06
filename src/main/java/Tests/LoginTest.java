package Tests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.LoginPage;
import constants.File_constants;
import file_utils.Properties_Files_Utils;

public class LoginTest extends BaseTest {

/**
 * i declared setDriver,getDriver and removeDriver as static method , so i 
 * can call it directly .these four lines help us to login the salesforce page and close at the end.
 * BaseTest.setDriver();
	WebDriver driver = BaseTest.getDriver();
	driver.get("https://login.salesforce.com");
	BaseTest.removeDriver();
 * @throws IOException 
 * @throws InterruptedException 
 */
/*
 * @BeforeMethod public void setup() { BaseTest.setDriver();
 * moved to BaseTest-Because we are using it each test case begining and end
 * }
 */
	
@Test
public void loginTest() throws IOException, InterruptedException {
	//BaseTest.setDriver();
	WebDriver driver = BaseTest.getDriver();
	driver.get("https://login.salesforce.com");
	LoginPage lp=new LoginPage(driver);
	lp.enterUserName(driver, Properties_Files_Utils.readPropertiesFile(File_constants.CREDENTIALS_FILE_PATH, "dev.username"));
	Thread.sleep(2000);
	lp.enterPassword(driver, Properties_Files_Utils.readPropertiesFile(File_constants.CREDENTIALS_FILE_PATH, "dev.password"));
	Thread.sleep(2000);
	lp.clickLoginButton(driver);
	//BaseTest.removeDriver();
}
/*TestCase\prod_Credential.Properties
 * @Test public void loginTest1() {
 * 
 * WebDriver driver = BaseTest.getDriver(); driver.get("https://google.com"); }
 */
/*@AfterMethod
public void closeBroser() {
	BaseTest.removeDriver();
	moved to BaseTest-Because we are using it each test case begining and end
	*/
}
	
	
	
