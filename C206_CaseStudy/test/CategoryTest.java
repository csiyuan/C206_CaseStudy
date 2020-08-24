import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CategoryTest {
	private Category cat1;
	private Category cat2;
	
	@Before
	public void setUp() throws Exception {
		cat1 = new Category("Books");
		cat2 = new Category("E-Books");
	}

	@After
	public void tearDown() throws Exception {
		cat1 = null;
		CategoryDB.catList.clear();
	}

	@Test
	public void addCategoryTest() {
		//Test that catList is NOT null 
		assertNotNull("Test that catList is NOT null", CategoryDB.catList);

		//Test that the size of catList is 1 after adding a category
		CategoryDB.addCategory(cat1);
		assertEquals("Test that the size of catList is 1 after adding a category",1, CategoryDB.catList.size());
		
		//Test that the first element in catList is the same as what was added.
		assertSame("Test that the first element in catList is the same as what was added.", cat1, CategoryDB.catList.get(0));
	
	}

	@Test
	public void viewCategoryTest() {
		//Test that catList is not null but empty
		assertNotNull("Test that catList is not null but empty", CategoryDB.catList);
		
		//Test that the size of catList is 0 before viewing categories
		assertEquals("Test that the size of catList is 0 before viewing any categories", 0, CategoryDB.catList.size());
	
		
		//Test that the expected output string is the same as the list of category retrieved 
		String allCategory = CategoryDB.retrieveAllCategory(CategoryDB.catList);
		String testOutput = "";
		assertEquals("Test that the size of catList is 1 after viewing categories", testOutput, allCategory);

	}
	
	public void deleteCategoryTest() {
		//Test if there is a valid category to delete from
		assertNotNull("Test if there is a valid category to delete from", CategoryDB.catList);
		
		//Test if the category is not null
		CategoryDB.addCategory(cat1);
		CategoryDB.addCategory(cat2);
		assertEquals("Test if the category is not null",1, CategoryDB.catList.size());

		//Test if the list has only one item after deleting
		CategoryDB.deleteCategory(cat1);
		assertEquals("Test if the list has only one item after deleting", 1, CategoryDB.catList.size());
	}
}
