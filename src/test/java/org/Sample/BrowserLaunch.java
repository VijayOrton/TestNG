package org.Sample;

public class BrowserLaunch extends BaseClass{
	
	public static void main(String[] args) {
		
	ChromBrowser();
	UrlLaunch("https://www.facebook.com/");
	MaxWindow();
	LoginPojo l = new LoginPojo();
	PassValue(l.getEmailbox(), "vijay");
	PassValue(l.getPassbox(), "123456");
	BtnClik(l.getFindAll());
		
		
		
	}
	
	

}



