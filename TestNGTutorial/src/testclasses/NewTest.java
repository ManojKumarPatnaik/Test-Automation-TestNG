package testclasses;

import org.junit.Assert;
import org.testng.annotations.Test;

public class NewTest {
	@Test
	public void testStrings() {
		System.out.println("Running Test---> TestStrings");
		String actual = "Hello";
		String expected = "Hello";
		// String expected = "HELLO";
		Assert.assertEquals(actual, expected);
		System.out.println("Ending Test---> TestStrings");
	}
}
