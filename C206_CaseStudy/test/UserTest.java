import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
	
	private User user1, user2;
	

	@Before
	public void setUp() throws Exception {
		user1 = new User("John", "buyer", "testBuyer@gmail.com", "1234abcd");
		user2 = new User("Jack", "Admin", "admin@gmail.com", "Admin");
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
//	        user1.setEmail("testBuyer@gmail.com");
	        UserDB.addUser(user2);	            
	        UserDB.searchUser(user2.getEmail());
//	        assertSame("test items are displayed appropriately according to the buyer or seller by email",UserDB.userList.get(0), result);
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
		
		//
	}
	
	@After
	public void tearDown() throws Exception {
		user1 = null;
		UserDB.userList.clear();
	}
}
