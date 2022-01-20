package test_cases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import page_obj.Login;
import utilies.XLUtils;

public class Custdetails_DataDriven extends BaseClass {
	
	@Test(dataProvider="custdetail")
	public void CustData(String lno, String fname, String lname, String pcode, String ecity, String pro,String Fname)
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
		
		lo.licenseNo(lno);
		logger.info("enterd license number");
		
		lo.addInfo("i want the best insurance coverage that your can company provides");
		
		lo.firstName(fname);
		logger.info("First name entered");
		
		lo.lastName(lname);
		logger.info("Last name entered");
		
		String num = randomNumber();
		lo.phoneNo(num);
		logger.info("mobile number entered");
		
		String mail = randomEmail()+"@gmail.com";
		lo.enterEmail(mail);
		logger.info("Email entered");
		
		lo.postalCode(pcode);
		logger.info("Postal code entered");
		
		lo.enterCity(ecity);
		logger.info("City name entered");
		
		lo.enterProvince(pro);
		logger.info("Province name entered");
		
		lo.Name(Fname);
		logger.info("Full name entered");
		
		lo.approve();
	}
	
	@DataProvider(name="custdetail")
	Object[][] logData() throws IOException
	{
		String loc = System.getProperty("user.dir")+"/src/test/java/test_data/cust.xlsx";
		
		int rowcount = XLUtils.getRowCount(loc, "custdetails");
		int colcount = XLUtils.getCellCount(loc, "custdetails", 1);
		
		Object log[][] = new Object[rowcount][colcount];
				
		for (int r=1;r<=rowcount;r++)
		{
			for(int c=0;c<colcount;c++)
			{
				log[r-1][c] = XLUtils.getCellData(loc, "custdetails", r, c);
			}
		}
		return log;
	}

}
