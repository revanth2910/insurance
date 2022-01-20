package test_cases;

import java.io.IOException;
// import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import page_obj.Page_ReqQuote;


public class TC_RQ_001 extends BaseClass {
	
	@Test
	public void quote() throws IOException
	{
		Page_ReqQuote rq = new Page_ReqQuote(driver);
		
		rq.selectCountry();
		logger.info("country selected");
		
		rq.getinsurance();
		logger.info("clicked on Get Insurance");
		
		rq.request();
		logger.info("clicked on request a quote");
		
		//String arr[] = {"home","auto","condo","tenant"};		// for method-2
		/* ArrayList <String> arr = new ArrayList<String>();	// for method-3
		arr.add("home");
		arr.add("auto");
		arr.add("condo"); */
		
		rq.SelectQue("Personal", "auto", "home");	// for method-1
		// rq.SelectQue("Personal",arr);		for method-2, method-3
		logger.info("clicked on personal insurance and selected auto, home ");
		
		rq.Member("yes","Coreio Inc.");
		logger.info("selected yes for member in MyGroup");
		
		rq.addtext("this is just a verification");
		logger.info("entered text");
		
		rq.firstname("john");
		logger.info("Firstname entered");
		
		rq.lastname("abraham");
		logger.info("lastname entered");
		
		String num = randomNumber();
		rq.mobile(num);
		logger.info("mobile number entered");
		
		String mail = randomEmail()+"@gmail.com";
		rq.Email(mail);
		logger.info("email entered");
		
		rq.postal("G5Y");
		logger.info("postal code entered");
		
		rq.province("British Columbia");
		logger.info("British columbia is selected");
		
		rq.company("acb news");
		logger.info("company name abc news");
		
		rq.city("Sofia");
		logger.info("city name entered");
		
		rq.street("6111 Indian line");
		logger.info("street name entered");
		
		rq.date("15","2023","April");
		logger.info("clicked on date");
		
		rq.captcha();
		logger.info("clicked on captcha");
		
		rq.submit();
		logger.info("clicked on submit");

		if(driver.getTitle().contains("Thank you - Westland Insurance"))
		{
			Assert.assertTrue(true);  //import Assert from TestNG
			logger.info("tites matched");
		}
		
		else
		{
			captureScreen(driver, "TC_001 "); // captureScreen is present in baseClass
			Assert.assertTrue(true);
			logger.warn("titles not matched");
		}

	}

}
