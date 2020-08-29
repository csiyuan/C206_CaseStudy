import java.util.ArrayList;

public class UserDB {
	
	public static ArrayList<User> userList = new ArrayList<User>();

	public static void addUser(User user) {
		boolean isThere = false;
		
		if (user == null) {
			String name = Helper.readString("Enter name: ");
			String role = Helper.readString("Enter role: ");
			String email = Helper.readString("Enter email: ");
			String password = Helper.readString("Enter password: ");

			user = new User(name, role, email, password);
		} 
		
		for (User i : userList) {
			if (i.getEmail().equals(user.getEmail()))
				isThere = true;
		}
		
		if (isThere) {
			System.out.println("The email is being repeated.");
		} else {
			userList.add(user);
			System.out.println("User added!");
		}
	}
	
	public static void viewUser() {
		
		String output = "";
		output += String.format("%-20s %-10s %s \n", 
				"Name", "Role", "Email");
		output += doViewUser(userList);
		
		System.out.println(output);
	}
	
	public static String doViewUser(ArrayList<User> userList) {
		String output = "";
		if (userList.isEmpty()) 
			output += "There is no deal available within the list";
		else {
			for (User i : userList) {
				output += i.toString();
			}
		}
		return output;
	}

	public static void deleteUser(String email) {
		boolean removed = false;
				
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).isLogin()) {
				if (userList.get(i).getEmail().equals(email)) {
					userList.remove(i);
					removed = true;
				}
			}
		}
		
		if (removed)
			System.out.println("User have been removed.");
		else
			System.out.println("User email does not exist in user list.");
		System.out.println();
	}
	
	public static void searchUser(String email) {
		boolean isThere = false;
		String output = "";
		int i = 0;
		
		for (; i < userList.size(); i++) {
			if (userList.get(i).getEmail().equals(email)) {
				isThere = true;
				break;
			}
		}
		
		if (isThere) 
			output += userList.get(i).toString();
		else 
			output += "User email does not exist";
		System.out.println(output);
		System.out.println();
	}
	
	public static void updateUser(User user, String name, String password) {
		boolean isThere = false;
		String output = "";
		int i = 0;
		
		for (; i < userList.size(); i++) {
			if (userList.get(i).getEmail().equals(user.getEmail())) {
				isThere = true;
				user = new User(name, userList.get(i).getRole(),  userList.get(i).getEmail(), password);
				break;
			}
		}
		
		if (isThere) 
			userList.set(i, user);
		else 
			output += "User email does not exist";
		System.out.println(output);
		System.out.println();
	}
	
	public static  int loginUser(String email, String password) {
		int output= 0;
		
		for(int i = 0; i < userList.size(); i++) {
			if(userList.get(i).getEmail().equals(email)) {
				if(userList.get(i).getPassword().equals(password)) {
					if(userList.get(i).getRole().equals("Buyer")) {
						output = 1;
						
					}else if(userList.get(i).getRole().equals("Seller")) {
						output = 2;
						
					}else if(userList.get(i).getRole().equals("Admin")) {
						output= 3;
					}
					else {
						System.out.println("You are an unauthorized user");
					}
					
				}
			}
		}
		return output;
		
		
	}
	
	public static void logoutUser() {
		boolean proceed = false;
		
		for (User i : userList) {
			if (i.isLogin()) {
				proceed = true;
				i.setLogin(false);
			}
		}
		
		if (proceed)
			System.out.println("Successfully logged out");
		else 
			System.out.println("You are not log in yet");
		System.out.println();
	}

	public static void userMenu() {
		Helper.line(40, "=");
		System.out.println("User Menu");
		Helper.line(40, "=");
		System.out.println();
		System.out.println("1. Add User");
		System.out.println("2. View User");
		System.out.println("3. Delete User");
		System.out.println("4. Search User");
		System.out.println("5. Update User");
		System.out.println();
	}
}
