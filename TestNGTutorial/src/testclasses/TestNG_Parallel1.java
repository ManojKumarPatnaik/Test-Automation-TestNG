package testclasses;

import org.testng.annotations.Test;

public class TestNG_Parallel1 {
	@Test
	public void testMethod1() throws InterruptedException {
		System.out.println("TestNG _Parallel -> testMethod1");
		Thread.sleep(5000);
		System.out.println("More Methods");
	}

	@Test
	public void testMethod2() throws InterruptedException {
		System.out.println("TestNG _Parallel -> testMethod2");
		Thread.sleep(5000);
		System.out.println("More Methods...-=>");
	}
}
