package advancejunitreport;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class MySecondTest {
	@Test
	public void myTest(){
		ExtentReports extent = ExtentReports.get(AdvanceReportTest.class); 
		extent.init("C:\\Users\\Rahul.Kulkarni\\workspace\\ExtentJUnitReportTest\\reports\\Extent.html", true);
		extent.config().documentTitle("Rahuls 2nd Report").useExtentFooter(false).displayCallerClass(false);
		extent.startTest("Verify Page Title");
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://www.google.com/");
		extent.log(LogStatus.INFO, "Loaded Website <span class='label success'>Success</span>");
		
		String title = driver.getTitle();
		extent.log(LogStatus.INFO, "Getting Title");
		
		Assert.assertTrue(title.contains("Google"));
		extent.log(LogStatus.PASS, "Title Verified");
		
		extent.attachScreenshot("C:\\Users\\Rahul.Kulkarni\\workspace\\ExtentReportTest\\fail1.png");
		extent.log(LogStatus.INFO, "Showing Image");
		extent.endTest();
		driver.quit();
	}
}
