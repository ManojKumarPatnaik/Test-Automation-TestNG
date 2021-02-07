package testclasses;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSuite {

	@BeforeMethod
	public void setUp() {
		System.out.println("Runs before every Method ");
	}

	@Test(priority = 1)
	public void test() {
		System.out.println("Running the test -class2- (priority = 0)(priority = 0)-> test1");

	}

	@Test(priority = 0)
	public void test1() {
		System.out.println("Running the test -class2-->test 2");
	}

	@Test(timeOut = 500) // setting time to run a method-if it runs for more time the testNG will fail
							// the method
	public void test2() {
		System.out.println("Running the test -class2-->test 2");
	}

	@AfterMethod(enabled = false) // to disable the method
	public void tearDown() {
		System.out.println("Runs after every Method ");
	}

	// This testsuite is run from the testing.xml
}
