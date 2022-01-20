package test_cases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import page_obj.Page_Schedule;

public class TC_SC_001 extends BaseClass {

	@Test
	public void sched() throws IOException, InterruptedException 
	{
		
		Page_Schedule ps=new Page_Schedule(driver);
		
		ps.selectCountry();
		logger.info("country selected");
		
		ps.renewal();
		logger.info("clicked on renewal");
		
		ps.schedule();
		logger.info("clicked on schedule");
		// Thread.sleep(33000);
		
		ps.appoint();
		logger.info("clicked on appointment slot");
		
		ps.Next();
		logger.info("clicked on next");
		// Thread.sleep(30000);
		
		//ps.Slot("January 14, 2022 - January 19, 2022","Sund","3:45 - 4:15 pm");
		//logger.info("slot selected");
		
		ps.date("January 15, 2022 - January 20, 2022");
		logger.info("date matched");
		
		//ps.Day("SUN 16","3:45 - 4:15 pm");
		//logger.info("day matched and clicked on slot");
		
		ps.Slot4("3:45 - 4:15 pm");
		logger.info("slot selected");
		
		ps.next();
		logger.info("clicked next after slot selection");
		Thread.sleep(4000);
		
		boolean sl = driver.getPageSource().contains("Select a service appointment time.");
		
		if(sl==true)
		{
			captureScreen(driver,"SC_001");
			Assert.assertFalse(false);
			logger.info("slot not selected");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("slot selected");
		}
		
		boolean pg = driver.getPageSource().contains("Appointment Type: Call");
		
		if(pg==true)
		{
			Assert.assertTrue(true);
			logger.info("page changed");
		}
		
		else
		{
			Assert.assertFalse(false);
			logger.info("page not changed");
		}
		
		ps.Fname("Fab");
		logger.info("firstname entered");
		
		ps.Lname("jin");
		logger.info("lastname entered");
		
		String email = randomEmail()+"@gmail.com";
		ps.Email(email);
		logger.info("Email entered");
		
		String num = randomNumber();
		ps.phone(num);
		logger.info("number entered");
		
		ps.Plate("3 GB 654");
		logger.info("plate number entered");
		
		//ps.text("gujegvhg");
		//logger.info("additional text entered");
		
		ps.Check();
		logger.info("clicked on checkbox");
		
		ps.FullName("Fab Jin");
		logger.info("Fullname entered");
		
		ps.check();
		logger.info("clicked on checkbox");
		
		ps.button();
		logger.info("clicked on next button");
	}
}
