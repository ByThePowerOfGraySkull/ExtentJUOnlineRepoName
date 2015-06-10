package advancejunitreport;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class AdvanceReportTest {
	
	@Test
	public void myTest(){
		ExtentReports extent = ExtentReports.get(AdvanceReportTest.class); 
		extent.init("C:\\Users\\Rahul.Kulkarni\\workspace\\ExtentJUnitReportTest\\reports\\Extent.html", true);
		extent.config().documentTitle("Rahuls Report").useExtentFooter(false).displayCallerClass(false);
		extent.startTest("Verify Page Title");
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://learn-automation.com/");
		extent.log(LogStatus.INFO, "Loaded Website <span class='label success'>Success</span>");
		
		String title = driver.getTitle();
		extent.log(LogStatus.INFO, "Getting Title");
		
		Assert.assertTrue(title.contains("Selenium"));
		extent.log(LogStatus.PASS, "Title Verified");
		
		extent.attachScreenshot("C:\\Users\\Rahul.Kulkarni\\workspace\\ExtentReportTest\\fail1.png");
		extent.endTest();
		driver.quit();
	}

}
