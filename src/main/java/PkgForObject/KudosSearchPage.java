package PkgForObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KudosSearchPage {
	
	public WebDriver driver;
	
	By kspage = By.xpath("//*[text()='Kudos Search']");
	By esend = By.xpath("//input[@name='email_address']");
	By searchbtn = By.xpath("//*[@id='search_panel']/button");
	By fullmedia = By.xpath("//*[@id='shoutout_to_me']/div");
	By fname = By.xpath("//*[@id='shoutout_to_me']/div/div/h5/b");
	By text = By.xpath("//*[@id='shoutout_to_me']/div/div/h5/small");
	By name = By.xpath("(//h5[@class='header-font-size'])[1]");
	
	public KudosSearchPage(WebDriver driver) {
		
		this.driver=driver;
		
	}



	public WebElement getSearchButton() {
		return driver.findElement(kspage);
	}
	
	public WebElement senEmail() {
		
		return driver.findElement(esend);
	}
	
	public WebElement searchBtn() {
		return driver.findElement(searchbtn);
	}
	
	public WebElement getmediaBox() {
		return driver.findElement(fullmedia);
	}
	
	public WebElement getFname() {
		return driver.findElement(fname);
	}
	
	public WebElement getSmallText() {
		return driver.findElement(text);
	}
	public WebElement FUsername() {
		
		return driver.findElement(name);
	}

}
