package mjaacademy.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.List;



public class DataReader {

	
	public  List<HashMap<String, String>> getJsonDataToMap() throws StreamReadException, DatabindException, IOException {
		
		
		String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "\\src\\test\\java\\mjaacademy\\data\\PurchaseOrder.json")
				,StandardCharsets.UTF_8);
		
		//jackson lib converting string to hashmap
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<HashMap<String,String>> data =mapper.readValue(jsonContent,new TypeReference<List<HashMap<String,String>>>(){});
		
		return data;
		
	}
	

}
