package mocktest.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mocktest.actiondriver.Action;
import mocktest.base.BaseClass;

public class AcademicCyclePage extends BaseClass{
	Action action= new Action();
	
	@FindBy(xpath = "//a[@class='btn btn-primary1']")
	private WebElement addAcademiccycleBtn;	
	
	public AcademicCyclePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String getCurrURL() throws Throwable {
		String AcademicCyclePageUrl=action.getCurrentURL(getDriver());
		return AcademicCyclePageUrl;
	}
	
	public boolean validateAddacademiccycleBtn() throws Throwable {
		return action.isDisplayed(getDriver(), addAcademiccycleBtn);
		
	}
	
	public AddAcademiccyclePage clickOnAddAcademiccycle() {
		action.JSClick(getDriver(), addAcademiccycleBtn);
		return new AddAcademiccyclePage();
	}
	
}
