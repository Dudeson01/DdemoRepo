package genericutility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import objectrepository.HomePage;
import objectrepository.LogInPage;
import objectrepository.WelcomePage;

public class BaseClass {
	public static ExtentReports extReport;
	public static WebDriver driver;
	public static ExtentTest test; 
	
	JavaUtility jUtil=new JavaUtility();
	WebDriverUtility wUtil=new WebDriverUtility();
	FileUtiliy fUtil=new FileUtiliy();
	
	@BeforeSuite
	public void reportConfig() {
		
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_reports/"+jUtil.getSystemTime()+".html");
		extReport=new ExtentReports();
		extReport.attachReporter(spark);
	}
	
	@BeforeClass
	public void openBrowser() throws IOException {
		driver=new ChromeDriver();
		wUtil.maximize(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(fUtil.getDataFromProperty("url"));
		
	}
	
	@BeforeMethod
	public void login() throws IOException {
		WelcomePage wp=new WelcomePage(driver);
		wp.getLoginLink().click();
		
		LogInPage lp=new LogInPage(driver);
		lp.getEmail().sendKeys(fUtil.getDataFromProperty("email"));
		lp.getPassword().sendKeys(fUtil.getDataFromProperty("pass"));
		lp.getLogInbtn().click();
	}
	
	@AfterMethod
	public void logOut() {
		HomePage hp=new HomePage(driver);
		hp.getLogoutBtn().click();
	}
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	@AfterSuite
	public void reportBackup() {
		extReport.flush();
	}

}
