package read_input;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;

import model.Flat;
 

public class JsonReaderTest {


	@Test
	public void check10propertiesSize() {

		JsonNode rootNode;
		try {
			
			rootNode = JsonReader.jsonToObject("json-input\\flats10.json");

			// Extract different attributes of json-input/flats.json
			// in order to find location and price flat (see flats.json)
			JsonNode resultNode = rootNode.get("result");

			JsonNode extractorDataNode = resultNode.get("extractorData");

			JsonNode dataNode = extractorDataNode.get("data").path(0);

			JsonNode groupNode = dataNode.get("group");
			
			List<Flat> flats = new LinkedList<Flat>();
			JsonReader.JsonObjectToFlat(groupNode,flats);

			// Expected 10 different flats.
			assertEquals(flats.size(), 10);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void check20propertiesSize() throws JsonParseException, JsonMappingException, IOException {

		JsonNode rootNode = JsonReader.jsonToObject("json-input\\flats20.json");

		// Extract different attributes of json-input/flats.json
		// in order to find location and price flat (see flats.json)
		JsonNode resultsNode = rootNode.get("results");

		List<Flat> flats = new LinkedList<Flat>();
		
		for (JsonNode rn : resultsNode) {

			JsonNode resultNode = rn.get("result");

			JsonNode extractorDataNode = resultNode.get("extractorData");

			JsonNode dataNode = extractorDataNode.get("data").path(0);

			JsonNode groupNode = dataNode.get("group");
			
			JsonReader.JsonObjectToFlat(groupNode,flats);			

		} // for end.

		// Expected 20 different flats.
		assertEquals(flats.size(), 20);

	} // Method end.

} // Class End
