package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(linkText="Log out")
	private WebElement logoutBtn;
	
	@FindBy(partialLinkText ="Books")
	private WebElement booksBtn;
	
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver,this);
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public WebElement getBooksBtn() {
		return booksBtn;
	}
	
	
	
	

}
