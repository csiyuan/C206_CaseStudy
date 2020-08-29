import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemTest {
	
	private Item item1;
	private Item item2;

	@Before
	public void setUp() throws Exception {
		
		item1=new Item("Lamp", " fast charging", 13.20, " 12 January 2020", " 1 February 2020", 0.50 );
		item2=new Item("Portable fan", " light weight", 8.90, " 12 January 2020", " 1 February 2020",0.50 );

	}

	@After
	public void tearDown() throws Exception {
		
		item1=null;
		ItemDB.itemList.clear();
	}

	@Test
	public void addItemTest() {
		//Item is not null, so that can add new item 
		assertNotNull("Test that itemList is not null", ItemDB.itemList);
		
		//Test that itemList is not 0 before adding any items
		assertEquals("Test that itemList is not 0", 0, ItemDB.itemList.size());
		
		//Given an empty list, after adding 1 item, the size is 1
		//item added is as same as the first item in list
		ItemDB.addItem(item1);
		assertEquals("Test itemList size is 1", 1, ItemDB.itemList.size());
		assertSame("Test item is added", item1, ItemDB.itemList.get(0));
		
		//Test that size is 2 when another item is added
		ItemDB.addItem(item2);
		assertEquals("Test itemList is 2", 2, ItemDB.itemList.size());
		assertSame("Test item is added", item2, ItemDB.itemList.get(1));
	}
	
	public void retrieveAllItemTest() {
		//Test if item is not null 
		assertNotNull("Test if there is item in itemList", ItemDB.itemList);
		
		//Given an empty list, after adding 2 items, test the size of the list is 2
		ItemDB.addItem(item1);
		ItemDB.addItem(item2);
		assertEquals("Test size is 2", 2, ItemDB.itemList.size());
		
		//test list retrieved is empty
		String allItems=ItemDB.retrieveAllItem(ItemDB.itemList);
		String testOutput="";
		assertEquals("Test retrieve list is empty", allItems, testOutput);
		
		//test if itemList retrieved is empty
		allItems=ItemDB.retrieveAllItem(ItemDB.itemList);
		testOutput = String.format("%-10s %-30s $-10s %-10 %-20s %-10s %10s\n", "Lamp", "fast charging",13.20, "12 January 2020", "1 February 2020", 0.50);
		testOutput = String.format("%-10s %-30s $-10s %-10 %-20s %-10s %10s\n", "Powerbank", "fast charging", 16.90 , "12 January 2020", "1 February 2020", 1.90);
		assertEquals("Test that ViewAllItems", allItems, testOutput);
	}
	
	public void delItemTest() {
		//test itemList is not null
		assertNotNull("Test item is not null", ItemDB.itemList);
		
		//test if specific item before  deleting
		ItemDB.addItem(item1);
		ItemDB.addItem(item2);
		assertEquals("Test size of itemList is 2", 2, ItemDB.itemList.size());
		
		//test if list has 1 item
		ItemDB.delItem(null);
		assertEquals("Test size is 1 after adding Item", 1, ItemDB.itemList.size());
		
	}
	
	public void searchItemTest() {
		//test itemList is not null
		assertNotNull("Test that itemList is not null", ItemDB.itemList);
		
		//test that itemList is not empty
		ItemDB.addItem(item1);
		ItemDB.addItem(item2);
		String output="";
		assertNotEquals("test that itemList is not empty", item1, ItemDB.itemList);
		
		//test item is able to search via name or decription
		String name=Helper.readString("Enter item name > ");
		String desc=Helper.readString("Enter item description > ");
		ItemDB.searchItem(name, desc);
		assertSame("test that item able to search", item1, ItemDB.itemList.contains(item1));	
	}
	
	public void updateItemTest() {
		//test that itemList is not null
		assertNotNull("test that itemList is not null", ItemDB.itemList);
		
		//test that itemList is not empty
		ItemDB.addItem(item1);
		ItemDB.addItem(item2);
		assertTrue("Test that itemList is not empty", ItemDB.itemList.isEmpty()==false);
		
//		//test that item can be updated
//		String updateItem=Helper.readString("Enter item name to update > ");
//		ItemDB.updateItem(updateItem);
//		assertNotSame("Test that item can be updated", updateItem, ItemDB.itemList);
	}

}
