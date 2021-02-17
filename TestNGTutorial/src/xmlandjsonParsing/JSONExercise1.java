package xmlandjsonParsing;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONExercise1 {

	private JSONArray address;
	

	public JSONArray ReadFile(String filename) {
		try {
			address = new JSONArray();
			JSONParser jsonParser = new JSONParser();
			// Parsing the contents of the JSON file
			JSONObject jsonObject = (JSONObject) jsonParser
					.parse(new FileReader(System.getProperty("user.dir") + "//" + filename));

			address = (JSONArray) jsonObject.get("Addresses");
			//System.out.println(address.get(1));
			
			return address;
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;

	}

	public String getNickName(int id) {
		
		JSONObject obj=(JSONObject)address.get(id-1);
		//System.out.println(obj);
		return (String)obj.get("NickName");
		
		//		input=(JSONArray) address.get(id-1);
//		
//		JSONObject obj=(JSONObject) new JSONObject().put("array", input);
		
		
		//return (String)obj.get("NickName");
		
	}

	public static void main(String[] args) {

		JSONExercise1 ex = new JSONExercise1();
		ex.ReadFile("JSONExercise1.json");
		System.out.println(ex.getNickName(1));

	}
}