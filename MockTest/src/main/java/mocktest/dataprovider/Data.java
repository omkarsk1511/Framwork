package mocktest.dataprovider;

import mocktest.utility.NewExcelLibrary;

public class Data {
	static NewExcelLibrary obj = new NewExcelLibrary();

	public static String loginPageUrl() {
		String loginPageUrl = obj.getCellData("Credentials", "loginPageUrl", 2);
		return loginPageUrl;
	}

	public static String adminUName() {
		String adminUName = obj.getCellData("Credentials", "adminUName", 2);
		return adminUName;
	}

	public static String adminPass() {
		String adminPass = obj.getCellData("Credentials", "adminPass", 2);
		return adminPass;
	}

	public static String studentUName() {
		String adminUName = obj.getCellData("Credentials", "studentUName", 2);
		return adminUName;
	}

	public static String studentPass() {
		String adminPass = obj.getCellData("Credentials", "studentPass", 2);
		return adminPass;
	}

	public static String adminHomePageUrl() {
		String adminHomePageUrl = obj.getCellData("Credentials", "adminHomePageUrl", 2);
		return adminHomePageUrl;
	}

	public static String offeringsPageUrl() {
		String offeringsPageUrl = obj.getCellData("OfferingsPage", "offeringsPageUrl", 2);
		return offeringsPageUrl;
	}
	
	public static String offExistFlash() {
		String offExistFlash = obj.getCellData("OfferingsPage", "offExistFlash", 2);
		return offExistFlash;
	}
	public static String succFlshMsg() {
		String succFlshMsg = obj.getCellData("OfferingsPage", "succFlshMsg", 2);
		return succFlshMsg;
	}

	public static String academicCyclePageUrl() {
		String offeringsPageUrl = obj.getCellData("AcademicyearsPage", "academicyearsPageUrl", 2);
		return offeringsPageUrl;
	}

	public static String acadExistFlash() {
		String acadExistFlash = obj.getCellData("AcademicyearsPage", "acadExistFlash", 2);
		return acadExistFlash;
	}
	
	public static String acadsuccFlshMsg() {
		String acadsuccFlshMsg = obj.getCellData("AcademicyearsPage", "acadsuccFlshMsg", 2);
		return acadsuccFlshMsg;
	}
	
	public static String batchExistFlash() {
		String batchExistFlash = obj.getCellData("BatchesPage", "batchExistFlash", 2);
		return batchExistFlash;
	}
	
	public static String batchsuccFlshMsg() {
		String batchsuccFlshMsg = obj.getCellData("BatchesPage", "batchsuccFlshMsg", 2);
		return batchsuccFlshMsg;
	}
	
	public static String batchesPagePageUrl() {
		String offeringsPageUrl = obj.getCellData("BatchesPage", "batchesPagePageUrl", 2);
		return offeringsPageUrl;
	}
	
	public static String testProPageUrl() {
		String testProPageUrl = obj.getCellData("TesproPage", "testProPageUrl", 2);
		return testProPageUrl;
	}
	
	public static String resultPageUrl() {
		String resultPageUrl = obj.getCellData("TesproPage", "testProPageUrl", 2);
		return resultPageUrl;
	}
	
}
