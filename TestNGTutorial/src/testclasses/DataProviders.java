package testclasses;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "input")
	public Object [][]  getData(){
		return new Object[][] {
			{"Wonder","Woman"},
			{"Tony","Stark"},
			{"Ethan","Hunt"}			
		};
	}
	
}
