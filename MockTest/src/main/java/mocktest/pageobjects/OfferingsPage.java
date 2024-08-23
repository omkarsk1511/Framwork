package mocktest.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mocktest.actiondriver.Action;
import mocktest.base.BaseClass;

public class OfferingsPage extends BaseClass {
	Action action = new Action();

	@FindBy(xpath = "//a[@class='btn btn-primary1']")
	private WebElement addOfferingsBtn;

	@FindBy(xpath = "//*[@id=\"filtertable\"]/tbody")
	private List<WebElement> offList;

	public OfferingsPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public String getCurrURL() throws Throwable {
		String offeringsPageURL = action.getCurrentURL(getDriver());
		return offeringsPageURL;
	}

	public int getColumncount(WebElement row) {
		List<WebElement> columns = row.findElements(By.tagName("td"));
		int a = columns.size();
		System.out.println(columns.size());
		for (WebElement column : columns) {
			System.out.print(column.getText());
			System.out.print("|");
		}
		return a;
	}

	public boolean validateAddOfferingsBtn() throws Throwable {
		return action.isDisplayed(getDriver(), addOfferingsBtn);
	}

	public AddOfferingsPage clickOnAddOfferings() {
		action.JSClick(getDriver(), addOfferingsBtn);
		return new AddOfferingsPage();
	}

}
