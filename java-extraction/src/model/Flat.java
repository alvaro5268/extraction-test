package model;

public class Flat {

	private String location;
	private String price;

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

	@Override
	public String toString() {
		String out = "location: " + location;
		out += "price: " + price;
		return out;

	}

}
