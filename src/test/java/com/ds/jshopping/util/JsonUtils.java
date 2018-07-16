package com.ds.jshopping.util;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	
	
	public static String converToJson( Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = new String();
		String file = "/Users/deepaksharma/myproject/jshopping/server/src/main/resources/testData/pRequest.json";

		try {
			// Convert object to JSON string and save into a file directly
			mapper.writeValue(new File(file), obj);

			// Convert object to JSON string
			 jsonInString = mapper.writeValueAsString(obj);
		//	System.out.println(jsonInString);

			// Convert object to JSON string and pretty print
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
		//	System.out.println(jsonInString);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return  jsonInString;
	}
	
}
