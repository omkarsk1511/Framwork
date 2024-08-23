package mocktest.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mocktest.actiondriver.Action;
import mocktest.base.BaseClass;

public class BatchesPage extends BaseClass{
	Action action= new Action();
	
	@FindBy(xpath = "//a[@class='btn btn-primary1']")
	private WebElement addBatchBtn;	
	
	public BatchesPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String getCurrURL() throws Throwable {
		String BatchesPageUrl=action.getCurrentURL(getDriver());
		return BatchesPageUrl;
	}
	
	public boolean validateAddBatchBtn() throws Throwable {
		return action.isDisplayed(getDriver(), addBatchBtn);
		
	}
	
	public AddBatchPage clickOnAddBatch() {
		action.JSClick(getDriver(), addBatchBtn);
		return new AddBatchPage();
	}

}
