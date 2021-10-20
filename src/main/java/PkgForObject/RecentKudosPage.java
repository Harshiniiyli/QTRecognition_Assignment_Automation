package PkgForObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RecentKudosPage {
	
	public WebDriver driver;
	
	By recentContact=By.id("contact_list");
	By contact=By.xpath("//*[@id='contact_list']/div[3]/div/h5/small/a");
	
	public RecentKudosPage(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	public List<WebElement> sendContacts() {
		return driver.findElements(recentContact);
	}
	public WebElement clickKudos() {
		return driver.findElement(contact);
	}

}
