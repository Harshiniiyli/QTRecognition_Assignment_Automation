package PkgForObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OthersPage {

	public WebDriver driver;
	By fromButton= By.xpath("//*[text()='Kudos from me']");
	By tome=By.xpath("//*[text()='Kudos to me']");
	By name1=By.xpath("//*[@id=\"shoutout_to_me\"]/div[1]/div/h5/b[1]");
	By stext1=By.xpath("//*[@id=\"shoutout_to_me\"]/div[1]/div/h5/small[1]");
	By activitybtn= By.linkText("Activity");
	By displaycheck = By.xpath("//div[@class='jumbotron']/h3");
	By todaykudos = By.id("todayCount");
	
	public OthersPage(WebDriver driver) {

		
		this.driver=driver;
		
	}
	
	public WebElement clickfromctn() {
		return driver.findElement(fromButton);
	}
	public WebElement clicktobtn() {
		return driver.findElement(tome);
	}
	
	public WebElement getname1() {
		return driver.findElement(name1);
	}
	
	public WebElement getstext1() {
		return driver.findElement(stext1);
	}
	public WebElement clickActivity() {
		return driver.findElement(activitybtn);
	}
	public WebElement aCheckdisplaymedia() {
		return driver.findElement(displaycheck);
	}
	
	public String countKudos() {
		String count = driver.findElement(todaykudos).getText().split(" ")[0];
		return count;
	}
}
