package test_cases;

import org.testng.annotations.Test;

import page_obj.Page_ReqQuote;


public class TC_RQ_003 extends BaseClass {
	
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
		
		rq.submit();
		logger.info("request was submitted");

	}

}
