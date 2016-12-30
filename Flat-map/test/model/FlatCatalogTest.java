package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class FlatCatalogTest {

	@Test
	public void flatCatalog() {
		FlatCatalog flatCatalog = new FlatCatalog() ;
		assertNotNull(flatCatalog);
	}
	
	@Test	
	public void add(){
		Flat flat = new Flat("Dublin","500€ per month");
		FlatCatalog flatCatalog = new FlatCatalog() ;
		flatCatalog.add(flat);
		assertEquals(1,flatCatalog.size());
	}
	
	@Test		
	public void get(){
		
		Flat flat = new Flat("Dublin","500€ per month");
		FlatCatalog flatCatalog = new FlatCatalog() ;
		flatCatalog.add(flat);	
		
		for (Flat flatIt : flatCatalog.getFlats()) {
			assertEquals("Dublin",flatIt.getLocation());
			assertEquals("500€ per month",flatIt.getPrice());
		}
		
	}

}
