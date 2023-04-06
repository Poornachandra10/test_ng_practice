package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author poorn
 *creating a method to get browser and if we like to run it as headless method 
 *give a parmeter as a boolean .
 *then create chrome options object to run it 
 *if (boolean, headless )value didnot passed then it wont run in headless method. 
 */
public class BaseTest {
	private static ThreadLocal<WebDriver> threadLocalDriver=new ThreadLocal<WebDriver>();
public static void setDriver() {
	WebDriver driver= BaseTest.getBrowserType("chrome", false);
	threadLocalDriver.set(driver);
}
@BeforeMethod
public void setup() {
	BaseTest.setDriver();
	
}
/*
 * @AfterMethod public void closeBroser() { BaseTest.removeDriver(); }
 */
	
public static WebDriver getDriver() {
	return threadLocalDriver.get();	
}
public static void removeDriver() {
BaseTest.getDriver().close();
	threadLocalDriver.remove();
}
	public static WebDriver getBrowserType(String browserName, boolean headless ) {
	
	WebDriver driver=null;   
	String browserType =browserName.toLowerCase();
	switch (browserType) {
	case "chrome":
		WebDriverManager.chromedriver().setup();
		if (headless) {
			ChromeOptions co =new ChromeOptions();
			co.addArguments("--headless");
			driver=new ChromeDriver(co);
		}else {
		driver=new ChromeDriver();
		} 
		break;
	case "safari":
		driver=new ChromeDriver();
		if (headless) {
			ChromeOptions co =new ChromeOptions();
			co.addArguments("--headless");
			driver=new ChromeDriver(co);
		}else {
		driver=new ChromeDriver();
		} 
		break;
	case "firefox":
		WebDriverManager.firefoxdriver().setup();
		if (headless) {
			ChromeOptions co =new ChromeOptions();
			co.addArguments("--headless");
			driver=new ChromeDriver(co);
		}else {
		driver=new ChromeDriver();
		} 
		
		break;
		default:
			System.out.println("Provide input either as Chrome or Safari");
			break;
			
	}
	return driver;

}
}