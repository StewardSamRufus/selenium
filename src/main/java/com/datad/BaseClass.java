package com.datad;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static  Actions a;
	public static Robot r;
	public static Alert al;
	public static JavascriptExecutor js;
	public static WebDriver framesize;
	public static Select s;

	public static void launchChromebrowser() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	}

	public static void getURL(String url) {
	driver.get(url);
	}

	public static String   getTITLE() {
	String title = driver.getTitle();
	return title;
	}

	public static void  getCurrentURL() {
	driver.getCurrentUrl();
	}
	public static void  quitBrowser() {
	driver.quit();
	}
	public static void  closeBrowser() {
	driver.close();
	}
	public static  void passKeys(String txt,WebElement e)  {
	e.sendKeys(txt);
	}
	public static void clickbutton(WebElement e1) {
	e1.click();
	}
	public static void getTEXT(WebElement element) {
	element.getText();
	}
	public static void getATTRIBUTE(WebElement element,String value) {
	element.getAttribute(value);
	}
	public static void movetoElement(WebElement element) {
	Actions a = new Actions(driver);
	a.moveToElement(element).perform();
	}
	public static void dragandDrop(WebElement src,WebElement des) {
	a.dragAndDrop(src, des).perform();
	}
	public static void contextCLICK(WebElement element) {
	a.contextClick(element).perform();

	}
	public static void doubleCLICK(WebElement element) {
	a.doubleClick(element).perform();

	}
	public static void enterkey() throws AWTException {
	Robot r = new Robot();
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	}
	public static void switchToAlert() {
	Alert al= driver.switchTo().alert();
	}

	public static void alertAccept() {
	al.accept();
	}
	public static void alertDimiss() {
	al.dismiss();
	}
	public static void alertGettext() {
	al.getText();
	}
	public static void alertSendkeys(String alerttext) {
	al.sendKeys(alerttext);
	}
	public static void sleep(int secds) throws InterruptedException {
	Thread.sleep(secds);

	}

	public static void scrollDOWN(WebElement element) {
	JavascriptExecutor js= (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	public static  void scrollUP(WebElement element) {
	js.executeScript("arguments[0].scrollIntoView(false)", element);

	}
	

	public static void switchToWindow() {
	String windowId = driver.getWindowHandle();
	driver.switchTo().window(windowId);

	}
	public static void switchToMultipleWindows(int i) {
	Set<String> windowhandles = driver.getWindowHandles();
	List<String> allwindows= new ArrayList<String>();
	allwindows.addAll(windowhandles);
	driver.switchTo().window(allwindows.get(i));
	}
	public static void switchToFrame(WebElement element) {
	WebDriver f = driver.switchTo().frame(element);

	}
	public static void getAllTableRows(WebElement table,String tagnameforTableRow) {
	List<WebElement> rows = table.findElements(By.tagName(tagnameforTableRow));
	for (int i = 0; i < rows.size(); i++) {
	System.out.println(rows.get(i));

	}}
	public static void getTableRow(WebElement table,String tagnameforTableRow,int index) {
	List<WebElement> rows = table.findElements(By.tagName(tagnameforTableRow));
	System.out.println(rows.get(index));

	}
	public static void getAllTableHeadings(WebElement table,String tagnameforTableHeading) {
	List<WebElement> h = table.findElements(By.tagName(tagnameforTableHeading));
	for (int i = 0; i < h.size(); i++) {
	System.out.println(h.get(i));

	}}
	public static void getAllTableDatas(WebElement table,String tagnameforTableData) {
	List<WebElement> data = table.findElements(By.tagName(tagnameforTableData));
	for (int i = 0; i < data.size(); i++) {
	System.out.println(data.get(i));

	}}
	public static void frameSize(String tagName) {
	List<WebElement> fsize = driver.findElements(By.tagName(tagName));
	System.out.println(fsize.size());

	}

	public static void selectDropDownINDEX(WebElement element,int index) {
	Select s = new Select(element);
	s.selectByIndex(index);
	}

	public static void selectDropDownVALUE(WebElement element ,String value) {
	Select s = new Select(element);
	s.selectByValue(value);
	}

	public static void selectDropDownTEXT(WebElement element, String text) {
	Select s = new Select(element);
	s.selectByVisibleText(text);
	}

	public static void MultipleIS() {
	boolean multiple = s.isMultiple();
	System.out.println(multiple);
	}
	public static void getOPTIONS() {
	List<WebElement> options = s.getOptions();
	for (WebElement w : options) {
	System.out.println(w);

	}


	}
	public static void getAllselectedOptns() {
	List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
	for (WebElement w : allSelectedOptions) {
	System.out.println(w);

	}

	}
	public static void deselectByINDEX(int index) {
	s.deselectByIndex(index);

	}
	public static void deselectByTEXT(String text) {
	s.deselectByVisibleText(text);

	}

	public static void deselectByVALUE(String value) {
	s.deselectByValue(value);

	}
	public static void deselectALL() {
	s.deselectAll();

	}
	

    public static void createNewExcelFile(int rowno , int cellno,String cellname ) throws Exception {
        File f = new File("C:\\Users\\LENOVO\\workspace\\DataDrivenTask\\excel\\ssr.xlsx");
		Workbook w = new XSSFWorkbook();
		Sheet s1 = w.createSheet("datas");
		Row row0 = s1.createRow(rowno);
		Cell cell01 = row0.createCell(cellno);
		cell01.setCellValue(cellname);
		FileOutputStream fo = new FileOutputStream(f);
		w.write(fo);
		}

    public static void createROW(int rowno , int cellno,String cellname ) throws Exception {
        File f = new File("C:\\Users\\LENOVO\\workspace\\DataDrivenTask\\excel\\ssr.xlsx");
        FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook();
		Sheet s1 = w.createSheet("datas");
		Row row0 = s1.createRow(rowno);
		Cell cell01 = row0.createCell(cellno);
		cell01.setCellValue(cellname);
		FileOutputStream fo = new FileOutputStream(f);
		w.write(fo);
		}
    

    public static  void createCELL(int rowno , int cellno,String cellname ) throws Exception {
        File f = new File("C:\\Users\\LENOVO\\workspace\\DataDrivenTask\\excel\\ssr.xlsx");
        FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook();
		Sheet s1 = w.createSheet("datas");
		Row row0 = s1.createRow(rowno);
		Cell cell01 = row0.createCell(cellno);
		cell01.setCellValue(cellname);
		FileOutputStream fo = new FileOutputStream(f);
		w.write(fo);
		}
    
    public static void updateDataToParticularCell(int rowno , int cellno,String existdata,String newdata ) throws Exception {
        File f = new File("C:\\Users\\LENOVO\\workspace\\DataDrivenTask\\excel\\ssr.xlsx");
        FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook();
		Sheet s1 = w.createSheet("datas");
		Row row0 = s1.getRow(rowno);
		Cell cell = row0.getCell(cellno);
		String str = cell.getStringCellValue();
		
		if (str.equals(existdata)) {
			cell.setCellValue(newdata);
			
		}
		FileOutputStream fo = new FileOutputStream(f);
		w.write(fo);
		
		}
    
    public static void readExcelData(int rowno,int cellno) throws Exception {
		File f = new File("C:\\Users\\LENOVO\\workspace\\DataDrivenTask\\excel");
		FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fi);
		Sheet sheet1 = w.getSheet("Sheet1");
		Row row = sheet1.getRow(rowno);
	    	Cell ce= row.getCell(cellno);
	    		int cellType = ce.getCellType();
	    		if (cellType==1) {
	    			ce.getStringCellValue();
	    			} else if (DateUtil.isCellDateFormatted(ce)) {
					Date dd = ce.getDateCellValue();
					SimpleDateFormat s = new SimpleDateFormat("dd/mm/yyyy");
					String format = s.format(dd);
					} else {
					double numericCellValue = ce.getNumericCellValue();
					long l = (long) numericCellValue;
					String.valueOf(l);
				}

	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}


	
	
	
	
	
	
	


