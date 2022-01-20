package test_cases;

import java.io.IOException;

import org.testng.annotations.Test;

import page_obj.Page_ReqQuote;


public class TC_RQ_002 extends BaseClass {
	
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
		
		//rq.SelectQue("Business","liability","retail");
		logger.info("clicked on business insurance and selected liability, retail");
		
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
		
		rq.city("Sofia");
		logger.info("city name entered");
		
		rq.street("6111 Indian line");
		logger.info("street name entered");
		
		rq.captcha();
		logger.info("clicked on captcha");
		
		rq.submit();
		logger.info("request was submitted");

	}

}
