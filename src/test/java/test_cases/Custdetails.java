package test_cases;

import org.testng.annotations.Test;

import page_obj.Login;

public class Custdetails extends BaseClass{
	
	@Test
	public void cust()
	{
		Login lo = new Login(driver);
		
		lo.selectCountry();
		logger.info("selected country");
		
		lo.motorcycle();
		logger.info("opted motorcycle insurance");
		
		lo.getinsurance();
		logger.info("cliked on get insurance");
		
		lo.requestRenewal();
		logger.info("requested for renewal");
		
		lo.clickRenewal();
		logger.info("selected renewa");
		
		lo.licenseNo("75NR0987");
		logger.info("enterd license number");
		
		lo.addInfo("i want to get the best insurance coverage that your can company provides");
		
		lo.firstName("Mangaldeep");
		logger.info("First name entered");
		
		lo.lastName("Agarbathi");
		logger.info("Last name entered");
		
		String num = randomNumber();
		lo.phoneNo(num);
		logger.info("mobile number entered");
		
		String mail = randomEmail()+"@gmail.com";
		lo.enterEmail(mail);
		logger.info("Email entered");
		
		lo.postalCode("098765");
		logger.info("Postal code entered");
		
		lo.enterCity("california");
		logger.info("City name entered");
		
		lo.enterProvince("5th cross street mansion house");
		logger.info("Province name entered");
		
		lo.Name("Mangaldeep Agarbathi");
		logger.info("Full name entered");
		
		lo.approve();
		lo.captcha();
		lo.sub();
		
		
	}

}
