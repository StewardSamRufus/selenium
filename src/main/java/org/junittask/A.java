package org.junittask;

import org.junit.Test;

import com.datad.BaseClass;

public class A extends BaseClass{
	
	
@Test
	
	public void tc1() {
		System.out.println("test case 1");
		launchChromebrowser();
		getURL("https://www.cricbuzz.com/");

	}

}
