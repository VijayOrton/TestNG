package org.testing;

import java.io.IOException;
import java.util.Date;

import org.Sample.BaseClass;
import org.Sample.LoginPojo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Test2 extends BaseClass {
	
	LoginPojo l;

	@BeforeClass
	private void startTime() {
		Date d = new java.util.Date();
		System.out.println("startTime" + d);

	}

	@BeforeMethod(alwaysRun=true)
	private void startBrowser() {
		ChromBrowser();
		MaxWindow();
		UrlLaunch("https://www.facebook.com/");
		ImplicitWait();
	}

	@Test
	private void tc1() throws IOException {
		 l = new LoginPojo();
		WebElement emailbox = l.getEmailbox();
		PassValue(emailbox,"aaron@gmail.com");
		PassValue(l.getPassbox(),"8866");
		BtnClik(l.getFindAll());
	}


	@Test(dataProvider="datas",dataProviderClass=Test1.class)
	private void tc2(String user,String pass) {
		 l = new LoginPojo();
			WebElement emailbox = l.getEmailbox();
			PassValue(emailbox,user);
			PassValue(l.getPassbox(),pass);
			BtnClik(l.getFindAll());
		}
	@Test(retryAnalyzer=Rerun.class)
	private void tc3() {
		 l = new LoginPojo();
			WebElement emailbox = l.getEmailbox();
			PassValue(emailbox,"balaji@gmail.com");
			String username = emailbox.getAttribute("value");
			SoftAssert s = new SoftAssert();
			s.assertEquals(emailbox, "hai@gmail.com");
			s.assertAll();
			PassValue(l.getPassbox(),"41615");
			BtnClik(l.getFindAll());
		}
	@Test(groups="smoke")
	private void tc5() {
		 l = new LoginPojo();
			WebElement emailbox = l.getEmailbox();
			PassValue(emailbox,"bala@gmail.com");
			PassValue(l.getPassbox(),"5465262");
			BtnClik(l.getFindAll());
		}

	@AfterMethod
	private void closeBrowser() {
		CloseBrowser();
	}

	@AfterClass
	private void endTime() {
		Date d = new java.util.Date();
		System.out.println("Endtime" + d);	
	}

}
	
	
	
	


