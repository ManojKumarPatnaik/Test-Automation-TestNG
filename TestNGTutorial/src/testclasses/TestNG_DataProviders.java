package testclasses;

import static org.testng.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestNG_DataProviders {

//	@DataProvider(name="input")
//	public Object [][]  getData(){
//		return new Object[][] {
//			{"Wonder","Woman"},
//			{"Tony","Stark"},
//			{"Ethan","Hunt"}			
//		};
//	}

	@Test(dataProvider = "input", dataProviderClass = DataProviders.class) // The above commented method is called from
																			// seperate DataProviders class
	public void test(String firstName, String lastName) {
		System.out.println("My Name is " + firstName + " " + lastName);

	}
}
