import java.util.ArrayList;

public class C206_CaseStudy {
	public static ArrayList<Category> catList = new ArrayList<Category>();
	
	public static void main(String[] args) {
		int option = 0;
		int buyeroption = 0;
		int selleroption = 0;
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
				C206_CaseStudy.BuyerMenu();
				buyeroption = Helper.readInt("Enter an option : ");
				if (buyeroption == 1) {
					//Search item
				} else if (buyeroption == 2) {
					String result = Helper.readString("Enter category name: ");
					for (int i = 0; i < catList.size(); i++) {
						if (catList.get(i).getName().toString() == result) {
							System.out.println("Results:" + catList.get(i).toString());
						} else {
							System.out.println("No such category found.");
						}
					}
				} else if (buyeroption == 3) {
						//Manage Buyer Deals
						
				} else if (option ==3 ) {
					C206_CaseStudy.SellerMenu();
					selleroption = Helper.readInt("Enter option: ");
					if (selleroption == 1) {
						//Search item
					} else if (selleroption == 2) {
						String result = Helper.readString("Enter category name: ");
						for (int i = 0; i < catList.size(); i++) {
							if (catList.get(i).getName().toString() == result) {
								System.out.println("Results:" + catList.get(i).toString());
							} else {
								System.out.println("No such category found.");
							}
						}
					} else if (selleroption == 3) {
							//Manage Seller Deals
					
				} else {
					System.out.println("Invalid option!");
					break;
				}

			} else if (option == 4) {
				C206_CaseStudy.AdminMenu();
				adminoption = Helper.readInt("Enter an option > ");
				if (adminoption == 1) {
					System.out.println("Category List");
					for (int i = 0; i < catList.size(); i++) {
						C206_CaseStudy.viewAllCategory(catList);
					}
					int categoryoption = Helper.readInt("Select category number...");
				} else if(adminoption == 2) {
					//manage admin users
				} else if (adminoption == 3) {
					//manage admin deals
				}

			} else if (option == 5){
				System.out.println("Thank you for visiting the shop!");
				break;
			} else {
				System.out.println("Invalid option");
			}
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
		System.out.println("2. Login as buyer");
		System.out.println("3. Login as seller");
		System.out.println("4. Login as admin");
		System.out.println("5. Quit");
		Helper.line(80, "-");

	}
	private static void BuyerMenu() {

		C206_CaseStudy.setHeader("Buyer's Home Page");
		System.out.println("1. Search item");
		System.out.println("2. Search category");
		System.out.println("3. Manage your deals");
	}
	private static void SellerMenu() {

		C206_CaseStudy.setHeader("Seller's Home Page");
		System.out.println("1. Search item");
		System.out.println("2. Search category");
		System.out.println("3. Manage your deals");
	}
	private static void AdminMenu() {

		C206_CaseStudy.setHeader("Admin Home Page");
		System.out.println("1. Manage categories");
		System.out.println("2. Manage users");
		System.out.println("3. Manage deals");
		System.out.println("4. Quit");
	}
	

	// ----------------------------------- Menu --------------------------------//
	
	
	
	
	
	// ----------------------------- Category ---------------------------------- (Julien)//
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
	
	// ----------------------------- Category ---------------------------------- (Julien)//
}

