package com.datad;

public class FbLogin extends BaseClass {

	public static void main(String[] args) {
		
		
		
		
		FbLoginPojo f = new FbLoginPojo();
		
		
		launchChromebrowser();
		getURL("https://www.facebook.com/");
		
		passKeys("sam",f.getUserId());
		
		passKeys("1234",f.getPassword() );
		
		clickbutton(f.getLoginbtn());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
