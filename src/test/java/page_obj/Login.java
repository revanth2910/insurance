package page_obj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	WebDriver ldriver;
	
	public Login(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(xpath="//a[normalize-space()='British Columbia']")
	WebElement british;
	
	@FindBy(xpath="//a[normalize-space()='Motorcycle'")
	WebElement mcycle;
	
	@FindBy(xpath="//a[@class='btn btn--wide']")
	WebElement insurance;
	
	@FindBy(xpath="//a[normalize-space()='Request an ICBC renewal']")
	WebElement req;
	
	@FindBy(xpath="//a[normalize-space()='Renew Now']")
	WebElement renewa;
	
	@FindBy(id="input_3_2")
	WebElement license;
	
	@FindBy(id="input_3_6")
	WebElement addinfo;
	
	@FindBy(id="input_3_8")
	WebElement first;
	
	@FindBy(id="input_3_9")
	WebElement last;
	
	@FindBy(id="input_3_10")
	WebElement phone;
	
	@FindBy(id="input_3_11")
	WebElement email;
	
	@FindBy(id="input_3_12")
	WebElement postal;
	
	@FindBy(id="input_3_21")
	WebElement city;
	
	@FindBy(id="input_3_22")
	WebElement province;
	
	@FindBy(id="input_3_28")
	WebElement fullname;
	
	@FindBy(xpath="//label[contains(text(),'Yes, I have read and agree to the information prov')]")
	WebElement confirm;
	
	@FindBy(xpath="//div[@id='input_3_30']")
	WebElement cap;
	
	@FindBy(id="gform_submit_button_3")
	WebElement submit;
	

// writing actions for every webEement
	
	public void selectCountry()
	{
		british.click();
	}
	
	public void motorcycle()
	{
		mcycle.click();
	}
	
	public void getinsurance()
	{
		insurance.click();
	}
	
	public void requestRenewal()
	{
		req.click();
	}
	
	public void clickRenewal()
	{
		renewa.click();
	}
	
	public void licenseNo(String lno)
	{
		license.sendKeys(String.valueOf(lno));
	}
	
	public void addInfo(String info)
	{
		addinfo.sendKeys(info);
	}
	
	public void firstName(String fname)
	{
		first.sendKeys(fname);
	}
	
	public void lastName(String lname)
	{
		last.sendKeys(lname);
	}
	
	public void phoneNo(String pno)
	{
		phone.sendKeys(String.valueOf(pno));
	}
	
	public void enterEmail(String mail)
	{
		email.sendKeys(mail);
	}
	
	public void postalCode(String pcode)
	{
		postal.sendKeys(String.valueOf(pcode));
	}
	
	public void enterCity(String cit)
	{
		city.sendKeys(cit);
	}
	
	public void enterProvince(String pro)
	{
		province.sendKeys(pro);
	}
	
	public void Name(String name)
	{
		fullname.sendKeys(name);
	}
	
	public void approve()
	{
		confirm.click();
	}
	
	public void captcha()
	{
		cap.click();
	}
	
	public void sub()
	{
		submit.click();
	}
	
}