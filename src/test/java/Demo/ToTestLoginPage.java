package Demo;

import java.io.IOException;
import PkgForObject.LoginPage;
import org.testng.annotations.Test;

import BasicPackage.BaseMain;

public class ToTestLoginPage extends BaseMain {

	@Test
	public void testOne() throws IOException {
		driver = initializingDRiver();
		driver.get(prop.getProperty("url"));
		System.out.println("just hello");
		String username="harshini.iyli@qualitestgroup.com";
		String pwd= "P@ssw0rd";
		LoginPage lp = new LoginPage(driver);
		System.out.println(lp.title());
		lp.title().equals("QTRecognition");
		lp.getusername().sendKeys(username);
		lp.getpassword().sendKeys(pwd);
		lp.submit().click();
	}
}
