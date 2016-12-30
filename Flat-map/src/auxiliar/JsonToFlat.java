package auxiliar;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import beans.FlatCatalogBean;
import model.Flat;


public class JsonToFlat {

	public static JsonNode jsonStringToObject(String jsonString)
			throws JsonParseException, JsonMappingException, IOException {

		// Object for read Json file.
		ObjectMapper mapper = new ObjectMapper();

		// Read file input json-input/flats.json
		JsonNode rootNode = mapper.readValue(jsonString, JsonNode.class);

		return rootNode;

	}

	// Convert a json file into a JsonNode (Java object).
	public static JsonNode jsonFileToObject(String jsonFile)
			throws JsonParseException, JsonMappingException, IOException {

		// Object for read Json file.
		ObjectMapper mapper = new ObjectMapper();

		// Read file input json-input/flats.json
		JsonNode rootNode = mapper.readValue(new File(jsonFile), JsonNode.class);

		return rootNode;

	}

	public static void JsonObjectToFlat(JsonNode groupNode, FlatCatalogBean flats) {
		JsonObjectToFlat(groupNode, flats.getFlats());
	}

	// Extract location and flat price from a JsonNode and insert it in a Flat
	// object.
	public static void JsonObjectToFlat(JsonNode groupNode, List<Flat> flats) {

		for (JsonNode gn : groupNode) {

			JsonNode searchResultsNode = gn.get("Searchresult link").path(0);

			JsonNode textNode = searchResultsNode.get("text");

			JsonNode priceNode = gn.get("Price value").path(0);

			// The flat location.
			String location = textNode.textValue();
			location = location.replace(" - Apartment share", "");

			// The flat price.
			String price = priceNode.get("text").textValue();

			price = price.substring(0, price.indexOf(" "));

			Flat flat = new Flat(location, price);
			flats.add(flat);

		} // end for

	}

}
