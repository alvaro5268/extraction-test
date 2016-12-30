package model;

import java.util.LinkedList;
import java.util.List;

// TODO: MAKE SINGLETON.
public class FlatCatalog {

	List<Flat> flats;

	public FlatCatalog() {
		this.flats = new LinkedList<Flat>();
	}

	public List<Flat> getFlats() {
		return this.flats;
	}

	public void add(Flat flat) {
		this.flats.add(flat);
	}
	
	public int size(){
		return this.flats.size();
	}

	@Override
	public String toString() {
		return "FlatCatalog [flats=" + flats + "]";
	}
}
