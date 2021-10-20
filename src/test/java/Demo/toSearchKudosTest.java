package Demo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BasicPackage.BaseMain;
import PkgForObject.KudosSearchPage;
import PkgForObject.LoginPage;

public class toSearchKudosTest extends BaseMain {

	/*
	 * to initialize browser
	 * 
	 */
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializingDRiver();
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	}
	
	/*
	 * Testcase to search kudos from activity page
	 * 
	 */
	@Test
	public void tFour() throws InterruptedException {
		
		driver.get(prop.getProperty("url"));
		
		LoginPage lp = new LoginPage(driver);
		lp.getusername().sendKeys("harshini.iyli@qualitestgroup.com");
		lp.getpassword().sendKeys("P@ssw0rd");
		lp.submit().click();
	
		
		KudosSearchPage ksp = new KudosSearchPage(driver);
		WebDriverWait w = new WebDriverWait(driver,5);
		//Thread.sleep(2000);
		ksp.getSearchButton().click();
		
		//Thread.sleep(2000);
		String Ename= "Madhuri Kulkarni��(madhuri.kulkarni@qualitestgroup.com)";
		
		w.until(ExpectedConditions.visibilityOfElementLocated(ksp.waitsend()));
		ksp.senEmail().sendKeys(Ename);
		Thread.sleep(2000);
		WebElement down=ksp.senEmail();
		down.sendKeys(Keys.ARROW_DOWN,Keys.RETURN);
		down.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		//w.until(ExpectedConditions.visibilityOfElementLocated(ksp.waitname()));
		
		ksp.searchBtn().click();
		Thread.sleep(4000);
		System.out.println(ksp.getmediaBox().isDisplayed());
		String str = ksp.getFname().getText();
		String str1 =ksp.getSmallText().getText();
		String check=ksp.FUsername().getText();
		Thread.sleep(2000);

		System.out.println(str);
		System.out.println(str1);

		String actual= check.split(" ")[0];
		if(str.contains(actual) ) {
			
			System.out.println("true case");
		
		}
		else {
			System.out.println("do not print");
		}
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();	
	}
}
