import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
	
	private User user1;
	private User user2;

	@Before
	public void setUp() throws Exception {
		user1= new User("John");
	}

	@After
	public void tearDown() throws Exception {
		user1 = null;
		UserDB.userList.clear();
	}

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
		
		//Given an empty list, after adding 1 user accounts, test if the size of the list is 1
		UserDB.addUser(user1);
		UserDB.addUser(user2);
		assertEquals("Given an empty list, after adding 1 user accounts, test if the size of the list is 1",2,UserDB.userList.size());
	}
		
		
	
	@Test
	public void deleteUserTest() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if Item list is not null but empty", UserDB.userList);

		//Given an empty list, after adding 2 items, Test that the size of userList is 2
		UserDB.addUser(user1);
		UserDB.addUser(user2);
		assertEquals("Test that the size of userList is 2", 2, UserDB.userList.size());

		//Test that the size of userList size is 1 after deleting user 2
		UserDB.deleteUser(user1);
		assertEquals("Test that the size of userList size is 1 after deleting user 2", 1, UserDB.userList.size());
	}
	
	

}
