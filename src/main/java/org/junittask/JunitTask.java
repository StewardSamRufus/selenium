package org.junittask;


import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.datad.BaseClass;



public class JunitTask extends BaseClass {
	
	@BeforeClass
	public static void befcls() {
		launchChromebrowser();
	}
	@AfterClass
	public static void aftcls() {
		closeBrowser();

	}
	@Before
	public void bef() {
		Date d = new Date();
		System.out.println(d);
	}
	@After
	public void aft() {
		Date d = new Date();
		System.out.println(d);

	}
	
	@Test
	public void tc2() {
		System.out.println("test case 2");
		getURL("https://www.facebook.com/login.php/");
		String title = getTITLE();
		Assert.assertEquals( title, title.contains("Log"));
		closeBrowser();
		
		
		

	}
	@Test
	
	public void tc3() {
		System.out.println("test case 3");
		getURL("https://www.cricbuzz.com/");

	}
	@Test
	public void tc5() {
		System.out.println("test case 5");
		getURL("https://www.redbus.in");

	}
	
	
	

}
