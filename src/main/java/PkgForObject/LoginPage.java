package PkgForObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	
	By username = By.xpath("//input[@placeholder='Enter Username']");
	By passwd = By.xpath("//input[@placeholder='Enter Password']");
	By loginbutton = By.xpath("//button[@type='submit']");
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
		
	public WebElement getusername() {
		return driver.findElement(username);
	}
	
	public WebElement getpassword() {
		return driver.findElement(passwd);
	}
	
	public WebElement submit() {
		return driver.findElement(loginbutton);
	}
	
	public String title() {
		return driver.getTitle();
	}
}
