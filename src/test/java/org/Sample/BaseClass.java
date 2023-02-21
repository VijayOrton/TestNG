package org.Sample;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.Action;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	static WebDriver d;
	static Actions ac;
	static Robot r;
	static String value;

	public static void ChromBrowser() {
		WebDriverManager.chromedriver().setup();
		d = new ChromeDriver();
	}

	public static void EdgeBrowser() {
		WebDriverManager.edgedriver().setup();
		d = new EdgeDriver();

	}

	public static void UrlLaunch(String url) {
		d.get(url);

	}

	public static void MaxWindow() {
		d.manage().window().maximize();

	}

	public static void CloseBrowser() {
		d.close();

	}

	public static String getTittle() {
		String title = d.getTitle();
		return title;

	}

	public static void PassValue(WebElement e, String pass) {
		e.sendKeys(pass);

	}

	public static void BtnClik(WebElement b) {
		b.click();
	}

	public static void toRightClick(WebElement ele) {
		ac = new Actions(d);
		ac.contextClick(ele).perform();

	}

	public static void toDoubleClick(WebElement ele) {
		ac = new Actions(d);
		ac.doubleClick(ele).perform();

	}

	public static void MouseOver(WebElement ele) {
		ac = new Actions(d);
		ac.moveToElement(ele).perform();
	}

	public static void ImplicitWait() {
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public static void Tocopy() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);

		r.keyRelease(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}

	public static void Topaste() {
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);

		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}

	public static void Screenshot(String picname, String Fname) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) d;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\vijay\\" + Fname + "\\" + picname + ".png");
		FileUtils.copyFile(src, des);

	}

	public static void JsSendkeys(WebElement ele, String val) {
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("aruguments[0].setAttribute('value','" + val + "')", ele);

	}

	public static String excelRead(String sheetName, int row, int cell) throws IOException {

		File f = new File("C:\\Users\\vijay\\eclipse-workspace\\Testng\\extanal\\test data.xlsx");

		FileInputStream fis = new FileInputStream(f);

		Workbook w = new XSSFWorkbook(fis);

		Sheet s = w.getSheet(sheetName);
		Row r = s.getRow(row);
		Cell c = r.getCell(cell);
		int cellType = c.getCellType();

		if (cellType == 1) {
			c.getStringCellValue();

		} else if (DateUtil.isCellDateFormatted(c)) {
			Date dd = c.getDateCellValue();
			SimpleDateFormat d = new SimpleDateFormat("dd-MM-yy");
			value = d.format(dd);
		}

		else {
			double d = c.getNumericCellValue();
			long l = (long) d;
			value = String.valueOf(l);

		}
		return value;

	}
}
