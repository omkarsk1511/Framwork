package mocktest.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;

    public static void setExtent() {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/ExtentReport/" + "MyReport" + ".html");
        htmlReporter.config().setDocumentTitle("Automation Report"); // Title of the report
        htmlReporter.config().setReportName("Functional Testing"); // Name of the report
        // htmlReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "localhost");
        extent.setSystemInfo("Environment", "Prod");
        extent.setSystemInfo("User Name", "Omkar");
    }

    public static void endReport() {
        extent.flush();
    }
}
