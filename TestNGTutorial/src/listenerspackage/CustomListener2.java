package listenerspackage;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class CustomListener2 implements ITestListener {

	

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("On test Success -->testName: " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("On testFailure -->testName: " + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("On test Skipped -->testName: " + result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onStart(ITestContext context) {

		// This executes before the test tag of xml file is started
		System.out.println("On test Start -->testName: " + context.getName());

		// getting name if all the methods
		ITestNGMethod methods[] = context.getAllTestMethods();
		System.out.println("This methods will be executed in this test tag");

		for (ITestNGMethod method : methods) {
			System.out.println(method.getMethodName());
		}

	}

}
