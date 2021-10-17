package Demo;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import BasicPackage.BaseMain;
import PkgForObject.DisplayPage;
import PkgForObject.LoginPage;

public class ToDisplayTest extends BaseMain {

	@Test
	public void testTwo() throws IOException {
		driver = initializingDRiver();
		driver.get(prop.getProperty("url"));
		
		LoginPage lp = new LoginPage(driver);
		lp.getusername().sendKeys("harshini.iyli@qualitestgroup.com");
		lp.getpassword().sendKeys("P@ssw0rd");
		lp.submit().click();
		
		DisplayPage dp = new DisplayPage(driver);
		System.out.println(lp.title());
		lp.title().equals("QTRecognition");
		System.out.println(dp.showName().getText());
		Assert.assertTrue(dp.showName().isDisplayed());
		Assert.assertTrue(dp.showImg().isDisplayed());
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();	
	}
}
