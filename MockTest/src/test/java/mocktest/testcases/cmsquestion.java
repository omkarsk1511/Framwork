package mocktest.testcases;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mocktest.actiondriver.Action;
import mocktest.base.BaseClass;
import mocktest.dataprovider.Data;
import mocktest.pageobjects.AcademicCyclePage;
import mocktest.pageobjects.AddBatchPage;
import mocktest.pageobjects.BatchesPage;
import mocktest.pageobjects.HomePage;
import mocktest.pageobjects.LoginPage;
import mocktest.utility.Log;

public class cmsquestion extends BaseClass {
	private LoginPage loginPage;
	private HomePage homePage;
	private AcademicCyclePage academicCyclePage;
	private Data data;
	
	Action action= new Action();


	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setup(String browser) throws InterruptedException {
		launchApp(browser);
		loginPage = new LoginPage();	
	}

	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() {
		//getDriver().quit();
	}
	
	
	
	@Test(groups = {"Smoke"}, priority = 1)
	public void addacademiccycleBtnTest() throws Throwable {
		 Log.startTestCase("addacademiccycleBtnTest");
	        homePage = loginPage.login(homePage);
	        String[] cms_id = {"201370",
	        		"201336",
	        		"202036",
	        		"202120",
	        		"200704",
	        		"200273",
	        		"199665",
	        		"202015",
	        		"201275",
	        		"200262",
	        		"201358",
	        		"201365",
	        		"201341",
	        		"488525",
	        		"200286",
	        		"200693",
	        		"202031",
	        		"200709",
	        		"200716",
	        		"200707",
	        		"488197",
	        		"201302",
	        		"201327",
	        		"202088",
	        		"201337",
	        		"202108",
	        		"202117",
	        		"488182",
	        		"199647",
	        		"201289",
	        		"202095",
	        		"201344",
	        		"200277",
	        		"201309",
	        		"199638",
	        		"199672",
	        		"199669",
	        		"201339",
	        		"202027",
	        		"200267",
	        		"202026",
	        		"199641",
	        		"201347",
	        		"200715",
	        		"202071",
	        		"201281",
	        		"202110",
	        		"199674",
	        		"201296",
	        		"202024",
	        		"200726",
	        		"202985",
	        		"202933",
	        		"202987",
	        		"202771",
	        		"199693",
	        		"202872",
	        		"202847",
	        		"202772",
	        		"202897",
	        		"202600",
	        		"202896",
	        		"199689",
	        		"202810",
	        		"202964",
	        		"203110",
	        		"202546",
	        		"202572",
	        		"200309",
	        		"202953",
	        		"202553",
	        		"200742",
	        		"202979",
	        		"202573",
	        		"202949",
	        		"200297",
	        		"202873",
	        		"202577",
	        		"202564",
	        		"202939",
	        		"202545",
	        		"202773",
	        		"487959",
	        		"200728",
	        		"200294",
	        		"202814",
	        		"488023",
	        		"202608",
	        		"202586",
	        		"202581",
	        		"202998",
	        		"202875",
	        		"202811",
	        		"202906",
	        		"488491",
	        		"202887",
	        		"202997",
	        		"203002",
	        		"202882",
	        		"202779",
	        		"418368",
	        		"418465",
	        		"417095",
	        		"429003",
	        		"428783",
	        		"418469",
	        		"418370",
	        		"417087",
	        		"429520",
	        		"428593",
	        		"418369",
	        		"418461",
	        		"418251",
	        		"427734",
	        		"427730",
	        		"427727",
	        		"418363",
	        		"418446",
	        		"418266",
	        		"427818",
	        		"427814",
	        		"427733",
	        		"427727"};
	        WebDriver driver = getDriver();
	        JavascriptExecutor js = (JavascriptExecutor) driver;

	        for (int i = 0; i < cms_id.length; i++) {
	            // Open a new tab using JavaScript
	            js.executeScript("window.open('about:blank', '_blank');");

	            // Get all window handles
	            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

	            // Switch to the new tab
	            driver.switchTo().window(tabs.get(tabs.size() - 1));

	            // Construct the URL and navigate to it
	            String url = "https://cms.bemasterly.com/CMS-preview/question.php/?post_type=question&author=18&p=" + cms_id[i];
	            driver.get(url);
	        }
	}

}
