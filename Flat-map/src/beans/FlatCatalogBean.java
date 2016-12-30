package beans;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

import auxiliar.JsonToFlat;
import model.Flat;
import model.MapsGoogle;

public class FlatCatalogBean {

	List<Flat> flats;

	public FlatCatalogBean() throws Exception {
		this.flats = new LinkedList<Flat>();
		this.init();
	}

	private void init() throws Exception {
		JsonNode rootNode;

		// TODO: RECUPERAR EL FICHERO POR PATH
		// String contextPath =
		// FacesContext.getCurrentInstance().getExternalContext().getContextName();
		// System.out.println(contextPath);
		// rootNode = JsonReader.jsonToObject("json-input\\flats10.json");

		String jsonInput = "{\"url\":\"http://www.daft.ie/dublin/apartment-share/?s%5Broom_type%5D=own&s%5Bsort_by%5D=price&s%5Bsort_type%5D=d&offset=0\",\"result\":{\"extractorData\":{\"url\":\"http://www.daft.ie/dublin/apartment-share/?s%5Broom_type%5D=own&s%5Bsort_by%5D=price&s%5Bsort_type%5D=d&offset=0\",\"resourceId\":\"734502d8a2fe0ef043aa8a17351b32d5\",\"data\":[{\"group\":[{\"Searchresult link\":[{\"text\":\"44 Richmond Street South, Dublin 2 - Apartment share\",\"href\":\"http://www.daft.ie/dublin/apartment-share/dublin-2/44-richmond-street-south-dublin-2-dublin-915689/\"}],\"Price value\":[{\"text\":\"€500 per week\"}]},{\"Searchresult link\":[{\"text\":\"2-10 Exchange Street Lower, Temple Bar, Dublin 1 - Apartment share\",\"href\":\"http://www.daft.ie/dublin/apartment-share/temple-bar/2-10-exchange-street-lower-temple-bar-dublin-919045/\"}],\"Price value\":[{\"text\":\"€350 per week\"}]},{\"Searchresult link\":[{\"text\":\"Parnell Street, Dublin 1 - Apartment share\",\"href\":\"http://www.daft.ie/dublin/apartment-share/dublin-1/parnell-street-dublin-1-dublin-917023/\"}],\"Price value\":[{\"text\":\"€300 per week\"}]},{\"Searchresult link\":[{\"text\":\"Convent Hall, Convent Hall, Mount Saint Anne's, Milltown, Dublin 6 - Apartment share\",\"href\":\"http://www.daft.ie/dublin/apartment-share/milltown/convent-hall-convent-hall-mount-saint-annes-milltown-dublin-906621/\"}],\"Price value\":[{\"text\":\"€1,300 per month\"}]},{\"Searchresult link\":[{\"text\":\"Phoenix Park Way, Castleknock, Dublin 15 - Apartment share\",\"href\":\"http://www.daft.ie/dublin/apartment-share/castleknock/phoenix-park-way-castleknock-dublin-919920/\"}],\"Price value\":[{\"text\":\"€1,300 per month\"}]},{\"Searchresult link\":[{\"text\":\"Smithfield Market, Smithfield, Dublin 1 - Apartment share\",\"href\":\"http://www.daft.ie/dublin/apartment-share/smithfield/smithfield-market-smithfield-dublin-919621/\"}],\"Price value\":[{\"text\":\"€290 per week\"}]},{\"Searchresult link\":[{\"text\":\"The Gasworks The Alliance Building, Barrow street, Ballsbridge, Dublin 4 - Apartment share\",\"href\":\"http://www.daft.ie/dublin/apartment-share/ballsbridge/the-gasworks-the-alliance-building-barrow-street-ballsbridge-dublin-919482/\"}],\"Price value\":[{\"text\":\"€290 per week\"}]},{\"Searchresult link\":[{\"text\":\"Stillorgan Road, Blackrock, Stillorgan, Co. Dublin - Apartment share\",\"href\":\"http://www.daft.ie/dublin/apartment-share/stillorgan/stillorgan-road-blackrock-stillorgan-dublin-918723/\"}],\"Price value\":[{\"text\":\"€1,250 per month\"}]},{\"Searchresult link\":[{\"text\":\"Pembroke Road, Ballsbridge, Dublin 4 - Apartment share\",\"href\":\"http://www.daft.ie/dublin/apartment-share/ballsbridge/pembroke-road-ballsbridge-dublin-918525/\"}],\"Price value\":[{\"text\":\"€1,200 per month\"}]},{\"Searchresult link\":[{\"text\":\"Hanover Quay, Grand Canal Dock, Grand Canal Dock, Dublin 2 - Apartment share\",\"href\":\"http://www.daft.ie/dublin/apartment-share/grand-canal-dock/hanover-quay-grand-canal-dock-grand-canal-dock-dublin-916266/\"}],\"Price value\":[{\"text\":\"€1,200 per month\"}]}]}]},\"pageData\":{\"resourceId\":\"734502d8a2fe0ef043aa8a17351b32d5\",\"statusCode\":200,\"timestamp\":1483028085640},\"timestamp\":1483028401348,\"sequenceNumber\":0}}";
		rootNode = JsonToFlat.jsonStringToObject(jsonInput);

		// Extract different attributes of json-input/flats.json
		// in order to find location and price flat (see flats.json)
		JsonNode resultNode = rootNode.get("result");

		JsonNode extractorDataNode = resultNode.get("extractorData");

		JsonNode dataNode = extractorDataNode.get("data").path(0);

		JsonNode groupNode = dataNode.get("group");

		// Create a new flat and insert it in the catalogue of flats.
		JsonToFlat.JsonObjectToFlat(groupNode, this.flats);

		// For every flat in the catalogue calculate and set 
		// the longitude and latitude.
		this.calculateLateAndLongi();

	}

	public List<Flat> getFlats() {
		return this.flats;
	}

	public void add(Flat flat) {
		this.flats.add(flat);
	}

	public int size() {
		return this.flats.size();
	}

	public void calculateLateAndLongi() throws Exception {
		MapsGoogle mapTest = new MapsGoogle();
		String location = "";

		for (Flat flat : flats) {
			location = flat.getLocation();
			Map<String, String> map = mapTest.calculateLongandLati(location);
			String lat = map.get("lat");
			String longi = map.get("longi");
			flat.setLat(lat);
			flat.setLongi(longi);
		}
	}

	@Override
	public String toString() {

		String out = this.size() + " results found" + "\n";
		for (Flat flat : flats) {
			out += flat.toString();
		}

		return out;
	}

	public static void main(String[] args) throws Exception {
		FlatCatalogBean fcb = new FlatCatalogBean();
		System.out.println(fcb.toString());
	}

}
