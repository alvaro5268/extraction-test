package read_input;

import java.io.File; // Find a file by path.
import java.io.IOException; // Throw IO Exception.

import com.fasterxml.jackson.core.JsonGenerationException; // Throw Jackson exception.
import com.fasterxml.jackson.databind.JsonMappingException; // Throw Jackson exception.
import com.fasterxml.jackson.databind.JsonNode; // Represent attributes of json file.
import com.fasterxml.jackson.databind.ObjectMapper; // Object for read Json file.

public class JsonReader {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {

		// Object for read Json file.
		ObjectMapper mapper = new ObjectMapper();

		// Read file input json-input/flats.json
		JsonNode rootNode = mapper.readValue(new File("json-input\\flats.json"), JsonNode.class);

		// Extract different attributes of json-input/flats.json
		// in order to find location and price flat (see flats.json)
		JsonNode resultsNode = rootNode.get("result");

		JsonNode extractorDataNode = resultsNode.get("extractorData");

		JsonNode dataNode = extractorDataNode.get("data").path(0);

		JsonNode groupNode = dataNode.get("group");

		for (JsonNode gn : groupNode) {

			JsonNode searchResultsNode = gn.get("Searchresult link").path(0);

			JsonNode textNode = searchResultsNode.get("text");

			// The flat location.
			String location = textNode.textValue();

			JsonNode priceNode = gn.get("Price value").path(0);

			// The flat price.
			String price = priceNode.get("text").textValue();

			System.out.println("Location:" + location);

			System.out.println("Location:" + price);

		}

	}

}
