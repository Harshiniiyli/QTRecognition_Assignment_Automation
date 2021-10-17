package Demo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BasicPackage.BaseMain;
import PkgForObject.KudosSearchPage;
import PkgForObject.LoginPage;

public class toSearchKudosTest extends BaseMain {

	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializingDRiver();

	}
	
	@Test
	public void tFour() throws InterruptedException {
		
		driver.get(prop.getProperty("url"));
		
		LoginPage lp = new LoginPage(driver);
		lp.getusername().sendKeys("harshini.iyli@qualitestgroup.com");
		lp.getpassword().sendKeys("P@ssw0rd");
		lp.submit().click();
		
		KudosSearchPage ksp = new KudosSearchPage(null);
		ksp.getSearchButton().click();
		Thread.sleep(2000);
		String Ename= "Madhuri Kulkarni  (madhuri.kulkarni@qualitestgroup.com)";
		ksp.senEmail().sendKeys(Ename);
		WebElement down=driver.findElement(By.xpath("//input[@id='email_address']"));
		down.sendKeys(Keys.ARROW_DOWN);
		down.sendKeys(Keys.ENTER);
		
		System.out.println(ksp.getmediaBox().isDisplayed());
		String str = ksp.getFname().getText();
		String str1 =ksp.getSmallText().getText();
		String check=ksp.FUsername().getText();
		System.out.println(str);
		System.out.println(str1);
		ksp.searchBtn().click();
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
