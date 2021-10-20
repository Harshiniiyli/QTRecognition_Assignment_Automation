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

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializingDRiver();
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

	}

	@Test
	public void testInvalid() throws InterruptedException {
		driver.get(prop.getProperty("url"));
		// test gold
		String colourGold = driver.findElement(By.xpath("//div[@class='myHeading']")).getCssValue("background-color");
		String c = Color.fromString(colourGold).asHex();
		System.out.println(c);
		// Checking Navy Blue color
		String colourNavyBlue = driver.findElement(By.xpath("//button[@type='submit']"))
				.getCssValue("background-color");
		String c1 = Color.fromString(colourNavyBlue).asHex();
		System.out.println(c1);
		// Test white
		String colourwhite = driver.findElement(By.xpath("//div[@class='container']/form")).getCssValue("color");
		String c2 = Color.fromString(colourwhite).asHex();
		System.out.println(c2);

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
