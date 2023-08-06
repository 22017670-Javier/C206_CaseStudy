import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Stall> stallList = new ArrayList<Stall>();

		stallList.add(new Stall("frozen yogurt", "dessert"));

		int mode = 0; //mode determines what account is being used to access the system
		int option = 0;

		while (mode != 4) {
			accMenu();
			mode = Helper.readInt("Choose account to proceed > ");

			if (mode == 1) {
				System.out.println("Logged in as admin!");

				while (option != 16) {
					C206_CaseStudy.adminMenu();
					option = Helper.readInt("Enter an option > ");

					if (option == 1) {
						//add a new user

					}

					else if (option == 2) {
						//view all users

					}

					else if (option == 3) {
						//delete existing user

					}

					else if (option == 4) {
						//add a new stall
						Stall s = inputStall();
						C206_CaseStudy.addStall(stallList, s);
						System.out.println("Stall added");
					}

					else if (option == 5) {
						//view all stalls
						C206_CaseStudy.viewAllStall(stallList);
					}

					else if (option == 6) {
						//delete existing stall
						String stallName = Helper.readString("Enter the stall name to delete: ");
						C206_CaseStudy.deleteStall(stallList, stallName);
					}

					else if (option == 7) {
						//add a new menu

					}

					else if (option == 8) {
						//view all menus

					}

					else if (option == 9) {
						//delete existing menu

					}

					else if (option == 10 ) {
						//add a new order

					}

					else if (option == 11) {
						//view all orders

					}

					else if (option == 12) {
						//delete existing order

					}

					else if (option == 13) {
						//add a new queue

					}

					else if (option == 14) {
						//view all queues

					}

					else if (option == 15) {
						//delete existing queue

					}

					else if (option == 16) {
						System.out.println("Logged out!");
					}

					else {
						System.out.println("Invalid option!");
					}
				}
			}

			//Stall owner mode
			else if (mode == 2) {
				System.out.println("Logged in as Stall Staff");

				while (option != 7) {
					C206_CaseStudy.stallMenu();

					option = Helper.readInt("Enter an option > ");

					if (option == 1) {
						//add new menu

					}

					else if (option == 2) {
						//delete existing menu

					}

					else if (option == 3) {
						//view all orders

					}

					else if (option == 4) {
						//delete existing order

					}

					else if (option == 5) {
						//add a new queue

					}

					else if (option == 6) {
						//delete existing queue

					}

					else if (option == 7) {
						System.out.println("Logged out!");
					}

					else {
						System.out.println("Invalid option!");
					}
				}
			}

			//User mode
			else if (mode == 3) {
				System.out.println("Logged in as user!");

				while (option != 5) {
					C206_CaseStudy.userMenu();
					option = Helper.readInt("Enter an option > ");

					if (option == 1) {
						//view all stalls
						C206_CaseStudy.viewAllStall(stallList);
					}

					else if (option == 2) {
						//view all menus

					}

					else if (option == 3) {
						//add a order

					}

					else if (option == 4) {
						//view all queues

					}

					else if (option == 5) {
						System.out.println("Logged out!");
					}

					else {
						System.out.println("Invalid option!");
					}

				}
			}

			else if (mode == 4) {
				System.out.println("Thank you for using Canteen Ordering and Queuing System!");
			}

			else {
				System.out.println("Invalid option!");
			}
		}

	}
	public static void accMenu() {
		C206_CaseStudy.setHeader("Log In");
		System.out.println("1. System Admin");
		System.out.println("2. Stall Staff");
		System.out.println("3. User");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}

	public static void adminMenu() {
		C206_CaseStudy.setHeader("Canteen Ordering and Queuing System (Admin Access)");
		System.out.println("1.  Add a new user");
		System.out.println("2.  View all users");
		System.out.println("3.  Delete existing user");

		System.out.println("4.  Add new stall");
		System.out.println("5.  View all Stalls");
		System.out.println("6.  Delete existing Stall");

		System.out.println("7.  Add a new menu");
		System.out.println("8.  View all menus");
		System.out.println("9.  Delete existing menu");

		System.out.println("10. Add a new order");
		System.out.println("11. View all orders");
		System.out.println("12. Delete existing order");

		System.out.println("13. Add a new queue");
		System.out.println("14. View all queues");
		System.out.println("15. Delete existing queue");

		//Exits the system
		System.out.println("16. Quit");
		Helper.line(80, "-");
	}

	public static void stallMenu() {
		C206_CaseStudy.setHeader("Canteen Ordering and Queuing System (Stall Access)");

		System.out.println("1. Add a new menu");
		System.out.println("2. Delete existing menu");
		System.out.println("3. View all orders");
		System.out.println("4. Delete existing order");
		System.out.println("5. Add a new queue");
		System.out.println("6. Delete existing queue");

		//Exits the system
		System.out.println("7. Quit");
		Helper.line(80, "-");
	}

	public static void userMenu() {
		C206_CaseStudy.setHeader("Canteen Ordering and Queuing System");

		System.out.println("1. View all stalls");
		System.out.println("2. View all menus");
		System.out.println("3. Add a new order");
		System.out.println("4. View all queues");

		//Exits the system
		System.out.println("5. Quit");
		Helper.line(80, "-");
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	//================================= Add/View/Delete User =================================
	//add new user

	//view all user

	//delete existing user


	//================================= Add/View/Delete Stall =================================
	//view all stalls
	public static void viewAllStall(ArrayList<Stall> stallList) {
		C206_CaseStudy.setHeader("STALL LIST");
		String output = String.format("%-10s %-30s %-20s\n", "STALL NO.", "STALL NAME",
				"CATEGORY");
		output += retrieveAllStall(stallList);	
		System.out.println(output);
	}

	public static String retrieveAllStall(ArrayList<Stall> stallList) {
		// write your code here
		String output = "";

		for (int i = 0; i < stallList.size(); i++) {
			output += String.format("%-10s %-30s %-20s\n", stallList.get(i).getStallNo(), stallList.get(i).getStallName(), stallList.get(i).getCategory());

		} 
		return output;
	}
	
	public static Stall inputStall() {

		String name = Helper.readString("Enter stall name > ");
		String category = Helper.readString("Enter stall category (e.g. drinks or western..) > ");

		Stall newStall = new Stall(name, category);
		return newStall;
	}
	
	//add new stall 
	public static void addStall(ArrayList<Stall> stallList, Stall s) {
		Stall stall;
		for(int i = 0; i < stallList.size(); i++) {
			stall = stallList.get(i);
			if (stall.getStallName().equalsIgnoreCase(s.getStallName()) )

				return;
		}
		if ((s.getStallName().isEmpty()) || (s.getCategory().isEmpty()) ) {
			return;
		}

		stallList.add(s);
	}
	
	//delete existing stall
	public static void deleteStall(ArrayList<Stall> stallList, String stallName) {
		for (int i = 0; i < stallList.size(); i++) {
			Stall stall = stallList.get(i);
			if (stall.getStallName().equalsIgnoreCase(stallName)) {
				stallList.remove(i);
				System.out.println("Stall deleted.");
				return;
			}
		}
		System.out.println("Stall not found.");
	}

	//================================= Add/View/Delete Menu =================================
	//add new menu

	//view all menus

	//delete existing menu

	//================================= Add/View/Delete Order =================================
	//add new order

	//view all orders

	//delete existing order

	//================================= Add/View/Delete Queue =================================
	//add new queue

	//view all queues

	//delete existing queue

}
