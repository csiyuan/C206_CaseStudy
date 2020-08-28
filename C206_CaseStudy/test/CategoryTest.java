import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CategoryTest {
	private Category cat1,cat2;
	public static ArrayList<Category> catList = new ArrayList<Category>();
	
	@Before
	public void setUp() throws Exception {
		cat1 = new Category("Books");
		cat2 = new Category("Electronics");

	}

	@After
	public void tearDown() throws Exception {
		cat1 = null;
		catList.clear();
	}

	@Test
	public void addCategoryTest() {
		//Test that catList is NOT null 
		assertNotNull("Test that catList is NOT null", catList);

		//Test that the size of catList is 1 after adding a category
		CategoryDB.addCategory(cat1);
		assertEquals("Test that the size of catList is 1 after adding a category",1, catList.size());
		
		//Test that the first element in catList is the same as what was added.
		assertSame("Test that the first element in catList is the same as what was added.", cat1, catList.get(0));
	
	}

	@Test
	public void viewCategoryTest() {
		//Test that catList is not null but empty
		assertNotNull("Test that catList is not null but empty", catList);
		
		//Test that the size of catList is 0 before viewing categories
		assertEquals("Test that the size of catList is 0 before viewing any categories", 0, catList.size());
	
		
		//Test that the expected output string is the same as the list of category retrieved 
		String allCategory = CategoryDB.viewAllCategory(catList);
		String testOutput = "";
		assertEquals("Test that the size of catList is 1 after viewing categories", testOutput, allCategory);

	}
	@Test
	public void deleteCategoryTest() {
		//Test if there is a valid category to delete from
		assertNotNull("Test if there is a valid category to delete from", catList);
		
		//Test if the category is not null
		CategoryDB.addCategory(cat1);
		CategoryDB.addCategory(cat2);
		assertEquals("Test if the category is not null",2, catList.size());

		//Test if the list has only one item after deleting
		CategoryDB.deleteCategory(cat1);
		assertEquals("Test if the list has only one item after deleting", 1, catList.size());
	}
	@Test
	public void updateCategoryTest() {
		//Test if there is a valid category to update
		assertNotNull("Test if there is a valid category to update", catList);
		
		//Test if administrator can update category details
		CategoryDB.addCategory(cat1);
		String catname = "E-books";
		String name = "Category name:" + catname;
		cat1.setName(catname);
		assertEquals("Test if admin can update category details", name, catList.get(0).toString());
	}
}
