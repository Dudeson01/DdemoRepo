package books;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import genericutility.BaseClass;
import genericutility.ListenerUtility;
import objectrepository.HomePage;
@Listeners(ListenerUtility.class)
public class TC_DWS_001_Test extends BaseClass {
	
	
	
	@Test
	public void clickOnBooks() {
	//	ExtentTest test = extReport.createTest("clickOnBooks");
		HomePage hp=new HomePage(driver);
		hp.getBooksBtn().click();
		
		//Assert.assertEquals(driver.getTitle(),"Demo Web Shop. Books","Books page is not displayed");//OnTestSuccess methos will be called

		Assert.assertEquals(driver.getTitle(),"Demo Shop. Books","Books page is not displayed");//OnTestFailure method will be called
		test.log(Status.PASS,"Books page is diusplayed");
		test.log("to check the modification done in github is being reflected on ecliplse after pulling it")
	}

}
