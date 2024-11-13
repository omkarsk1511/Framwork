package mocktest.pageobjects;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import mocktest.actiondriver.Action;
import mocktest.base.BaseClass;

public class AddMarkPage extends BaseClass {
	Action action = new Action();

	@FindBy(id = "examname")
	private WebElement examName;

	@FindBy(id = "offerings")
	private WebElement offering;

	@FindBy(xpath = "//div[@class='col-md-6 pb-2']//div[@class='multiselect-dropdown']")
	private WebElement batch;

	@FindBy(xpath = "//div[@class='col-md-6 pb-2']//div[2]//input[1]")
	private WebElement batch1;

	@FindBy(xpath = "//div[@class='col-md-6 pb-2']//div[@class='multiselect-dropdown-all-selector']//input[@type='checkbox']")
	private WebElement allBatch;

	@FindBy(xpath = "//div[@class='col-md-6 homework form-group pb-2']//div[@class='multiselect-dropdown']")
	private WebElement sub;

	@FindBy(xpath = "//div[@class='col-md-6 homework form-group pb-2']//div[@class='form-group custSelectColor']//div[2]//input[1]")
	private WebElement sub1;

	@FindBy(xpath = "//div[@class='multiselect-dropdown-all-selector']//input[@type='checkbox']")
	private WebElement allSub;

	@FindBy(id = "sub-mark-18400")
	private WebElement totalMarks;

	@FindBy(id = "sub-min-mark-18400")
	private WebElement minMarks;

	@FindBy(id = "button_page_1")
	private WebElement save;

	@FindBy(xpath = "//select[@name='studentSubjectMarksTable_length']")
	private WebElement records;

	@FindBy(xpath = "//option[@value='100']")
	private WebElement records100;

	@FindBy(xpath = "//tr[contains(@id, 'tr-st-')]//input[contains(@name, 'absent_')]")
	private List<WebElement> checkboxes;

	@FindBy(xpath = "//li[@id='studentSubjectMarksTable_next']")
	private WebElement next;
	
	@FindBy(xpath = "//*[@id=\"mpm-submit-btn\"]")
	private WebElement submit;
	
	@FindBy(xpath = "//p[@id='examname-error']")
    private WebElement examNameDisclaimer;
	
	
	

	public AddMarkPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public String getCurrURL() throws Throwable {
		String addMarkPageURL = action.getCurrentURL(getDriver());
		return addMarkPageURL;
	}

	public void examName(String NameOfExam) throws Throwable {
		Thread.sleep(7000);
		action.type(examName, NameOfExam);
	}

	public void selectOffering(int index) throws Throwable {
		action.selectByIndex(offering, index);
	}

	public void selectBatch() throws Throwable {
		// action.fluentWait(getDriver(), subject, 2);
		action.JSClick(getDriver(), batch);
		// action.fluentWait(getDriver(), batch1, 3);
		action.JSClick(getDriver(), batch1);
		Thread.sleep(1000);
	}

	public void selectAllBatch() throws Throwable {
		// action.fluentWait(getDriver(), subject, 2);
		action.JSClick(getDriver(), batch);
		action.fluentWait(getDriver(), allBatch, 3);
		action.JSClick(getDriver(), allBatch);
	}

	public void selectSub() throws Throwable {
		// action.fluentWait(getDriver(), subject, 2);
		action.JSClick(getDriver(), sub);
		// action.fluentWait(getDriver(), sub1, 3);
		action.JSClick(getDriver(), sub1);
		Thread.sleep(1000);
	}

	public void selectAllSub() throws Throwable {
		// action.fluentWait(getDriver(), subject, 2);
		action.JSClick(getDriver(), sub);
		action.fluentWait(getDriver(), allSub, 3);
		action.JSClick(getDriver(), allSub);
	}

	public void totalMarks(String marks) throws Throwable {
		action.type(totalMarks, marks);
	}

	public void minMarks(String marks) throws Throwable {
		action.type(minMarks, marks);
	}

	public void save() throws Throwable {
		// action.fluentWait(getDriver(), subject, 2);
		action.JSClick(getDriver(), save);
	}

	public void allAbsent() throws Throwable {
		while (true) {
			for (WebElement checkbox : checkboxes) {
				if (!checkbox.isSelected()) { // Check if the checkbox is not already selected
					action.JSClick(getDriver(), checkbox);
				}
			}
			try {
				action.JSClick(getDriver(), submit);
                break; 
            }
			catch (NoSuchElementException e) {
			try {
				action.JSClick(getDriver(), next);
			} catch (NoSuchElementException ex) {
				break;
			} catch (Exception ey) {
				e.printStackTrace();
			}
		}
	}
	}
	
	public void submit() throws Throwable {
		// action.fluentWait(getDriver(), subject, 2);
		action.JSClick(getDriver(), submit);
	}

	public void records() throws Throwable {
		action.scrollByVisibilityOfElement(getDriver(), records);

		action.fluentWait(getDriver(), records, 2);
		action.JSClick(getDriver(), records);
		action.JSClick(getDriver(), records100);

	}

	/*
	 * public void selectRecords(int index) throws Throwable {
	 * action.scrollByVisibilityOfElement(getDriver(), records);
	 * action.selectByIndex(records, index); }
	 */
	
	public boolean isExamNameValid(String examNameText) {
        return examNameText.matches("^[a-zA-Z0-9_\\- ]+$");
    }

    public String getExamNameDisclaimer() {
        return examNameDisclaimer.getText();
    }
}
