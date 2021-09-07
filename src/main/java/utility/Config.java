package utility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.*;
import org.json.simple.parser.*;

public class Config {
	
	JSONParser jsonParser = new JSONParser();
	
	
	public String getBaseUrl() {
		
		String baseUrl;
		String enviro = "";
		
		
		JSONObject jsonObject = null;
		
		try {
			FileReader reader = new FileReader("resources/baseurl.json");
			Object obj = jsonParser.parse(reader);
			jsonObject = (JSONObject) obj;
		} catch(Exception e) {
			e.printStackTrace();
		}

		assert jsonObject != null;
		baseUrl = (String)jsonObject.get("UAT");

		return baseUrl;
	}
}
