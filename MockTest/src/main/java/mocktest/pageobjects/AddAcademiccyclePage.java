package mocktest.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mocktest.actiondriver.Action;
import mocktest.base.BaseClass;
import mocktest.dataprovider.Data;

public class AddAcademiccyclePage extends BaseClass {
	
	
Action action= new Action();
	
	@FindBy(id="academicName")
	private WebElement academicName;
	
	@FindBy(id="offeringName")
	private WebElement offeringName;
	
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement save;

	@FindBy(id="flash_message")
	private WebElement flshMsg;
	
	
	
	
	public AddAcademiccyclePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void nameOfAcad(String acadName) throws Throwable {
		action.type(academicName, acadName);
	}
	
	public void selectoffering(int index) throws Throwable {
		action.selectByIndex(offeringName, index);
	}
	
	public void clicOnSave() throws Throwable {
		action.JSClick(getDriver(),save);
	}
	
	
	public boolean validateFlshMsgAct() throws Throwable {
		return action.isDisplayed(getDriver(), flshMsg);
	}
	
	public String flshMsgAct() throws Throwable{
		action.fluentWait(getDriver(), flshMsg, 3);
		String flshMsgAct=action.getText(flshMsg);
		return flshMsgAct;
	}
	
	
}
