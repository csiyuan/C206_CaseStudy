import java.util.ArrayList;

public class C206_CaseStudy {
	public static ArrayList<Category> catList = new ArrayList<Category>();
	public static ArrayList<Deal> dealList = new ArrayList<Deal>();
	public static ArrayList<Item> itemList=new ArrayList<Item>();
	public static ArrayList<User> userList = new ArrayList<User>();
	
	public static void main(String[] args) {
		int option = 0;
		int buyeroption = 0;
		int selleroption = 0;
		int adminoption = 0;
		int adminUserChoice = 0;
		
		Category cat1 = new Category ("Books");
		Category cat2 = new Category ("Electronics");
		Category cat3 = new Category ("Stationery");
		Deal d1 = new Deal("123","TestItem", "testSeller@gmail.com", "testBuyer@gmail.com", 12.0, "12/01/12");
		Deal d2 = new Deal("321","TestItem2", "testSeller2@gmail.com", "testBuyer2@gmail.com", 13.0, "12/01/12");
		Item item1= new Item("Lamp", " light weight", 12.50, " 13/07/2020", " 14/08/2020", 0.30);
		Item item2= new Item("Pen", "Zebra 0.5", 1.80, " 13/07/2020", " 14/08/2020", 0.10);
		User user1 = new User("Admin","Admin","admin@gmail.com","Admin");
		User user2 = new User("Buyer","Buyer","buyer@gmail.com","Buyer");
		User user3 = new User("Seller","Seller","seller@gmail.com","Seller");
		
		dealList.add(d1);
		dealList.add(d2);
		catList.add(cat1);
		catList.add(cat2);
		catList.add(cat3);
		itemList.add(item1);
		itemList.add(item2);
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		
		while (option != 5) {

			C206_CaseStudy.menu();
			 
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				C206_CaseStudy.viewAllCategory(catList);

			} else if (option == 2) {
				//Check login as buyer (SI YUAN)
				String email = Helper.readString("Enter your Email: ");
				String password = Helper.readString("Enter your password: ");
				String output = "You have login successfully";
				if(C206_CaseStudy.loginUser(email, password) == 1) {
					System.out.println("Successfully logged in as a BUYER");
				//AFTER SUCCESSFUL LOGIN AS BUYER (SI YUAN)
					
					C206_CaseStudy.BuyerMenu();
					buyeroption = Helper.readInt("Enter an option : ");
					if (buyeroption == 1) {
						//Search item by name or description-Anisa
						C206_CaseStudy.SearchItemMenu();
							int searchOption=Helper.readInt("Enter option: ");
						if(searchOption==1) {
							String itemName = Helper.readString("Enter Item Name: ");
							System.out.println("");
							System.out.println(C206_CaseStudy.searchItem(itemName, ""));
						}else {
							String itemDesc = Helper.readString("Enter Item Description: ");
							System.out.println("");
							System.out.println(C206_CaseStudy.searchItem(itemDesc, ""));
						}
					
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
						//Manage BUYER Deals - David
					
						C206_CaseStudy.BuyerDealMenu();
					
						int buyerChoice = Helper.readInt("Enter an option: ");
					
							if(buyerChoice == 1) { //view Deals
								System.out.println(C206_CaseStudy.viewAllDeal());
								System.out.println(" ");
							}
					
							else if(buyerChoice == 2) { //delete deals
							String dealIDToDelete = Helper.readString("Enter the deal ID you wish to delete: ");
							C206_CaseStudy.delDeal(dealIDToDelete);
							}
							else { //search deals
						
								System.out.println(C206_CaseStudy.viewAllDeal());
								System.out.println(" ");
								C206_CaseStudy.SearchDealMenu();
						
								int searchByChoice = Helper.readInt("Enter how you want to search by: ");
								if(searchByChoice == 1) {
									String itemName = Helper.readString("Enter Item Name: ");
									System.out.println("");
									System.out.println(C206_CaseStudy.searchDeal(itemName, "", "", 0, ""));
							
								}else if(searchByChoice == 2){
									String buyerEmail = Helper.readString("Enter Buyer Email: ");
									System.out.println("");
									System.out.println(C206_CaseStudy.searchDeal("", buyerEmail, "", 0, ""));
							
								}else if(searchByChoice == 3){
									String sellerEmail = Helper.readString("Enter Buyer Email: ");
									System.out.println("");
									System.out.println(C206_CaseStudy.searchDeal("", "", sellerEmail, 0, ""));
							
								}else if(searchByChoice == 4){
									double dealPrice = Helper.readDouble("Enter Deal Price: ");
									System.out.println("");
									System.out.println(C206_CaseStudy.searchDeal("", "", "", dealPrice, ""));
								}else {
									String closeDate = Helper.readString("Enter Close Date: ");
									System.out.println("");
									System.out.println(C206_CaseStudy.searchDeal("", "", "",0 , closeDate));
								}
							}
					}else if(buyeroption == 4) {
						//SEARCH USERS
						System.out.println("Testing");
						String emailToFind = Helper.readString("Enter an email to find: ");
						C206_CaseStudy.searchUser(emailToFind);
						
					}else if(buyeroption == 5) {
						//UPDATE USERS
						
						String buyersEmail = Helper.readString("Enter an email to find: ");
						
						User user = null;
						for(int i =0; i < userList.size(); i++) {
							if(userList.get(i).getEmail() != null && userList.get(i).getEmail().equals(buyersEmail)) {
								String name = Helper.readString("Enter your new name: ");
								String pass= Helper.readString("Enter your new password: ");
								if(pass.length() > 8) {
									user = new User("Buyer", "Buyer", "buyer@gmail.com", "Buyer");
									C206_CaseStudy.updateUser(user, name, pass);
									break;
								}
								else {
									System.out.println("Password Must have a Minimum  of 8 Characters");
									pass= Helper.readString("Enter your new password: ");
								}
							}
							else {
								System.out.println("No email exist.");
							}
						}
					}
					else {
						System.out.println("Invalid option!");
						break;
					}
				}	
			}else if (option ==3 ) {
				//Check login as buyer (SI YUAN)
				String email = Helper.readString("Enter your Email: ");
				String password = Helper.readString("Enter your password: ");
				String output = "You have login successfully";
				if(C206_CaseStudy.loginUser(email, password) == 2) {
					System.out.println("Successfully logged in as a SELLER");
				//AFTER SUCCESSFUL LOGIN AS SELLER (SI YUAN)
					C206_CaseStudy.SellerMenu();
					selleroption = Helper.readInt("Enter option: ");
					if (selleroption == 1) {
						//Search item by name or description
						C206_CaseStudy.SearchItemMenu();
						int searchOption=Helper.readInt("Enter option: ");
						if(searchOption==1) {
							String itemName = Helper.readString("Enter Item Name: ");
							System.out.println("");
							System.out.println(C206_CaseStudy.searchItem(itemName, ""));
							
						}else {
							String itemDesc = Helper.readString("Enter Item Description: ");
							System.out.println("");
							System.out.println(C206_CaseStudy.searchItem(itemDesc, ""));
						}
						
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
							//Manage SELLER Deals - David
						C206_CaseStudy.SellerDealMenu();
						
						int sellerChoice = Helper.readInt("Enter an option: ");
						
						if(sellerChoice == 1){ //add deal
							
							String dealID = Helper.readString("Enter Deal ID: ");
							String itemName = Helper.readString("Enter Item Name: ");
							String buyerEmail = Helper.readString("Enter Buyer Email: ");
							String sellerEmail = Helper.readString("Enter Seller Email: ");
							double dealPrice = Helper.readDouble("Enter Deal Price: ");
							String date = Helper.readString("Enter Close Date: ");
							Deal Deal = new Deal(dealID ,itemName, buyerEmail, sellerEmail, dealPrice, date);
							
							C206_CaseStudy.addDeal(Deal);
						}else if(sellerChoice == 2){ //view deals
							System.out.println(C206_CaseStudy.viewAllDeal());
							System.out.println(" ");
							
						}else if(sellerChoice == 3) { //Delete Deals
							String dealIDToDelete = Helper.readString("Enter the Deal ID You would like to delete: ");
							C206_CaseStudy.delDeal(dealIDToDelete);
						
						}else if(sellerChoice == 4) { //search deals
							System.out.println(C206_CaseStudy.viewAllDeal());
							System.out.println(" ");
							C206_CaseStudy.SearchDealMenu();
							
							int searchByChoice = Helper.readInt("Enter how you want to search by: ");
							if(searchByChoice == 1) {
								String itemName = Helper.readString("Enter Item Name: ");
								System.out.println("");
								System.out.println(C206_CaseStudy.searchDeal(itemName, "", "", 0, ""));
								
							}else if(searchByChoice == 2){
								String buyerEmail = Helper.readString("Enter Buyer Email: ");
								System.out.println("");
								System.out.println(C206_CaseStudy.searchDeal("", buyerEmail, "", 0, ""));
								
							}else if(searchByChoice == 3){
								String sellerEmail = Helper.readString("Enter Buyer Email: ");
								System.out.println("");
								System.out.println(C206_CaseStudy.searchDeal("", "", sellerEmail, 0, ""));
								
							}else if(searchByChoice == 4){
								double dealPrice = Helper.readDouble("Enter Deal Price: ");
								System.out.println("");
								System.out.println(C206_CaseStudy.searchDeal("", "", "", dealPrice, ""));
							}else {
								String closeDate = Helper.readString("Enter Close Date: ");
								System.out.println("");
								System.out.println(C206_CaseStudy.searchDeal("", "", "",0 , closeDate));
							}
						}else { //Update deals
							
							String NewdealID = Helper.readString("Enter which Deal ID you wish to update: ");
							String NewitemName = Helper.readString("Enter your new item name: ");
							String NewbuyerEmail = Helper.readString("Enter your new Buyer email: ");
							String NewSellerEmail = Helper.readString("Enter your new Seller email: ");
							double NewdealPrice = Helper.readDouble("Enter your new deal price: ");
							String NewcloseDate = Helper.readString("Enter your new close date: ");
							
							C206_CaseStudy.updateDeal(NewdealID, NewitemName, NewbuyerEmail, NewSellerEmail, NewdealPrice, NewcloseDate);
							System.out.println("");
							System.out.println(C206_CaseStudy.viewAllDeal());
						}
					}else if(selleroption==4) { //update item-anisa
						
						String name=Helper.readString("Enter item name: ");
						String desc=Helper.readString("Enter item description: ");
						double minPrice=Helper.readDouble("Enter minimum price: ");
						String startDate=Helper.readString("Enter start date: ");
						String endDate=Helper.readString("Enter end date: ");
						double bidIncre=Helper.readDouble("Enter bid increment: ");
						
						C206_CaseStudy.updateItem(name, desc, minPrice, startDate, endDate, bidIncre);
						System.out.println("");
						System.out.println(C206_CaseStudy.viewAllItem());
						System.out.println("");
						
					}else if(selleroption == 5) {
					// UPDATE SELLER ACCOUNT
						String sellersEmail = Helper.readString("Enter an email to find: ");
						
						User user = null;
						for(int i =0; i < userList.size(); i++) {
							if(userList.get(i).getEmail() != null && userList.get(i).getEmail().equals(sellersEmail)) {
								String name = Helper.readString("Enter your new name: ");
								String pass= Helper.readString("Enter your new password: ");
								if(pass.length() > 8) {
									user = new User("Seller", "Seller", "seller@gmail.com", "Seller");
									C206_CaseStudy.updateUser(user, name, pass);
									break;
								}
								else {
									System.out.println("Password Must have a Minimum  of 8 Characters");
									pass= Helper.readString("Enter your new password: ");
								}
							}
							else {
								System.out.println("No email exist.");
							}
						}
					}else {
						System.out.println("Invalid option!");
						break;
					}

				} 
			}else if (option == 4) { 
				//Check login as ADMIN (SI YUAN)
				String email = Helper.readString("Enter your Email: ");
				String password = Helper.readString("Enter your password: ");
				String output = "You have login successfully";
				if(C206_CaseStudy.loginUser(email, password) == 3) {
					System.out.println("Successfully logged in as a ADMIN");
				//AFTER SUCCESSFUL LOGIN AS ADMIN (SI YUAN)
				//Julien
					C206_CaseStudy.AdminMenu();
					adminoption = Helper.readInt("Enter an option > ");
					if (adminoption == 1) {
						C206_CaseStudy.viewAllCategory(catList);
						C206_CaseStudy.AdminCategoryMenu();
						int categoryoption = Helper.readInt("Select option: ");
						if(categoryoption == 1 ) {
							//Add category
							String catName = Helper.readString("Enter category name: ");
							for (int i = 0; i < catList.size(); i++) {
								if (catName == catList.get(i).getName()) {
									System.out.println("Category already exists!");
									break;
								} else { 
									Category cat = new Category(catName);
									catList.add(cat);
									System.out.println("Successfully added category!");
									break;
								}
							}
						} else if(categoryoption == 2) {
							//Delete category
							String delCat = Helper.readString("Enter category to delete: ");
							for (int i = 0;i < catList.size(); i++) {
								if (delCat.equals(catList.get(i).getName())) {
									catList.remove(i);
								} else {
									System.out.println("No such category exists!");
									break;
								}
							}
						} else if(categoryoption == 3) {
							//Edit category
							String categorySearch = Helper.readString("Enter category to edit: ");
							for (int i = 0;i < catList.size(); i++) {
								if (categorySearch.equalsIgnoreCase(catList.get(i).getName())) {
									String newCatName = Helper.readString("Enter new category name: ");
									if(newCatName.equalsIgnoreCase(categorySearch)) {
										System.out.println("Category name cannot be the same!");
										break;
									} else {
										catList.get(i).setName(newCatName);
										System.out.println("Category name successfully changed!");
									}
								} else {
									System.out.println("No such category exists!");
								}
							}
						} else {
							System.out.println("Invalid Option!");
							break;
						}
					} else if(adminoption == 2) {
					
						//manage admin users (SI YUAN)
						if(adminUserChoice == 1) {
							//SEARCH USER
							String emailToFind = Helper.readString("Enter an email to find: ");
							C206_CaseStudy.searchUser(emailToFind);
						}else if(adminUserChoice == 2) {
							//VIEW USERS
							C206_CaseStudy.viewUser();
						}
					} else if (adminoption == 3) {
						//manage ADMIN deals - David
						C206_CaseStudy.AdminDealMenu();
						int adminChoice = Helper.readInt("Enter Your choice: ");
					
						if(adminChoice == 1) { //View Deals
							System.out.println(C206_CaseStudy.viewAllDeal());
							System.out.println(" ");
						
						}else if(adminChoice == 2){ //Delete Deal
							String dealIDToDelete = Helper.readString("Enter the Deal ID You would like to delete: ");
							C206_CaseStudy.delDeal(dealIDToDelete);
						}else {//Search Deals
							System.out.println(C206_CaseStudy.viewAllDeal());
							System.out.println(" ");
							C206_CaseStudy.SearchDealMenu();
						
							int searchByChoice = Helper.readInt("Enter how you want to search by: ");
							if(searchByChoice == 1) {
								String itemName = Helper.readString("Enter Item Name: ");
								System.out.println("");
								System.out.println(C206_CaseStudy.searchDeal(itemName, "", "", 0, ""));
							
							}else if(searchByChoice == 2){
								String buyerEmail = Helper.readString("Enter Buyer Email: ");
								System.out.println("");
								System.out.println(C206_CaseStudy.searchDeal("", buyerEmail, "", 0, ""));
							
							}else if(searchByChoice == 3){
								String sellerEmail = Helper.readString("Enter Buyer Email: ");
								System.out.println("");
								System.out.println(C206_CaseStudy.searchDeal("", "", sellerEmail, 0, ""));
							
							}else if(searchByChoice == 4){
								double dealPrice = Helper.readDouble("Enter Deal Price: ");
								System.out.println("");
								System.out.println(C206_CaseStudy.searchDeal("", "", "", dealPrice, ""));
							}else {
								String closeDate = Helper.readString("Enter Close Date: ");
								System.out.println("");
								System.out.println(C206_CaseStudy.searchDeal("", "", "",0 , closeDate));
							}
						}
					
					}

				}
			}else if (option == 5){
					break;
			} else {
				System.out.println("Invalid option");
			}
		} 
		System.out.println("Thank you for visiting the shop!");
	}
	

	// ----------------------------------- Menu --------------------------------//
	public static void setHeader(String header) {

		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	public static void menu() { //Julien
		System.out.println("Campus Online Auction Shop");
		System.out.println("1. View all categories");
		System.out.println("2. Login as buyer");
		System.out.println("3. Login as seller");
		System.out.println("4. Login as admin");
		System.out.println("5. Quit");
		Helper.line(80, "-");

	}
	private static void BuyerMenu() { //Julien

		C206_CaseStudy.setHeader("Buyer's Home Page");
		System.out.println("1. Search item");
		System.out.println("2. Search category");
		System.out.println("3. Manage your deals");
		System.out.println("4. Search User");
		System.out.println("5. Update your account");
		System.out.println("You will be logged out after making an action");
	}
	private static void SellerMenu() { //Julien

		C206_CaseStudy.setHeader("Seller's Home Page");
		System.out.println("1. Search item");
		System.out.println("2. Search category");
		System.out.println("3. Manage your deals");
		System.out.println("4. Update Item");
		System.out.println("5. Update your account");
		System.out.println("You will be logged out after making an action");
	}
	private static void AdminMenu() { //Julien

		C206_CaseStudy.setHeader("Admin Home Page");
		System.out.println("1. Manage categories");
		System.out.println("2. Manage users");
		System.out.println("3. Manage deals");
		System.out.println("4. Quit");
		System.out.println("You will be logged out after making an action");
	}
	
	private static void AdminCategoryMenu() { //Julien
		C206_CaseStudy.setHeader("Category options");
		System.out.println("1. Add Category");
		System.out.println("2. Delete Category");
		System.out.println("3. Edit Category");
	}
	
	 private static void AdminDealMenu() { //David
	        C206_CaseStudy.setHeader("Deal Home Page");
	       
	        System.out.println("1. View Deals");
	        System.out.println("2. Delete Deals");
	        System.out.println("3. Search Deals");
	        System.out.println("You will be logged out after making an action");
	    
	       
	         
	    }
	   
	    private static void BuyerDealMenu() { //David
	        C206_CaseStudy.setHeader("Deal Home Page");
	        
	        System.out.println("1. View Deals");
	        System.out.println("2. Delete Deals");
	        System.out.println("3. Search Deals");
	        System.out.println("You will be logged out after making an action");
	        
	       
	        
	    }
	    
	    
	    private static void SellerDealMenu() { //David
	        C206_CaseStudy.setHeader("Deal Home Page");
	        System.out.println("1. Add Deals");
	        System.out.println("2. View Deals");
	        System.out.println("3. Delete Deals");
	        System.out.println("4. Search Deals");
	        System.out.println("5. Update Deals");
	        System.out.println("You will be logged out after making an action");
	    }
	    
	    private static void SearchDealMenu() { //David
	        C206_CaseStudy.setHeader("Search Deals By:");
	        System.out.println("1. Item Name");
	        System.out.println("2. Buyer Email");
	        System.out.println("3. Seller Email");
	        System.out.println("4. Deal Price");
	        System.out.println("5. Close Date");
	        System.out.println("You will be logged out after making an action");
	        
	    }
	    
	    private static void AdminUsersMenu() { //Si Yuan

			C206_CaseStudy.setHeader("Admin Home Page");
			System.out.println("1. Search users");
			System.out.println("2. View users");
			System.out.println("You will be logged out after making an action");
		}
	    
	    private static void SearchItemMenu() { //Anisa
	    	C206_CaseStudy.setHeader("Search Items By: ");
	    	System.out.println("1. Name");
	    	System.out.println("2. Description");
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
	
	// ----------------------------- Deals ---------------------------------- (David)//
	
	public static void addDeal(Deal d ) {
		 
		 
		dealList.add(d);
		System.out.println("You have successfully added a deal.");
		System.out.println("");
	}
	
	public static String viewAllDeal() {
		String output = "";
		for(int i = 0; i < dealList.size();i++) {
			 output += dealList.get(i).toString();
			 
		}
		
		return output;
	}
	
	public static void delDeal( String dealID) {
		for(int i = 0; i < dealList.size(); i++) {
			if(dealList.get(i).getDealID().equals(dealID) ) {
				System.out.println("You Have Successfully Deleted Deal: " + dealList.get(i).getDealID());
				System.out.println("");
				dealList.remove(i);	
			}else {
				System.out.println("You have entered an invalid deal id");
			}
		}
	}
	
	public static  String searchDeal(String itemName, String buyerEmail, String sellerEmail, double dealPrice, String closeDate ) {
		 
	
		String output = "";
		if(dealList.size() != 0) {
			for(int i = 0; i < dealList.size(); i++) {
				if(dealList.get(i).getItemName().equals(itemName)) {
					  output += dealList.get(i).toString();
				}
				else if(dealList.get(i).getBuyerEmail().equals(buyerEmail)) {
					  output += dealList.get(i).toString();
				}
				else if(dealList.get(i).getSellerEmail().equals(sellerEmail)) {
					  output += dealList.get(i).toString();
				}
				else if(dealList.get(i).getDealPrice()==dealPrice) {
					  output += dealList.get(i).toString();
				}
				else if(dealList.get(i).getCloseDate().equals(closeDate)) {
					  output += dealList.get(i).toString();
				}
				else {
					output += "You have entered an invalid search";
				}
			}
		}
		
		return output;
	}
	
	public static void  updateDeal(String dealID, String itemName, String buyerEmail, String sellerEmail, double dealPrice, String closeDate) {
		for(int i = 0; i < dealList.size(); i++) {
			if(dealList.get(i).getDealID().equals(dealID)) {
				dealList.get(i).setItemName(itemName);
				dealList.get(i).setBuyerEmail(buyerEmail);
				dealList.get(i).setSellerEmail(sellerEmail);
				dealList.get(i).setDealPrice(dealPrice);
				dealList.get(i).setCloseDate(closeDate);
				System.out.println("");
				System.out.println("You have successfully updated your deal!");
			}
		}
	}
	
	public static String feedback(String fdback) {
		return fdback;
	}
	
	
	// ----------------------------- Deals ---------------------------------- (David)//
	// ----------------------------- Item ---------------------------------- (Anisa)//
	public static String viewAllItem() {
		String output = "";
		for(int i = 0; i < itemList.size();i++) {
			 output += itemList.get(i).toString();
			 
		}
		
		return output;
	}
	
	public static void addItem(Item item ) { 
		itemList.add(item);
	}
	
	public static void delItem( String item) {
		for(int i = 0; i < itemList.size(); i++) {
			if(itemList.get(i).getName().equals(item) ) {
				itemList.remove(i);
				System.out.println("You Have Successfully Deleted Item: " + itemList.get(i).getName());
				System.out.println("");
			}else {
				System.out.println("Delete failed");
			}
		}
	}
	
	public static  String searchItem(String name, String description) {
		 
		String output = "";
		if(itemList.size() != 0) {
			for(int i = 0; i < itemList.size(); i++) {
				if(itemList.get(i).getName().equalsIgnoreCase(name)) {
					  output += itemList.get(i).toString();
				}
				else if(itemList.get(i).getDescription().contains(description)) {
					  output += itemList.get(i).toString();
					 
				}
			}
		}
		
		return output;
	}
	
	public static void  updateItem(String itemName, String desc, double minPrice, String startDate, String endDate, double bidIncrement) {
		for(int i = 0; i < itemList.size(); i++) {
			itemList.get(i).setName(itemName);
			itemList.get(i).setDescription(desc);
			itemList.get(i).setMinPrice(minPrice);
			itemList.get(i).setStartDate(startDate);
			itemList.get(i).setEndDate(endDate);
			itemList.get(i).setBidIncrement(bidIncrement);
			System.out.println("");
			System.out.println("You have successfully updated your item!");
			}
		}
	//----------------------------- Item ---------------------------------- (Anisa)//
//----------------------------- Users ---------------------------------- (Si Yuan)//
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
		
		public static int loginUser(String email, String password) {
	
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
	// ----------------------------- Users ---------------------------------- (Si Yuan)//

