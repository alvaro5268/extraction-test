package model;

import static org.junit.Assert.*;


import org.junit.Test;


public class FlatTest {
	
	@Test
	public void constructorDefaultTest(){
		
		String locationBefore = "Dublin City Center";
		String priceBefore = "500 €";
		
		Flat flat = new Flat();
		
		flat.setLocation(locationBefore);
		flat.setPrice(priceBefore);
		
		String location = flat.getLocation();
		String price = flat.getPrice();
		
		
		assertEquals(locationBefore,location);
		assertEquals(priceBefore,price);
		
	}
	
	@Test
	public void constructorTest(){
		
		String locationBefore = "Dublin City Center";
		String priceBefore = "500 €";
		
		Flat flat = new Flat(locationBefore,priceBefore);
		
		String location = flat.getLocation();
		String price = flat.getPrice();
		
		assertEquals(locationBefore,location);
		assertEquals(priceBefore,price);
		
	}	
	

}
