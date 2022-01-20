package page_obj;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Page_ReqQuote {
	
	WebDriver driver;
	
	public Page_ReqQuote(WebDriver driver)
	{
	    this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[normalize-space()='British Columbia']")
	WebElement british;
	
	@FindBy(linkText="Get insurance")
	WebElement Insurance;
	
	@FindBy(xpath="//div[contains(@class,'get-a-quote')]//a")	//linkText="Request a quote"
	WebElement quote;
	
	@FindBy(name="input_1")
	List<WebElement> quotefor;
	
	@FindBy(xpath="//input[@id='choice_2_1_0']")
	WebElement person;
	
	@FindBy(xpath="//input[@id='choice_2_1_1']")
	WebElement business;
	
	@FindBy(xpath="//input[contains(@id,'choice_2_2_')]")
	List<WebElement> perscheck;
	
	@FindBy(xpath="//input[contains(@id,'choice_2_19_')]")
	List<WebElement> busicheck;
	
	@FindBy(name="input_29")
	List<WebElement> member;
	
	@FindBy(id="choice_2_29_0")
	WebElement yes;
	
	@FindBy(name="input_30")
	WebElement group;
	
	@FindBy(name="input_5")
	WebElement addtxt;
	
	@FindBy(name="input_8")
	WebElement fname;
	
	@FindBy(name="input_9")
	WebElement lname;
	
	@FindBy(name="input_10")
	WebElement phone;
	
	@FindBy(name="input_11")
	WebElement email;
	
	@FindBy(name="input_13")
	WebElement post;
	
	@FindBy(name="input_18")
	WebElement provi;
	
	@FindBy(name="input_22")
	WebElement com;
	
	@FindBy(name="input_23")
	WebElement cty;
	
	@FindBy(name="input_24")
	WebElement str;
	
	@FindBy(name="input_27")
	WebElement dat;

	@FindBy(xpath="//table//tbody//tr//td//a")
	List<WebElement> date;
	
 	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	WebElement month;
	
	@FindBy(xpath="//select[@class='ui-datepicker-year']")
	WebElement year;

	@FindBy(xpath="//div[@id='rc-anchor-container']")
	WebElement cap;
	
	@FindBy(id="gform_submit_button_2")
	WebElement sub;
	
	// navigating to other elements in a pages
	
	@FindBy(linkText = "Insurance")
	WebElement ins;
	
	@FindBy(xpath="//div[@class='nav-dropdown']//a[contains(@class,'itype') or contains(@class,'circle'")
	List<WebElement> nav;
	
	// open link in new tab
	
	@FindBy(xpath="//div[@class='breadcrumbs']//a[normalize-space()='Get insurance']")
	WebElement link;

	
	
// Action methods for every element	
	
	
	public void selectCountry()
	{
		Actions act = new Actions(driver);
		act.moveToElement(british).click().perform();
	}
	
	public void getinsurance()
	{	
		Actions act = new Actions(driver);
		act.moveToElement(Insurance).click().perform();
		//Insurance.click();
	}
	
	public void request()
	{
		Actions act = new Actions(driver);
		act.moveToElement(quote).click().perform();
		//quote.click();
	}
	
	 public void SelectQue(String pr, String at, String hm)		// method-1
	// public void SelectQue(String pr, String[] arr)		// method-2
	// public void SelectQue(String pr,List<String> arr)		// method-3
	{
		for(WebElement que:quotefor)
		{
			if(que.getAttribute("value").contains(pr))
			{
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", que);
				Boolean flag = person.isSelected();
				Boolean flag1 = business.isSelected();
				
				if(flag == true)
				{
					personal(at,hm);
					// personal(arr);	// for method-2, method-3
				}
				else if(flag1 == true)
				{
					business(at, hm);
					// business(arr);	//for method-2, method-3
				}
			}
		}
	}
	
	// to select multiple elements
	
// Method-1:
	 
	 public void personal(String at, String hm)
		{
			for(WebElement chk:perscheck)
			{
				if(chk.getAttribute("value").equalsIgnoreCase(at) || chk.getAttribute("value").equalsIgnoreCase(hm))
				{
				JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript("arguments[0].click();", chk);
				}
			}
		}
	 
	 public void business(String at, String hm)
		{
			for(WebElement chk:busicheck)
			{
				if(chk.getAttribute("value").equalsIgnoreCase(at) || chk.getAttribute("value").equalsIgnoreCase(hm))
				{
					JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript("arguments[0].click();", chk);
				}
			}
		}
/*	 
// Method-2:
	 
	 	public void personal(String[] arr)
		{
			for(WebElement chk:perscheck)
			{
				for(String x:arr) 
				{
					if(chk.getAttribute("value").equalsIgnoreCase(x))
					{
						JavascriptExecutor js = (JavascriptExecutor)driver;
						js.executeScript("arguments[0].click();", chk);
					}
				}
			}
		}

// Method-3:
		
	public void business(List<String> arr)
	{
		for(WebElement chk:busicheck)
		{
			for(String x:arr) 
			{
				
				if(chk.getAttribute("value").equalsIgnoreCase(x))
				{
					JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript("arguments[0].click();", chk);
				}
			}
		}
	}	
	
 method-4:			// to select all elements / specific / multiple

	public static void anyname(WebDriver driver, string... value)  // to select all write "all".
	{
 		if(!value[0].equalsIgnoreCase("all"))  // we are checking whether it is all or not. if not 
 		{
   			for(WebElement chk:perscheck)
   			{
    			for(string val:value) // we pass value during execution // val will read each value if we send multiple values
    			{
      				if(chk.getAttribute("value").equalsIgnoreCase(val))
					{
	  					JavascriptExecutor js = (JavascriptExecutor)driver;
						js.executeScript("arguments[0].click();", chk);
	  					break;
					}
    			}
  			}
  		}
  		else 					// if it is all 
  		{
   			for(WebElement chk:perscheck)
  			{
    			chk.click();
  			}
 		}
	}						NEED TO REPEAT THIS MULTIPLE TIMES IF WE HAVE MULTIPLE CHECKBOXES
	
*/
	
	public void Member(String yn, String gr)
	{
		for(WebElement mem:member)
		{
			if(mem.getAttribute("value").equalsIgnoreCase(yn))
			{
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", mem);
				
				Boolean Yes = yes.isSelected();
				
				if(Yes == true)
				{
					Group(gr);
				}	
			}
		}
	}
	
	public void Group(String gr)
	{
		Select gro = new Select(group);
		gro.selectByValue(gr);
	}
	
	
	public void addtext(String add)
	{
		addtxt.sendKeys(add);
	}
	
	public void firstname(String name)
	{
		fname.sendKeys(name);
	}
	
	public void lastname(String name)
	{
		lname.sendKeys(name);
	}
	
	public void mobile(String phn)
	{
		phone.sendKeys(phn);
	}
	
	public void Email(String mail)
	{
		email.sendKeys(mail);
	}
	
	public void postal(String pcode)
	{
		post.sendKeys(String.valueOf(pcode));
	}
	
	public void province(String pro)
	{
		Select prov = new Select(provi);
		prov.selectByVisibleText(pro);
	}
	
	public void company(String cpy)
	{
		com.sendKeys(cpy);
	}
	
	public void city(String cit)
	{
		cty.sendKeys(cit);
	}
	
	public void street(String stt)
	{
		str.sendKeys(stt);
	}
	
	public void date(String da, String val, String valu)
	{
		dat.click();
		Year(val);
		Month(valu);
		Date(da);
	}
	
	public void Date(String da)
	{		
		for(WebElement dat1:date)
		{
			if(dat1.getText().equals(da))
			{	
				dat1.click();	// can click using actions and JavaScript methods also
				break;
			}
		}
	}
	
	public void Month(String valu)
	{
		Select sel = new Select(month);
		sel.selectByVisibleText(valu);
	}

	public void Year(String val)
	{
		Select sel = new Select(year);
		sel.selectByValue(val);
	}
	
/* 
 	@FindBy()
 	WebElement month;
 	
 	@FindBy()
 	WebElement year;
 	
 	public void Month(String value)
	{
		Date1(month,value);
	}

	public void Year(String value)
	{
		Date1(year,value);
	}
	
	public void Date1(WebElement element,String value)  
	{
		Select sel = new Select(element);
    	List<WebElement> date1 = sel.getOptions();

    	for(WebElement Date:date1)
    	{
			if(Date.getAttribute("value").equalsIgnoreCase(value))
	  		{
				Date.click();
				break;
	  		}
    	}
	} 
*/	
	public void captcha()
	{
		// driver.switchTo().frame("a-y8kzc2nr30ic");
		driver.switchTo().frame(0);
		cap.click();
		driver.switchTo().defaultContent();
	}
	
	public void submit()
	{
		sub.click();
	}
	
	// navigate to back / front / refresh / to a page
	
	public void back(String url)
	{
		driver.navigate().to(url);
	}
	
	// open link in a new tab
	
	public void newtab()
	{
		String anyname = Keys.chord(Keys.CONTROL,Keys.ENTER);  // chord is a method, we can send multiple keys, return type is string.
		link.sendKeys(anyname);
	}
	
	// to navigate to other elements in page
	
	public void navigate(String nv)
	{
		Actions ac = new Actions(driver);
		ac.moveToElement(ins).perform();
		
		selectnav(nv);
	}
	
	public void selectnav(String se)
	{
		for(WebElement sel : nav)
		{
			if(sel.getText().contains(se))
			{
				sel.click();
			}
		}
	}
	
	// scroll to the bottom of the page
	
	public void scroll()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("Window.scrollTo(0, document.body.scrollHeight)");
	}
}
