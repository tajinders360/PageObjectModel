package ExtentReports;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemo

{
	
    //WebDriver driver;
 //public static ExtentReports extent;
    
    @BeforeTest
    public static ExtentReports Config()
    {
    	String path=System.getProperty("user.dir")+"\\reports\\index.html";
    	ExtentSparkReporter reporter=new ExtentSparkReporter(path);
    	reporter.config().setReportName("Web automation Results");
    	reporter.config().setDocumentTitle("Test Results");
    	ExtentReports extent=new ExtentReports();
    	extent.attachReporter(reporter);
    	extent.setSystemInfo("Tester", "Rahul Shetty");
		return extent;
    }
	/*
	 * @Test public void InitialDemo() { ExtentTest
	 * test=extent.createTest("Initial Demo"); ChromeOptions options = new
	 * ChromeOptions(); options.addArguments("--incognito"); // Open Chrome in
	 * incognito mode options.addArguments("--start-maximized"); driver = new
	 * ChromeDriver(options);
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 * driver.get("https://rahulshettyacademy.com/client");
	 * System.out.println(driver.getTitle()); driver.close();
	 * //test.fail("Results do not match"); extent.flush();
	 * 
	 * }
	 */
}
