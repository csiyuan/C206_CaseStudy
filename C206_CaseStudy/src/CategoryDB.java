import java.util.ArrayList;

public class CategoryDB {
	public static ArrayList<Category> catList = new ArrayList<Category>();

	public static void addCategory(Category cat) {
		catList.add(cat);
	}
	
	public static String retrieveAllCategory(ArrayList<Category> catList) {
		return retrieveCC(catList);
	}
	private static String retrieveCC(ArrayList<Category> catList) {
		String output = "";

		for (int i = 0; i < catList.size(); i++) {

			output += String.format("%-84s \n", catList.get(i).toString());
		}
		return output;
	}
	
	public static void deleteCategory(Category c) {
		if (catList.size() !=0) {
			catList.remove(c);
		}
	}
}
