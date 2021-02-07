package testclasses;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG_Parameters {

	@Test
	@Parameters({ "browser", "OS" })
	public void testParameters1(String browser, String OS) {
		System.out.println("The value of the paramter 1 is " + browser);
		System.out.println("The value of the paramter 1 is " + OS);
	}

	@Test
	@Parameters({ "responseTime" })
	public void testParameters2(String responseTime) {
		System.out.println("The response Time is " + responseTime);
	}
}
