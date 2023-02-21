package org.Sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPojo extends BaseClass {
	
	public LoginPojo() {
		PageFactory.initElements(d, this);
	}
	@FindBy(id="email")
	private WebElement Emailbox;
	
	@FindBy(id="pass")
	private WebElement Passbox;
	
	@FindBys({
	@FindBy(name="login"),
	@FindBy(className="submit"),
	@FindBy(id="u_0_5_Dp")
})
	private WebElement FindBys;
	
	@FindAll({
		@FindBy(name="login"),
		@FindBy(xpath="//button[text()='Log in']"),
		@FindBy(id="u_0_5_Dp")
		
})
	private WebElement FindAll;

	public WebElement getEmailbox() {
		return Emailbox;
	}

	public WebElement getPassbox() {
		return Passbox;
	}

	public WebElement getFindBys() {
		return FindBys;
	}

	public WebElement getFindAll() {
		return FindAll;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
