package testclasses;

import org.testng.annotations.Test;

public class TestNG_Parallel {
	@Test
	public void testMethod1() throws InterruptedException {
		System.out.println("TestNG _Parallel-1 -> testMethod1");
		Thread.sleep(5000);
		System.out.println("More Methods");
	}

	@Test
	public void testMethod2() throws InterruptedException {
		System.out.println("TestNG _Parallel-1 -> testMethod2");
		Thread.sleep(5000);
		System.out.println("More Methods...-=>");
	}
}
