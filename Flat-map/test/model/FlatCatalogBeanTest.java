package model;

import static org.junit.Assert.*;

import org.junit.Test;

import beans.FlatCatalogBean;

public class FlatCatalogBeanTest {

	@Test
	public void flatCatalog() throws Exception {
		FlatCatalogBean flatCatalog = new FlatCatalogBean() ;
		assertNotNull(flatCatalog);
	}
	
	@Test	
	public void add() throws Exception{
		Flat flat = new Flat("Dublin","500€ per month");
		FlatCatalogBean flatCatalog = new FlatCatalogBean() ;
		flatCatalog.add(flat);
		assertEquals(1,flatCatalog.size());
	}
	
	@Test		
	public void get() throws Exception{
		
		Flat flat = new Flat("Dublin","500€ per month");
		FlatCatalogBean flatCatalog = new FlatCatalogBean() ;
		flatCatalog.add(flat);	
		
		for (Flat flatIt : flatCatalog.getFlats()) {
			assertEquals("Dublin",flatIt.getLocation());
			assertEquals("500€ per month",flatIt.getPrice());
		}
		
	}

}
