package page_obj;

//import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page_Schedule {
	
	WebDriver driver;
	
	public Page_Schedule(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[normalize-space()='British Columbia']")
	WebElement british;
	
	@FindBy(linkText="ICBC renewal")
	WebElement ren;
	
	@FindBy(xpath="//div[@class='trailer--double']//a[contains(@class,'center')]")
	WebElement sched;
	
	@FindBy(xpath="//label[@for='12:28;a']")
	WebElement app;
	
	@FindBy(xpath="//button[@title='Next']")
	WebElement nt;
	
	@FindBy(xpath="//div[contains(@class,'slds-page-header')]//h3")
	WebElement dat;

	@FindBy(xpath="//button[@title='Next calendar page']")
	WebElement nxt;

	@FindBy(xpath="//div[contains(@class,'slds-text-align_center')]//h3")
	List<WebElement> day;
	
	@FindBy(xpath="//div[contains(@class,'innerScroll mobileTimeSlot')]//div[2]//label")
	List<WebElement> slot2;
	
	@FindBy(xpath="//div[contains(@class,'innerScroll mobileTimeSlot')]//div[3]//label")
	List<WebElement> slot3;
	
	@FindBy(xpath="//div[contains(@class,'innerScroll mobileTimeSlot')]//div[4]//label")
	List<WebElement> slot4;
	
	@FindBy(xpath="//div[contains(@class,'innerScroll mobileTimeSlot')]//div[5]//label")
	List<WebElement> slot5;
	
	@FindBy(xpath="//div[contains(@class,'innerScroll mobileTimeSlot')]//div[6]//label")
	List<WebElement> slot6;
	
	@FindBy(xpath="//div[@class='actionsRight slds-grid']//button[2]")
	WebElement net;
	
	@FindBy(xpath="//input[@name='First_Name']")
	WebElement fname;
	
	@FindBy(xpath="//input[@name='Last_Name']")
	WebElement lname;
	
	@FindBy(xpath="//input[@name='Phone']")
	WebElement pho;
	
	@FindBy(xpath="//input[@name='Email']")
	WebElement mail;
	
	@FindBy(xpath="//input[@name='Plate_Number']")
	WebElement plate;
	
	@FindBy(xpath="//div//text")
	WebElement txt;
	
	@FindBy(xpath="//label[@for='checkbox-149']//span[1]")
	WebElement check;
	
	@FindBy(xpath="//input[@name='consentName']")
	WebElement fullname;
	
	@FindBy(xpath="//label[@for='checkbox-156']//span[1]")
	WebElement chk;
	
	@FindBy(xpath="//button[normalize-space()='Next']")
	WebElement btn;


	public void selectCountry()
	{
		Actions act = new Actions(driver);
		act.moveToElement(british).click().perform();
	}
	
	public void renewal()
	{
		ren.click();
	}
	
	public void schedule()
	{
		sched.click();
	}
	
	public void appoint()
	{
		 WebDriverWait wa = new WebDriverWait(driver,35);
		 wa.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='12:28;a']"))).click();
		
		// app.click();
	}
	
	public void Next()
	{
		nt.click();
	}
/*
	public void Slot(String month, String Day, String time) throws InterruptedException
	{
	  /* String month = "December 18, 2021 - December 23, 2021";  // pass this during execution
	  String time = "9:00 - 9:30 pm";  // pass this during execution
	  String Day = "Sun";  // pass this during execution 
		
		WebDriverWait wa = new WebDriverWait(driver,50);
		wa.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(@class,'slds-page')]")));
		 
		while(true)
		{
			String anyName = dat.getText();   // gives the text of year and month
	    
			if(anyName.equals(month))
			{   
				for(WebElement day1:day)	
				{
					if(day1.getText().contains(Day))
					{
						Slot2(time);
					}
				}
				break;
			}
		    else
		    {
		    	nxt.click();  // clicks on next arrow 
		      	Thread.sleep(4000);	    
		    }
		}
	}
*/	
	public void date(String month) throws InterruptedException
	{
		WebDriverWait wa = new WebDriverWait(driver,50);
		wa.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(@class,'slds-page')]")));
				 
		while(true)
		{
			String anyName = dat.getText();   // gives the text of year and month
				    
			if(anyName.equals(month))
		    { 
		    	break;
		    }
		    else
		    {
		    	nxt.click();
		    	Thread.sleep(4000);
		    }
		}
	}

	public void Day(String da,String time)
	{
		for(WebElement day1:day)
		{
			if(day1.getText().equals(da))
		    {
				Slot2(time);
		    }
		}
	}
/*	
	public void Slot(int number,String time)
	{
		List<WebElement> s = new ArrayList<WebElement>();
		switch(number)
		{
		case 2:
			 s = slot2;
			 break;
		case 3:
			 s = slot3;
			 break;
		case 4:
			 s = slot4;
			 break;
		case 5:
			 s = slot5;
			 break;
		case 6:
			 s = slot6;
			 break;		
		}
			
		System.out.println(s.size());
		
		for(WebElement slot:s)
        {
			//System.out.println(slot.getText());
			
			if(slot.getText().equals(time))
			{
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].scrollIntoView();", slot);
				js.executeScript("arguments[0].click();", slot);
			}
        }
	}
*/	
	public void Slot2(String time)
	{	
		System.out.println(slot2.size());
	
		for(WebElement slot:slot2)
		{
			//System.out.println(slot.getText());
		
			if(slot.getText().equals(time))
			{
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].scrollIntoView();", slot);
				js.executeScript("arguments[0].click();", slot);
			}
		}
	}
	
	public void Slot3(String time)
	{	
		System.out.println(slot3.size());
	
		for(WebElement slot:slot3)
		{
			//System.out.println(slot.getText());
		
			if(slot.getText().equals(time))
			{
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].scrollIntoView();", slot);
				js.executeScript("arguments[0].click();", slot);
			}
		}
	}
	
	public void Slot4(String time)
	{	
		System.out.println(slot4.size());
	
		for(WebElement slot:slot4)
		{
			//System.out.println(slot.getText());
		
			if(slot.getText().equals(time))
			{
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].scrollIntoView();", slot);
				js.executeScript("arguments[0].click();", slot);
			}
		}
	}
	
	public void Slot5(String time)
	{	
		System.out.println(slot5.size());
	
		for(WebElement slot:slot5)
		{
			//System.out.println(slot.getText());
		
			if(slot.getText().equals(time))
			{
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].scrollIntoView();", slot);
				js.executeScript("arguments[0].click();", slot);
			}
		}
	}
	
	public void Slot6(String time)
	{	
		System.out.println(slot6.size());
	
		for(WebElement slot:slot6)
		{
			//System.out.println(slot.getText());
		
			if(slot.getText().equals(time))
			{
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].scrollIntoView();", slot);
				js.executeScript("arguments[0].click();", slot);
			}
		}
	}
	
	public void next()
	{	
  	  	net.click();
	}
	
	public void Fname(String fn)
	{
		fname.sendKeys(fn);
	}
	
	public void Lname(String ln)
	{
		lname.sendKeys(ln);
	}
	
	public void phone(String ph)
	{
		pho.sendKeys(ph);
	}
	
	public void Email(String ma)
	{
		mail.sendKeys(ma);
	}
	
	public void Plate(String pl)
	{
		plate.sendKeys(pl);
	}
	
	public void text(String tx)
	{
		txt.sendKeys(tx);
	}
	
	public void Check()
	{
		check.click();
	}
	
	public void FullName(String fn)
	{
		fullname.sendKeys(fn);
	}
	
	public void check()
	{
		chk.click();
	}
	
	public void button()
	{
		btn.click();
	}
}
