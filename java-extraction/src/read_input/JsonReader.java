package read_input;

import java.io.File; // Find a file by path.
import java.io.IOException; // Throw IO Exception.
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException; // Throw Jackson exception.
import com.fasterxml.jackson.databind.JsonMappingException; // Throw Jackson exception.
import com.fasterxml.jackson.databind.JsonNode; // Represent attributes of json file.
import com.fasterxml.jackson.databind.ObjectMapper; // Object for read Json file.

import model.Flat;

public class JsonReader {
	
	// Convert a json file into a JsonNode (Java object).
	public static JsonNode jsonToObject(String jsonFile) throws JsonParseException, JsonMappingException, IOException {
		
		// Object for read Json file.
		ObjectMapper mapper = new ObjectMapper();

		// Read file input json-input/flats.json
		JsonNode rootNode = mapper.readValue(new File(jsonFile), JsonNode.class);
		
		return rootNode;
		
	}
	
	// Extract location and flat price from a JsonNode and insert it in a Flat object.
	public static void JsonObjectToFlat(JsonNode groupNode, List<Flat> flats ){
		
		for (JsonNode gn : groupNode) {

			JsonNode searchResultsNode = gn.get("Searchresult link").path(0);

			JsonNode textNode = searchResultsNode.get("text");

			JsonNode priceNode = gn.get("Price value").path(0);
			
			// The flat location.
			String location = textNode.textValue();

			// The flat price.
			String price = priceNode.get("text").textValue();

			Flat flat = new Flat (location,price);
			flats.add(flat);

		} // end for	
		
		
	}	

}
