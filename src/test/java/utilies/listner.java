package utilies;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.*;

public class listner extends TestListenerAdapter {
  
   public WebDriver driver;
   
   public ExtentHtmlReporter htmlReporter;  // import all the classes
   public ExtentReports extent;
   public ExtentTest test;

   public void onStart(ITestContext testContext) // this will do the extent setup for the report  
   {
     String time = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date()); // time stamp  // SimpleDateFormat
     String repName = "Report-" + time+".html";

     htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName); //path to store extent report // inside test-output folder
     htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml"); // this will load the extent-config.xml file

     htmlReporter.config().setDocumentTitle("WestLand Insurance"); // title of the report
     htmlReporter.config().setReportName("Report of Request Quote"); // name of the report
     htmlReporter.config().setTheme(Theme.DARK);

     extent = new ExtentReports();
     extent.attachReporter(htmlReporter); // we need to add  htmlReporter to this so we can add generic info like(os, browsername) 
     extent.setSystemInfo("host", "LocalHost");    // extent.setSystemInfo(key, value);
     extent.setSystemInfo("os", "windows");
     extent.setSystemInfo("browser", "chrome");
     extent.setSystemInfo("executer","name");    // these will be shown in extent report
   }
   
   public void onFinish(ITestContext testContext)
   {
      extent.flush();  // this will flush the report
   }
   
   public void onTestSuccess(ITestResult result)  // result contains the name of the test case
   {
     test = extent.createTest(result.getName());  // create new entry in the report
     test.log(Status.PASS,MarkupHelper.createLabel(result.getName(),ExtentColor.GREEN));
   }

   public void onTestSkipped(ITestResult result)
   {
     test = extent.createTest(result.getName());  // create new entry in the report
     test.log(Status.SKIP,MarkupHelper.createLabel(result.getName(),ExtentColor.ORANGE));
   }

   public void onFailure(ITestResult result)  // ITestResult contains status of the test (fail, skip, success,...) // result is the obj of ITestResult
   {
     test = extent.createTest(result.getName());  // create new entry in the report
     test.log(Status.FAIL,MarkupHelper.createLabel(result.getName(),ExtentColor.RED));

     String time = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
     String screenshotpath = System.getProperty("user.dir")+"\\screenshots\\"+result.getName() + time + ".png";

     File trg = new File(screenshotpath);

     if (trg.exists())
     {
       try
       {
          test.fail("msg" + test.addScreenCaptureFromPath(screenshotpath));
       }
       catch (IOException e)
       {
          e.printStackTrace();
       }
     }
   } 
}