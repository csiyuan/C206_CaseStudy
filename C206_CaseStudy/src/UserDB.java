import java.util.ArrayList;

public class UserDB {
	public static ArrayList<User> userList = new ArrayList<User>();

	public static void addUser(User user) {
		userList.add(user);
	}
	public static void viewUser(ArrayList<UserDB> userList) {
		String output = "";
		for (int i = 0; i < userList.size(); i++) {

			output += String.format("%-84s \n", userList.get(i).toString());
			System.out.println(output);
		}
	}
	

	public static void deleteUser(User user) {
		if(userList.size() != 0) {
			userList.remove(user);
		}
		
	}
}
