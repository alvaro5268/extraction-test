package model;

import java.util.HashMap;
import java.util.Map;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;

public class MapsGoogle {

	private GeoApiContext context;

	public MapsGoogle() {
		this.context = new GeoApiContext().setApiKey("AIzaSyAxyQRQ93FrXqxh7hBoycyCrFYheGbT1Q4");
	}

	public Map<String, String> calculateLongandLati(String location) throws Exception {
		GeocodingResult[] results = GeocodingApi
				.geocode(this.context, location).await();
		// System.out.println(results[0].geometry.location.lat);
		// System.out.println(results[0].geometry.location.lng);
		double lat = 45.485434;
		double longi = -36.54484;		
		
		if(results.length > 0){
			lat = results[0].geometry.location.lat;
			longi = results[0].geometry.location.lng;
		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("lat", String.valueOf(lat));
		map.put("longi", String.valueOf(longi));

		return map;
	}

	/*
	 * public static void main(String[] args) throws Exception {
	 * 
	 * MapsGoogle mapTest = new MapsGoogle(); mapTest.
	 * calculateLongandLati("1600 Amphitheatre Parkway Mountain View, CA 94043"
	 * );
	 * 
	 * }
	 */

}
