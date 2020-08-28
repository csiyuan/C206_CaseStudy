import java.util.ArrayList;

public class C206_CaseStudy {
	public static ArrayList<Category> catList = new ArrayList<Category>();
	
	public static void main(String[] args) {
		int option = 0;
		int cusoption = 0;
		int adminoption = 0;
		Category cat1 = new Category ("Books");
		Category cat2 = new Category ("Electronics");
		Category cat3 = new Category ("Stationery");
		catList.add(cat1);
		catList.add(cat2);
		catList.add(cat3);
		while (option != 4) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				C206_CaseStudy.viewAllCategory(catList);

			} else if (option == 2) {
				C206_CaseStudy.CustomerMenu();
				cusoption = Helper.readInt("Enter an option > ");
				if (cusoption == 1) {
					
				} else if (cusoption == 2) {
					String result = Helper.readString("Enter category name: ");
					for (int i = 0; i < catList.size(); i++) {
						if (catList.get(i).getName().toString() == result) {
							System.out.println("Results:" + catList.get(i).toString());
						} else {
							System.out.println("No such category found.");
						}
					}
				} else if (cusoption == 3) {
					
				} else if (cusoption == 4) {
					
				} else {
					System.out.println("Invalid option!");
					break;
				}

			} else if (option == 3) {
				C206_CaseStudy.AdminMenu();
				adminoption = Helper.readInt("Enter an option > ");
				if (adminoption == 1) {
					int categoryoption = 0;
					System.out.println("Category List");
					for (int i = 0; i < catList.size(); i++) {
						C206_CaseStudy.viewAllCategory(catList);
					}
					categoryoption = Helper.readInt("Select category number...");
				}

			} else {
				System.out.println("Invalid option");
			}

		}
		
	}
	
	
	// ----------------------------------- Menu --------------------------------//
	public static void setHeader(String header) {

		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	public static void menu() {
		System.out.println("Campus Online Auction Shop");
		System.out.println("1. View all categories");
		System.out.println("2. Login as customer");
		System.out.println("3. Login as admin");
		System.out.println("4. Quit");
		Helper.line(80, "-");

	}
	private static void CustomerMenu() {

		C206_CaseStudy.setHeader("Customer's Home Page");
		System.out.println("1. Search item");
		System.out.println("2. Search category");
		System.out.println("3. Sell an item");
		System.out.println("4. Manage your items");
	}
	private static void AdminMenu() {

		C206_CaseStudy.setHeader("Admin Home Page");
		System.out.println("1. Manage categories");
		System.out.println("2. Manage users");
		System.out.println("3. Manage deals");
		System.out.println("4. Quit");
	}
	// ----------------------------------- Menu --------------------------------//
	
	
	
	
	
	// ----------------------------- Category ----------------------------------//
	public static void addCategory(Category cat) {
		catList.add(cat);
	}
	
	public static String retrieveAllCategory(ArrayList<Category> catList) {
		String output = "";
		for (int i = 0; i < catList.size(); i++) {
			output += String.format("%d. %-10s \n", i+1, catList.get(i).getName().toString());
		}
		return output;
	}
	
	public static void viewAllCategory(ArrayList<Category> catList) {
		Helper.line(120, "-");
		String output = String.format("%-10s \n\n", "Categories");
		output += retrieveAllCategory(catList);
		System.out.println(output);
		Helper.line(120, "-");
	}
	
	public static void deleteCategory(Category c) {
		if (catList.size() !=0) {
			catList.remove(c);
		}
	}
	
	// ----------------------------- Category ----------------------------------//
}

