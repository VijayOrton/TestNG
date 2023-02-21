package org.testing;

import java.io.IOException;
import java.util.Date;

import org.Sample.BaseClass;
import org.Sample.LoginPojo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Test1 extends BaseClass {

	@DataProvider(name = "datas")
	private Object[][] entry() {

		return new Object[][] { { "pragthis@gmail.com", "54566" },
			{ "Rakesh@gmail.com", "452665" } };

	}

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
		getTittle();
		ImplicitWait();
	}

	@Test(dataProvider = "datas")
	private void tc1(String user, String pass) throws IOException {
		l = new LoginPojo();
		WebElement emailbox = l.getEmailbox();
		PassValue(emailbox, user);
		PassValue(l.getPassbox(), pass);
		BtnClik(l.getFindAll());
	}

	@Test(retryAnalyzer=Rerun.class)
	private void tc2() {
		l = new LoginPojo();
		WebElement emailbox = l.getEmailbox();
		PassValue(emailbox, "hari@gmail.com");
		String username = emailbox.getAttribute("value");
		SoftAssert s = new SoftAssert();
		s.assertEquals(emailbox, "hai@gmail.com");
		s.assertAll();
		PassValue(l.getPassbox(), "562456");
		BtnClik(l.getFindAll());

	}

	@Test(groups="reg")
	private void tc3() {
		l = new LoginPojo();
		WebElement emailbox = l.getEmailbox();
		PassValue(emailbox, "aaron@gmail.com");
		PassValue(l.getPassbox(), "987456");
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
