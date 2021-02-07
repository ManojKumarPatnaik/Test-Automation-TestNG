package testclasses;

import org.testng.annotations.Test;

import listenerspackage.CustomListener1;
import listenerspackage.CustomListener2;
import listenerspackage.CustomListeners;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.junit.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

//@Listeners(CustomListener1.class)
//@Listeners(CustomListener2.class)
@Listeners(CustomListeners.class)
public class TestNG_Listener1 {

	//We can use Reporter class to log the reports instead of using the println.This also generates the index.html log file
	@BeforeClass
	public void beforeClass() {
		//System.out.println("Code in the before class");
		Reporter.log("Code in the before class",true);
	}

	@Test
	public void testMethod1() {
		//System.out.println("Code in the method1");
		Reporter.log("Code in the method1",true);

		Assert.assertTrue(true);
	}

	@Test
	public void testMethod2() {
		System.out.println("Code in the method2 ");
		
		Reporter.log("Code in the method2",true);
		
		Assert.assertTrue(false);
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Code in the after class");
	}

}
