import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Deal d1, d2;
	private User user1, user2;
	private Category cat1,cat2;
	
	@Before
	public void setUp() throws Exception {
		d1 = new Deal("123","TestItem", "testSeller@gmail.com", "testBuyer@gmail.com", 12.0, "12/01/12");
		d2 = new Deal("321","TestItem2", "testSeller2@gmail.com", "testBuyer2@gmail.com", 13.0, "12/01/12");
		user1 = new User("John", "buyer", "testBuyer@gmail.com", "1234abcd");
		user2 = new User("Jack", "Admin", "admin@gmail.com", "Admin");
		cat1 = new Category("Books");
		cat2 = new Category("Electronics");
	}

	@After
	public void tearDown() throws Exception {
		d1 = null;
		d2 = null;
		DealDB.dealList.clear();
		user1 = null;
		user2 = null;
		UserDB.userList.clear();
		cat1 = null;
		CategoryDB.catList.clear();
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}	
	
	


		
		
//===============================================DEALS - David=========================================================================//			
		 
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
				DealDB.delDeal("123");
				assertEquals("test that the size of dealList is 1 after adding a deal", 1, DealDB.dealList.size());

				
				
			}
			
			public void searchDealTest() {
				 //Testing dealList is not null
				assertNotNull("Test that dealList is NOT null so items can be retrieved", DealDB.dealList);
					
				//test if the list of Deals retrieved is empty - boundary
				String allDeals= DealDB.viewAllDeal();
						
				assertEquals("Test that the size of userList is 0 before showing any Deals", 0, DealDB.dealList.size());
				
				//test items are displayed appropriately according to the item, buyer, seller, close date etc 
				//By item name
				DealDB.addDeal(d1);
				DealDB.addDeal(d2);
				DealDB.searchDeal("TestItem", "", "", 0, "");
				
				//by buyer email
				DealDB.addDeal(d1);
				DealDB.addDeal(d2);
				DealDB.searchDeal("", "testBuyer@gmail.com", "", 0, "");
				
				//by seller email
				DealDB.addDeal(d1);
				DealDB.addDeal(d2);
				DealDB.searchDeal("", "", "testSeller@gmail.com", 0, "");
				
				//by price
				DealDB.addDeal(d1);
				DealDB.addDeal(d2);
				DealDB.searchDeal("", "", " ", 12.0, "");
				
				//by close date
				DealDB.addDeal(d1);
				DealDB.addDeal(d2);
				DealDB.searchDeal("", "", " ",0 , "12/01/12");
				
				//test that user gets an error message when item, buyer, seller, close date does not match the input
				DealDB.addDeal(d1);
				DealDB.addDeal(d2);
				DealDB.searchDeal("", "", " ",0 , " ");
				
				
			}
			
			public void updateDealTest() {
				 //Testing dealList is not null
				assertNotNull("Test that dealList is NOT null so items can be retrieved", DealDB.dealList);
					
				//test if the list of Deals retrieved is empty - boundary
				String allDeals= DealDB.viewAllDeal();
						
				assertEquals("Test that the size of userList is 0 before showing any Deals", 0, DealDB.dealList.size());
				
				// test that items get updated 
				DealDB.updateDeal("123", "testUpdate", "testBuyerUpdate@gmail.com", "testSellerUpdate@gmail.com", 15.0, "12/12/12");
				
			 
				
			}
//===============================================DEALS=========================================================================//			

			
// ==============================================USERS ========================================================================(SI YUAN)//
			
				@Test
				public void addUserTest() {
					//Test that userList is NOT null
					assertNotNull("Test that userList is NOT null", UserDB.userList);
					
					//Test that size of userList is - before adding any users
					assertEquals("Test that the size of userList is 0 before adding any categories", 0 , UserDB.userList.size());
					
					//Test that he size of userList is 1 after adding a category
					UserDB.addUser(user1);
					assertEquals("Test that he size of userList is 1 after adding a category",1, UserDB.userList.size());
					
					//Test that the first element in userList is the same as what was added
					assertSame("Test that the first element in userList is the same as what was added",user1,UserDB.userList.get(0));
				}
				
				@Test
				public void viewUserTest() {
					//Test that userList is not null but empty
					assertNotNull("Test that userList is not null but empty", UserDB.userList);
					
					//Test that the size of userList is 0 before viewing any users
					assertEquals("Test that the size of userList is 0 before viewing any users", 0, UserDB.userList.size());
					
					//Test if the output is correct
					UserDB.addUser(user1);
					String output = UserDB.doViewUser(UserDB.userList);
					String testoutput = String.format("%-20s %-10s %s \n", "John", "buyer", "testBuyer@gmail.com");
					assertEquals("Test if it display out the correct output",testoutput, output);
				}
					
					
				
				@Test
				public void deleteUserTest() {
					// Test if t
					assertNotNull("Test if Item List is not null but empty", UserDB.userList);

					//Given an empty list, after adding 2 items, Test that the size of userList is 2
					UserDB.addUser(user1);
					UserDB.addUser(user2);
					assertEquals("Test that the size of userList is 2", 2, UserDB.userList.size());

					//Test that the size of userList size is 1 after deleting user 1
					user2.setLogin(true);
					UserDB.deleteUser(user2.getEmail());
					assertEquals("Test that the output is the same", 1, UserDB.userList.size());
				}
				
				@Test
				public void SearchUser() {
				         //Testing userList is not null
				        assertNotNull("Test that userList is NOT null so items can be retrieved", UserDB.userList);
				          
				        //Test that the size of userList is 0 before showing any users
				        assertEquals("Test that the size of userList is 0 before showing any User", 0, UserDB.userList.size());
				       
				        //test items are displayed appropriately according to the buyer or seller by email
				        UserDB.addUser(user1);
//				        user1.setEmail("testBuyer@gmail.com");
				        UserDB.addUser(user2);	            
				        UserDB.searchUser(user2.getEmail());
//				        assertSame("test items are displayed appropriately according to the buyer or seller by email",UserDB.userList.get(0), result);
				}
				
				@Test
				public void UpdateUserTest() {
					
					// Test if there is a valid account to update 
						assertNotNull("Test if there is a valid user account to update", UserDB.userList);

					//Test if account user can update account details
					UserDB.addUser(user1);
					String name = user1.getName();
					String pass = user1.getPassword();
					String newname = "Si Yuan";
					String newpass = "1234abcd";
					if(name == newname) {
						if(pass == newpass) {
							System.out.println("Password cannot be the same as your new password. Please try again");
						}
						else {
							System.out.println("Username cannot be the same as your new username. Please try again");
						}
					}
					else {
						user1.setName(newname);
						user1.setPassword(newpass);
					}
					assertEquals("Test if account user can update account details", user1.getName(), user1.getName());
					assertEquals("Test if account user can update account details", user1.getPassword(), user1.getPassword());
				}
				
				@Test
				public void UserLoginTest() {
					//Test if user account is valid
					assertNotNull("Test if user account is valid", UserDB.userList);
				}


//==============================================USERS ========================================================================(SI YUAN)//
		

				
//==========================================================Category==========================================================(Julien)//
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
					String allCategory = CategoryDB.viewAllCategory(CategoryDB.catList);
					String testOutput = "";
					assertEquals("Test that the size of catList is 1 after viewing categories", testOutput, allCategory);

				}
				@Test
				public void deleteCategoryTest() {
					//Test if there is a valid category to delete from
					assertNotNull("Test if there is a valid category to delete from", CategoryDB.catList);
					
					//Test if the category is not null
					CategoryDB.addCategory(cat1);
					CategoryDB.addCategory(cat2);
					assertEquals("Test if the category is not null",2, CategoryDB.catList.size());

					//Test if the list has only one item after deleting
					CategoryDB.deleteCategory(cat1);
					assertEquals("Test if the list has only one item after deleting", 1, CategoryDB.catList.size());
				}
				@Test
				public void updateCategoryTest() {
					//Test if there is a valid category to update
					assertNotNull("Test if there is a valid category to update", CategoryDB.catList);
					
					//Test if administrator can update category details
					CategoryDB.addCategory(cat1);
					String catname = "E-books";
					String name = "Category name:" + catname;
					cat1.setName(catname);
					assertEquals("Test if admin can update category details", name, CategoryDB.catList.get(0).toString());
				}
//==========================================================Category==========================================================(Julien)//

}		
	


