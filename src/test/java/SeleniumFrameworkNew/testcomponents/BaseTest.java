package SeleniumFrameworkNew.testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import framework.pageobjects.Landingpage;

public class BaseTest {
public WebDriver driver;
	public Landingpage landing;

	
	public WebDriver intializeDriver() throws IOException
	 
	{
  
	//properties class
		Properties pro=new Properties();
		 FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\framework\\resources\\GlobalData.properties");
		 pro.load(fis);
		 String browsername= System.getProperty("browser")!= null ?  System.getProperty("browser") :pro.getProperty("browser");
		//pro.getProperty("browser");
		 if(browsername.contains("chrome"))
		 {
			 ChromeOptions options = new ChromeOptions(); 
			 options.addArguments("--incognito"); // Open Chrome in incognito mode
			 options.addArguments("--start-maximized");
			 if(browsername.contains("headless"))
			 {
				options.addArguments("headless");
			 }
			 driver = new ChromeDriver(options);
			// options.addArguments("--start-maximized");
		 }
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 return driver;		  
	}
	
	public String getScreenshot(String testcasename,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		 File File = new File(System.getProperty("user.dir")+"//reports//" +testcasename +".png");

	     FileUtils.copyFile(source, File);
	     return System.getProperty("user.dir")+"//reports//" +testcasename +".png";
	}
	
	@BeforeMethod(alwaysRun=true)
	public Landingpage launchApplication() throws IOException
	{
		driver=intializeDriver();
		 landing = new Landingpage(driver);
		landing.geturl();
        return landing;
       
	}

	/*
	 * public List<HashMap<String,String>> getjsonDataToMap(String filepath) throws
	 * IOException {
	 * 
	 * 
	 * 
	 * String jsoncontent=FileUtils.readFileToString(new
	 * File(filepath),StandardCharsets.UTF_8);
	 * 
	 * 
	 * ObjectMapper mapper=new ObjectMapper(); List<HashMap<String,String>>
	 * data=mapper.readValue(jsoncontent, new
	 * TypeReference<List<HashMap<String,String>>>() { });
	 * 
	 * return data; }
	 */
	
	
	 

	@AfterMethod(alwaysRun=true)
	  
	  public void tearDown() 
	  {
		  driver.close(); 
		  }

	
	
	
	
}

