import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DealTest {
	
	private Deal d1, d2;

	@Before
	public void setUp() throws Exception {
		d1 = new Deal("123","TestItem", "testSeller@gmail.com", "testBuyer@gmail.com", 12.0, "12/01/12");
		d2 = new Deal("321","TestItem2", "testSeller2@gmail.com", "testBuyer2@gmail.com", 12.0, "12/01/12");

		
	}

	@After
	public void tearDown() throws Exception {
		d1 = null;
		d2 = null;
		DealDB.dealList.clear();
	}

	@Test
	public void addDealTest() {
		 //Testing dealList is not null
		assertNotNull("Test that dealList is NOT null", DealDB.dealList);
		
		//Test that that size of dealList is 0 before adding any deals
		assertEquals("Test that that size of dealList is 0 before adding any deals", 0, DealDB.dealList.size());
		
		//test that the size of dealList is 1 after adding a category
		DealDB.addDeal(d1);
		assertEquals("test that the size of dealList is 1 after adding a deal", 1, DealDB.dealList.size());
		
		//test that the first element in dealList is the same as what we added
		assertEquals("test that the first element in dealList is the same as what we added", d1, DealDB.dealList.get(0));
	}
	
	public void viewDealTest() {
		 //Testing dealList is not null
		assertNotNull("Test that dealList is NOT null so items can be retrieved", DealDB.dealList);
			
		//test if the list of Deals retrieved is empty - boundary
				String allDeals= DealDB.viewAllDeal();
				
				assertEquals("Test that the size of userList is 0 before viewing any Deals", 0, DealDB.dealList.size());				
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
				DealDB.addDeal(d1);
				DealDB.addDeal(d2);
				assertEquals("test that the size of dealList is 2 ", 2, DealDB.dealList.size());
	
			
	}
	
	public void deleteDealTest() {
		 //Testing dealList is not null
		assertNotNull("Test that dealList is NOT null", DealDB.dealList);
		
		 
		
		//Test if a specific item is inside before deleting
		DealDB.addDeal(d1);
		DealDB.addDeal(d2);
		assertEquals("test that the size of dealList is 2 ", 2, DealDB.dealList.size());
		
		//Test if list now only has one item after deleting
		DealDB.delDeal(d1);
		assertEquals("test that the size of dealList is 1 after adding a deal", 1, DealDB.dealList.size());

		
		
	}

}