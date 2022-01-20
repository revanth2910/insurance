package test_cases;

import org.testng.annotations.Test;

import page_obj.Page_ReqQuote;


public class TC_RQ_008 extends BaseClass {
	
	@Test
	public void quote() throws InterruptedException
	{
		Page_ReqQuote rq = new Page_ReqQuote(driver);
		
		rq.selectCountry();
		logger.info("country selected");
		
		rq.getinsurance();
		logger.info("clicked on Get Insurance");
		
		rq.request();
		logger.info("clicked on request a quote");
		
		//rq.SelectQue("Personal","auto","home");
		logger.info("clicked on personal insurance and selected auto, home ");
		
		rq.Member("No","");
		logger.info("selected no for member in MyGroup");
		
		rq.addtext("this is just a verification");
		logger.info("entered text");
		
		rq.firstname("jo8hn2");
		logger.info("Firstname entered");
		
		rq.lastname("7abra5ham");
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
		
		rq.company("acb56news");
		logger.info("company name abc news");
		
		rq.city("Sofia125");
		logger.info("city name entered");
		
		rq.street("6111 Indian line");
		logger.info("street name entered");
		
		/* rq.date("15","10","1997");
		logger.info("entered date");
		Thread.sleep(5); */
		
		rq.captcha();
		logger.info("clicked on captcha");
		
		rq.submit();
		logger.info("request was submitted");

	}

}
