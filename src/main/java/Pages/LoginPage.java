package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
public LoginPage(WebDriver driver) {
	PageFactory.initElements(driver, this ); 
}
@FindBy(id="username")
public WebElement username;
@FindBy(id="password")
public WebElement password;
@FindBy(id="Login")
public WebElement Login; 


public void enterUserName(WebDriver driver, String userName) {

if (username.isDisplayed()){
	username.clear();
	username.sendKeys(userName);
}
else {
	System.out.println("User name element is not visible");
}
}
public void enterPassword(WebDriver driver, String passWord) {

if (password.isDisplayed()){
	password.clear();
	password.sendKeys(passWord);
}else {
	System.out.println("password element is not visible");
}
}
public void clickLoginButton(WebDriver driver) {

if (Login.isDisplayed()) {
	Login.click();
}else {
	System.out.println("Login element is not visible");
}
}
}