package extentreports;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {
	
	public static ExtentReports getInstance() {
		
		ExtentReports extent;
		String path=System.getProperty("user.dir") + "//ExtentReports//ExtentReportResults.html";
		extent =new ExtentReports(path,false);
		extent.addSystemInfo("Selenium Version","3.141.59").addSystemInfo("Platform", "Windows");
		
				
		return extent;
	}

}
