package model;

public class Flat {

	private String location;
	private String price;
	private String lat;
	private String longi;

	Flat() {
	}

	public Flat(String location, String price) {
		this.location = location;
		this.price = price;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLongi() {
		return longi;
	}

	public void setLongi(String longi) {
		this.longi = longi;
	}

	@Override
	public String toString() {
		String out = "location: " + location + " <br> \n";
		out += "lat: " + lat + " <br> \n";
		out += "longi: " + longi + " <br> \n";
		out += "price: " + price + " <br> \n";
		return out;
	}

}
