package Demo;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BasicPackage.BaseMain;
import PkgForObject.LoginPage;
import PkgForObject.SendKudosPage;


public class toSendKudos extends BaseMain{
	
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializingDRiver();
	

	}
	
	//@Test
	public void testAThree() throws IOException, InterruptedException {
		driver.get(prop.getProperty("url"));
		
		LoginPage lp = new LoginPage(driver);
		lp.getusername().sendKeys("harshini.iyli@qualitestgroup.com");
		lp.getpassword().sendKeys("P@ssw0rd");
		lp.submit().click();
		SendKudosPage sendkudos = new SendKudosPage(driver);

		sendkudos.getKudosSend().click();
		Thread.sleep(3000);
		String Ename= "Madhuri Kulkarni��(madhuri.kulkarni@qualitestgroup.com)";
		sendkudos.enterEmail().sendKeys(Ename);
		Thread.sleep(3000);
		WebElement down=sendkudos.enterfullemail();
		down.sendKeys(Keys.ARROW_DOWN,Keys.RETURN);
		down.sendKeys(Keys.ENTER);

	
	List<WebElement> li =sendkudos.selecttrophy();
	for(WebElement list: li) {
		System.out.println(list.getText());
		
		if(list.getText().contains("Quick Learner")) {
			list.click();
			Thread.sleep(3000);

			System.out.println("quick learner selected");
			break;
		}
	}
	
	Thread.sleep(4000);
	sendkudos.sendcomment().sendKeys("Keep up the good work");
	Thread.sleep(1000);

	sendkudos.clicksend();
	System.out.println("kudos sent");
	driver.findElement(By.xpath("//div[@class='modal-footer'] //button[@class='btn btn-primary']")).click();
	System.out.println(driver.findElement(By.xpath("//*[@id='display_message']/span/center")).getText());
	Thread.sleep(10000);
	System.out.println(driver.findElement(By.xpath("//*[@id='display_message']/span/center")).getText());
	sendkudos.clickClose().click();
	Thread.sleep(3000);
	}
	
	//@Test
	public void testBMultiplekudos() throws InterruptedException {
		
		driver.get(prop.getProperty("url"));
		
		LoginPage lp = new LoginPage(driver);
		lp.getusername().sendKeys("harshini.iyli@qualitestgroup.com");
		lp.getpassword().sendKeys("P@ssw0rd");
		lp.submit().click();
		SendKudosPage sendkudos = new SendKudosPage(driver);
		Thread.sleep(3000);
		
		sendkudos.getKudosSend().click();
		Thread.sleep(3000);

		String Ename= "Madhuri Kulkarni��(madhuri.kulkarni@qualitestgroup.com)";
		sendkudos.enterEmail().sendKeys(Ename);
		Thread.sleep(2000);
		WebElement down=sendkudos.enterfullemail();
		down.sendKeys(Keys.ARROW_DOWN,Keys.RETURN);
		down.sendKeys(Keys.ENTER);
		
		List<WebElement> li2 =sendkudos.selecttrophy();
		for(WebElement list2: li2) {
			System.out.println(list2.getText());
			
			if(list2.getText().contains("Exceptional Work") ) {
				list2.click();
				System.out.println("exceptional work selected");
				Thread.sleep(1000);

				continue;
				}
			else if(list2.getText().contains("Quick Learner")) {
				list2.click();
				System.out.println("quick learner selected");
				Thread.sleep(1000);

				break;
			}
		}
		Thread.sleep(4000);
		sendkudos.sendcomment().sendKeys("Keep up the good work");
		Thread.sleep(1000);
		//sendkudos.clicksend();
		System.out.println("kudos sent");
		driver.findElement(By.xpath("//div[@class='modal-footer'] //button[@class='btn btn-primary']")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id='display_message']/span/center")).getText());
		Thread.sleep(10000);
		String errorMail =driver.findElement(By.xpath("//*[@id='display_message']/span/center")).getText();
		System.out.println(errorMail);
		Assert.assertTrue(errorMail.equalsIgnoreCase("Mailer Error: SMTP connect() failed."));
	
		
		sendkudos.clickClose().click();
		Thread.sleep(3000);
		System.out.println("This test is wrong it selects multiple kudos");
	}
	
	@Test
	public void testCEmptyComents() throws InterruptedException {
		
		driver.get(prop.getProperty("url"));
		
		LoginPage lp = new LoginPage(driver);
		lp.getusername().sendKeys("harshini.iyli@qualitestgroup.com");
		lp.getpassword().sendKeys("P@ssw0rd");
		lp.submit().click();
		SendKudosPage sendkudos = new SendKudosPage(driver);
		Thread.sleep(3000);
		
		sendkudos.getKudosSend().click();
		Thread.sleep(3000);

		String Ename= "Madhuri Kulkarni��(madhuri.kulkarni@qualitestgroup.com)";
		sendkudos.enterEmail().sendKeys(Ename);
		Thread.sleep(2000);
		WebElement down=sendkudos.enterfullemail();
		down.sendKeys(Keys.ARROW_DOWN,Keys.RETURN);
		down.sendKeys(Keys.ENTER);
		
		List<WebElement> li3 =sendkudos.selecttrophy();
		for(WebElement list: li3) {
			System.out.println(list.getText());
			
			if(list.getText().contains("Quick Learner")) {
				list.click();
				Thread.sleep(3000);

				System.out.println("quick learner selected");
				break;
			}
		}
		Thread.sleep(3000);
		//sendkudos.sendcomment().sendKeys("");
		Thread.sleep(1000);
	
		//System.out.println("kudos sent");
		sendkudos.clicksend().click();
		Thread.sleep(6000);
		System.out.println(driver.findElement(By.xpath("//*[@id='display_message']/span/center")).getText());
		Thread.sleep(4000);
		String errorcomment =driver.findElement(By.xpath("//*[@id='display_message']/span/center")).getText();
		System.out.println(errorcomment);
		Assert.assertTrue(errorcomment.equalsIgnoreCase("Please enter any comment."));
	
		sendkudos.clickClose().click();
		Thread.sleep(3000);
		System.out.println("This test is working, please add comments");
	}
	
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();	
	}
}
