package PkgForObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SendKudosPage {

	public WebDriver driver;
	
	By kudosSendBtn = By.xpath("//*[@id='navbarCollapse']/div[2]/a");
	By emailid = By.id("email_address");
	By senEmail =By.xpath("//input[@id='email_address']");
	By trophy = By.xpath("//*[@id='trophy_list']/div");
	By sendKey = By.xpath("//div[@class='modal-footer'] //button[@class='btn btn-primary']");
	By close =By.xpath("//*[@id='shoutout_form']/div[1]/button");
	By comment = By.id("comment");
	
public SendKudosPage(WebDriver driver) {

		
		this.driver=driver;
		
	}

public WebElement getKudosSend() {
	return driver.findElement(kudosSendBtn);
}
	public WebElement enterEmail() {
		return driver.findElement(emailid);
	}
	
	public WebElement enterfullemail() {
		return driver.findElement(senEmail);
	}
	public List<WebElement> selecttrophy() {
		return driver.findElements(trophy);
	}
	
	public WebElement clicksend() {
		return driver.findElement(sendKey);
	}
	
	public WebElement sendcomment() {
		return driver.findElement(comment);
	}
	public  WebElement clickClose() {
		return driver.findElement(close);
	}
	
}
