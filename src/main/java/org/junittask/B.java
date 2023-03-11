package org.junittask;

import org.junit.Test;

import com.datad.BaseClass;

public class B extends BaseClass {
	
	@Test
	public void tc6() {
		System.out.println("test case 6");
		launchChromebrowser();
		getURL("https://www.redbus.in");

	}
	
	

}
