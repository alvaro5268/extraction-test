package model;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;

public class MapTest {
	
	public static void main(String[] args) throws Exception {

		GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyAxyQRQ93FrXqxh7hBoycyCrFYheGbT1Q4");
		GeocodingResult[] results =  GeocodingApi.geocode(context,"1600 Amphitheatre Parkway Mountain View, CA 94043").await();
		System.out.println(results[0].formattedAddress);

		
	}

}
