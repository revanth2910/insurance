package test_cases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

// import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	
	public static WebDriver driver;
	static Logger logger;
	
	@Parameters("Browser")
	@BeforeClass
	public void setup(String brow)
	{
		if(brow.equalsIgnoreCase("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			
			// WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", "./driver//chromedriver.exe");
			driver=new ChromeDriver();	// add (options) to do headless browsing		
		}
		
		else if(brow.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./driver//geckodriver.exe");
			// WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		else if(brow.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", "./driver//IEDriverServer.exe");
			// WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		
		driver.get("https://www.westlandinsurance.ca/");
		
		logger = Logger.getLogger("Base class");
		PropertyConfigurator.configure("Log4j.properties");	
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	// will generate a random email with 8 letters
	
	public String randomEmail()
	{
		String em = RandomStringUtils.randomAlphabetic(8);
		return em;
	}
	
	// will generate a random number with 9 digits
	
	public String randomNumber()
	{
		String no = RandomStringUtils.randomNumeric(10);
		return no;
	}
	
	// to capture Screenshots
	
	public void captureScreen(WebDriver driver, String name) throws IOException
	{

	    String time = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date()); // time stamp  // SimpleDateFormat
	     
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(System.getProperty("user.dir")+"/sreenshots/"+ name + time +".png");
		FileUtils.copyFile(src, trg);
	}
}
