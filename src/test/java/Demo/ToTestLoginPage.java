package Demo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import PkgForObject.LoginPage;


import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BasicPackage.BaseMain;

public class ToTestLoginPage extends BaseMain {

	/*
	 * To initialize the browser driver
	 * 
	 */
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializingDRiver();
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

	}

	/*
	 * Test case to login with wrong username or password
	 * Test case to check the colors of the page
	 */
	@Test
	public void testInvalid() throws InterruptedException {
		driver.get(prop.getProperty("url"));
		//Check for gold color
		String colourGold = driver.findElement(By.xpath("//div[@class='myHeading']")).getCssValue("background-color");
		String c = Color.fromString(colourGold).asHex();
		System.out.println(c);
		// Checking Navy Blue color
		String colourNavyBlue = driver.findElement(By.xpath("//button[@type='submit']"))
				.getCssValue("background-color");
		String c1 = Color.fromString(colourNavyBlue).asHex();
		System.out.println(c1);

		String username = "harshini.iyli@qualitestgroup.com";
		String pwd = "P@ssw";
		LoginPage lp = new LoginPage(driver);
		lp.getusername().sendKeys(username);
		lp.getpassword().sendKeys(pwd);
		lp.submit().click();

		// verify if the alert text is displayed
		
		System.out.println(driver.switchTo().alert().getText());
		// accept the alert
		driver.switchTo().alert().accept();

	}

	/*
	 * Testcase to login to the website
	 * 
	 */
	@Test
	public void testOne() throws IOException {

		driver.get(prop.getProperty("url"));
		String username = "harshini.iyli@qualitestgroup.com";
		String pwd = "P@ssw0rd";
		LoginPage lp = new LoginPage(driver);
		System.out.println(lp.title());
		lp.title().equals("QTRecognition");
		lp.getusername().sendKeys(username);
		lp.getpassword().sendKeys(pwd);
		lp.submit().click();
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
