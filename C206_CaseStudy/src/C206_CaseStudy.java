import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import java.util.ArrayList;
import java.util.Iterator;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Stall> stallList = new ArrayList<Stall>(); //Stalls
		ArrayList<Queue> queueList = new ArrayList<Queue>(); //Queues
		ArrayList<Order> orderList = new ArrayList<Order>(); //Orders
		ArrayList<Menu> menuList = new ArrayList<Menu>(); //Menu
		ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>(); //MenuItem
		ArrayList<User> userList = new ArrayList<User>(); //User

		stallList.add(new Stall("Frozen Yogurt", "dessert"));
		stallList.add(new Stall("Seasons", "dessert"));
		orderList.add(new Order("Frozen Yogurt", "strawberry yogurt", 1, false));

		int mode = 0; //mode determines what account is being used to access the system

		while (mode != 4) {
			int option = 0;

			accMenu();
			mode = Helper.readInt("Choose account to proceed > ");

			if (mode == 1) {
				System.out.println("Logged in as admin!");

				while (option != 11) {
					C206_CaseStudy.adminMenu();
					option = Helper.readInt("Enter an option > ");

					if (option == 1) {
						//view all users
						viewAllUser(userList);

					}

					else if (option == 2) {
						//add or delete user
						int addOrDelete = Helper.readInt("Do you want to add (1) or delete (2) a user? Enter your choice > ");

						if (addOrDelete == 1) {
							User u = inputUser();
							C206_CaseStudy.addUser(userList, u);
							System.out.println("user added!");
						} 

						else if (addOrDelete == 2) {
							String userName = Helper.readString("Enter the user name to delete > ");
							deleteUser(userList, userName);
						}

						else {
							System.out.println("Invalid option!");
						}

					}

					else if (option == 3) {
						//view all stalls
						System.out.println(C206_CaseStudy.viewAllStall(stallList));
					}

					else if (option == 4) {
						//add or delete stall
						int addOrDelete = Helper.readInt("Do you want to add (1) or delete (2) a stall? Enter your choice > ");

						if (addOrDelete == 1) {
							Stall s = inputStall();
							C206_CaseStudy.addStall(stallList, s);
							System.out.println("Stall added!");
						} 

						else if (addOrDelete == 2) {
							String stallName = Helper.readString("Enter the stall name to delete > ");
							C206_CaseStudy.deleteStall(stallList, stallName);
						}

						else {
							System.out.println("Invalid option!");
						}
					}

					else if (option == 5) {
						//view all menus
						C206_CaseStudy.viewAllMenu(menuList, menuItemList);

					}

					else if (option == 6) {
						//add or delete menu
						int addOrDelete = Helper.readInt("Do you want to add (1) or delete (2) a menu? Enter your choice > ");

						if (addOrDelete == 1) {
							Menu m = inputMenu();
							C206_CaseStudy.addMenu(menuList, m);
							System.out.println("Menu added!");
						} 

						else if (addOrDelete == 2) {
							String menuName = Helper.readString("Enter the menu name to delete > ");
							deleteItemMenu(menuList, menuName, menuItemList);
						}

						else {
							System.out.println("Invalid option!");
						}}


					else if (option == 7) {
						//view all orders
						viewAllOrders(orderList);

					}

					else if (option == 8) {
						//add or delete order
						int addOrDelete = Helper.readInt("Do you want to add (1) or delete (2) order? Enter your choice > ");

						if (addOrDelete == 1) {
							addOrder(orderList, null, null, option, false);
						} 

						else if (addOrDelete == 2) {
							deleteOrder(orderList, 0);
						}

						else {
							System.out.println("Invalid option!");
						}

					}

					else if (option == 9) {
						//view all queues
						viewAllQueues(stallList, queueList, orderList);

					}

					else if (option == 10) {
						//add or delete queue
						int addOrDelete = Helper.readInt("Do you want to add (1) or delete (2) queue? Enter your choice > ");

						if (addOrDelete == 1) {
							addQueue(stallList, queueList, orderList);
						} 

						else if (addOrDelete == 2) {
							String stallName ="";
							deleteQueue(queueList, stallName);
						}

						else {
							System.out.println("Invalid option!");
						}

					}

					else if (option == 11) {
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

				while (option != 6) {
					C206_CaseStudy.stallMenu();

					option = Helper.readInt("Enter an option > ");

					if (option == 1) {
						//add or delete new menu
						int addOrDelete = Helper.readInt("Do you want to add (1) or delete (2) a menu? Enter your choice > ");

						if (addOrDelete == 1) {
							Menu m = inputMenu();
							C206_CaseStudy.addMenu(menuList, m);
							System.out.println("Menu added!");
						} 

						else if (addOrDelete == 2) {
							String menuName = Helper.readString("Enter the menu name to delete > ");
							deleteItemMenu(menuList, menuName, menuItemList);
						}

						else {
							System.out.println("Invalid option!");
						}

					}

					else if (option == 2) {
						//view all orders
						viewAllOrders(orderList);

					}

					else if (option == 3) {
						//delete existing order
						deleteOrder(orderList, 0);

					}

					else if (option == 4) {
						//add or delete a new queue
						int addOrDelete = Helper.readInt("Do you want to add (1) or delete (2) queue? Enter your choice > ");

						if (addOrDelete == 1) {
							addQueue(stallList, queueList, orderList);
						} 

						else if (addOrDelete == 2) {
							String stallName = "";
							deleteQueue(queueList, stallName);
						}

						else {
							System.out.println("Invalid option!");
						}
					}
					else if (option == 5) {

						int updateDetails = Helper.readInt("Please enter the stall number that you want to update > ");
						for (int i=0; i<stallList.size(); i++) {
							if(updateDetails == stallList.get(i).getStallNo()) {
								updateStall(stallList, updateDetails);
							}
						}
					}
					else if (option == 6) {
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

				while (option != 6) {
					C206_CaseStudy.userMenu();
					option = Helper.readInt("Enter an option > ");

					if (option == 1) {
						//view all stalls
						C206_CaseStudy.viewAllStall(stallList);
					}

					else if (option == 2) {
						//view all menus
						C206_CaseStudy.viewAllMenu(menuList, menuItemList);

					}

					else if (option == 3) {
						//add a order
						addOrder( orderList, null, null, option, false);

					}

					else if (option == 4) {
						//view all queues
						viewAllQueues(stallList, queueList, orderList);

					}
					else if (option == 5) {
						//search stall by name, number, or category
						searchStallOption();
						searchStall(stallList);
					}
					else if (option == 6) {
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
		System.out.println("4. Log out");
		Helper.line(80, "-");
	}

	public static void adminMenu() {
		C206_CaseStudy.setHeader("Canteen Ordering and Queuing System (Admin Access)");
		System.out.println("1.  View all users");
		System.out.println("2.  Add or Delete user");

		System.out.println("3.  View all Stalls");
		System.out.println("4.  Add or Delete Stall");

		System.out.println("5.  View all menus");
		System.out.println("6.  Add or Delete menu");

		System.out.println("7.  View all orders");
		System.out.println("8.  Add or Delete order");

		System.out.println("9.  View all queues");
		System.out.println("10. Add or Delete queue");

		//Exits the system
		System.out.println("11. Log out");
		Helper.line(80, "-");
	}

	public static void stallMenu() {
		C206_CaseStudy.setHeader("Canteen Ordering and Queuing System (Stall Access)");

		System.out.println("1. Add or Delete menu");
		System.out.println("2. View all orders");
		System.out.println("3. Delete existing order");
		System.out.println("4. Add or Delete queue");
		System.out.println("5. Update stall details");

		//Exits the system
		System.out.println("6. Log out");
		Helper.line(80, "-");
	}
	public static void searchStallOption() {
		C206_CaseStudy.setHeader("Search by ...");

		System.out.println("1. Search by stall number");
		System.out.println("2. Search by stall name");
		System.out.println("3. Search by stall category");
	}

	public static void userMenu() {
		C206_CaseStudy.setHeader("Canteen Ordering and Queuing System");

		System.out.println("1. View all stalls");
		System.out.println("2. View all menus");
		System.out.println("3. Add a new order");
		System.out.println("4. View all queues");
		System.out.println("5. Search stall");
		//Exits the system
		System.out.println("6. Quit");
		Helper.line(80, "-");
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	//================================= Add/View/Delete User =================================
	//add new user
	public static void addUser(ArrayList<User> userList, User u) {
		User user;
		for(int i = 0; i < userList.size(); i++) {
			user = userList.get(i);
			if (user.getUserName().equalsIgnoreCase(u.getUserName()) )

				return;
		}

		userList.add(u);
	}

	//view all user
	public static void viewAllUser(ArrayList<User> userList) {
		C206_CaseStudy.setHeader("USER LIST");
		String output = String.format("%-10s %-30s %-20s\n", "USER ID", "USERNAME",
				"ACCT TYPE");
		output += retrieveAllUser(userList); 
		System.out.println(output);
	}

	public static String retrieveAllUser(ArrayList<User> userList) {
		// write your code here
		String output = "";

		for (int i = 0; i < userList.size(); i++) {
			output += String.format("%-10s %-30s %-20s\n", userList.get(i).getUserID(), userList.get(i).getUserName(), userList.get(i).getAcct());

		} 
		return output;
	}

	public static User inputUser() {

		String userName = Helper.readString("Enter username > ");
		int userID = Helper.readInt("Enter your user ID > ");
		String acct = Helper.readString("Enter account type (System Admin, Stall Staff or User) > ");

		User newUser = new User(userName, userID, acct);
		return newUser;
	}

	//delete existing user
	public static void deleteUser(ArrayList<User> userList, String userName) {
		for (int i = 0; i < userList.size(); i++) {
			User user = userList.get(i);
			if (user.getUserName().equalsIgnoreCase(userName)) {
				userList.remove(i);
				System.out.println("User has been deleted.");
				return;
			}
		}
		System.out.println("User does not exist.");
	}


	//================================= Add/View/Delete/Update/search Stall =================================
	//view all stalls
	public static String viewAllStall(ArrayList<Stall> stallList) {
		C206_CaseStudy.setHeader("STALL LIST");
		String output = String.format("%-10s %-30s %-20s\n", "STALL NO.", "STALL NAME", "CATEGORY");
		output += retrieveAllStall(stallList);
		return output; // Return the output string instead of printing it
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
		//Stall stall;
		for(int i = 0; i < stallList.size(); i++) {
			s = stallList.get(i);
			if (s.getStallName().equalsIgnoreCase(s.getStallName()) )

				return;
		}
		if ((s.getStallName().isEmpty()) || (s.getCategory().isEmpty()) ) {
			return;
		}

		stallList.add(s);
	}

	//delete existing stall
	public static void deleteStall(ArrayList<Stall> stallList, String stallName) {
		Iterator<Stall> iterator = stallList.iterator();
		while (iterator.hasNext()) {
			Stall stall = iterator.next();
			if (stall.getStallName().equalsIgnoreCase(stallName)) {
				iterator.remove();
				System.out.println("Stall deleted.");
				return;
			}
		}
		System.out.println("Stall not found.");
	}

	//update existing stall
	public static void updateStall(ArrayList<Stall> stallList, int stallNo) {
		for (int i=0; i<stallList.size(); i++) {
			Stall stall = stallList.get(i);
			if(stall.getStallNo() == stallNo) {
				int updateOption = Helper.readInt("Update Stall name(1), update stall category(2). Enter your option > ");
				if (updateOption == 1) {
					String newName = Helper.readString("Please enter stall name to update > ");
					if (stallList.get(i).getStallName().equalsIgnoreCase(newName)) {
						System.out.println("Please enter a different name");
					}
					else {
						System.out.println("You have updated Stall name sucessfully!!");
						stallList.get(i).setStallName(newName);
					}
				}
				else if (updateOption == 2) {
					String newCategory = Helper.readString("Please enter your stall category for update > ");
					if (stallList.get(i).getCategory().equalsIgnoreCase(newCategory)) {
						System.out.println("Please enter a different category name");
					}
					else {
						System.out.println("You have updated Stall category sucessfully!!");
						stallList.get(i).setCategory(newCategory);
					}
				}
				else {
					System.out.println("Invalid option selected !!!");
				}
			}
		}
	}
	//search stall
	public static void searchStall(ArrayList<Stall> stallList) {
		int option = Helper.readInt("Enter an option > ");
		boolean found = false; // Initialize a flag to track if a match is found
		String searchQuery = "";
		int stallNo = 0;
		if (option == 2 || option == 3) {
			searchQuery = Helper.readString("Enter your search query > ");
		}
		else if (option == 1) {
			stallNo = Helper.readInt("Enter a stall number > ");
		}
		for (Stall stall : stallList) {
			if (option == 1) {
				if (stallNo == stall.getStallNo()) {
					printStallDetails(stall);
					found = true; // Match found, set the flag
					break;
				}
			} else if (option == 2) {
				if (stall.getStallName().toLowerCase().contains(searchQuery.toLowerCase())) {
					printStallDetails(stall);
					found = true; // Match found, set the flag
				}
			} else if (option == 3) {
				if (stall.getCategory().toLowerCase().contains(searchQuery.toLowerCase())) {
					printStallDetails(stall);
					found = true; // Match found, set the flag
				}
			}
		}

		if (!found) {
			System.out.println("Stall could not be found.");
		}
	}
	//Stall owners can offer special promotions or discounts on specific food items or combos through the system, attracting customers and boosting sales. 
	public static void discountStall(ArrayList<Stall> stallList) {

	}

	public static void printStallDetails(Stall stall) {
		String output = String.format("%-10s %-30s %-20s\n", stall.getStallNo(), stall.getStallName(), stall.getCategory());
		System.out.println(output);
	}



	//================================= Add/View/Delete Menu =================================

	//view all menus
	public static void viewAllMenu(ArrayList<Menu> menuList, ArrayList<MenuItem> menuItemList) {
		C206_CaseStudy.setHeader("MENU LIST");
		String output = retrieveAllMenus(menuList, menuItemList);
		System.out.println(output);
	}

	public static String retrieveAllMenus(ArrayList<Menu> menuList, ArrayList<MenuItem> menuItemList) {
		String output = "";

		for (int i = 0; i < menuList.size(); i++) {
			Menu menu = menuList.get(i);
			output += String.format("Menu Name: %s\n", menu.getMenuName());
			output += "Items:\n";
			ArrayList<String> itemNames = menu.getItemNames();
			for (String itemName : itemNames) {
				output += String.format("- %s\n", itemName);
			}
			output += "\n";
		}
		return output;
	}

	public static Menu inputMenu() {
		String menuName = Helper.readString("Enter menu name > ");
		ArrayList<String> itemNames = new ArrayList<>();

		int numItems = Helper.readInt("Enter number of items in the menu > ");
		for (int i = 1; i <= numItems; i++) {
			String itemName = Helper.readString(String.format("Enter name of item %d > ", i));
			itemNames.add(itemName);
		}

		Menu newMenu = new Menu(menuName, itemNames);
		return newMenu;
	}

	//add new menu
	public static void addMenu(ArrayList<Menu> menuList, Menu m) {
		menuList.add(m);
		System.out.println("Menu added!");
	}

	//delete existing menu
	public static void deleteItemMenu(ArrayList<Menu> menuList, String menuName, ArrayList<MenuItem> menuItemList) {
		Iterator<Menu> iterator = menuList.iterator();
		while (iterator.hasNext()) {
			Menu menu = iterator.next();
			if (menu.getMenuName().equalsIgnoreCase(menuName)) {
				iterator.remove();
				System.out.println("Menu deleted.");
				// Also delete the associated menu items
				deleteMenuItems(menuItemList, menuName); // Corrected parameter name
				return;
			}
		}
		System.out.println("Menu not found.");
	}

	//delete associated menu items
	public static void deleteMenuItems(ArrayList<MenuItem> menuItemList, String menuNameToDelete) {
		Iterator<MenuItem> iterator = menuItemList.iterator();
		while (iterator.hasNext()) {
			MenuItem menuItem = iterator.next();
			if (menuItem.getMenuName().equalsIgnoreCase(menuNameToDelete)) {
				iterator.remove();
			}
		}
	}


	//================================= Add/View/Delete Order =================================
	//add new order
	public static void addOrder(ArrayList<Order> orderList, String name, String orderDescription, double orderPrice, boolean isCollected) {
		Order newOrder = new Order(name, orderDescription, orderPrice, isCollected);
		orderList.add(newOrder);
		System.out.println("Order added!");
	}


	//view all orders
	public static void viewAllOrders(ArrayList<Order> orderList) {
		C206_CaseStudy.setHeader("ORDER LIST");
		String output = String.format("%-10s %-30s %-10s %-10s\n", "ORDER NO.", "DESCRIPTION", "PRICE", "COLLECTED");
		output += retrieveAllOrders(orderList);
		System.out.println(output);
	}

	public static String retrieveAllOrders(ArrayList<Order> orderList) {
		String output = "";

		for (Order order : orderList) {
			String collectedStatus = order.isCollected() ? "Yes" : "No";
			output += String.format("%-10d %-30s $%-9.2f %-10s\n", order.getOrderNo(), order.getOrderDescription(), order.getOrderPrice(), collectedStatus);
		}
		return output;
	}


	//delete existing order
	public static void deleteOrder(ArrayList<Order> orderList, int orderNo) {
		Iterator<Order> iterator = orderList.iterator();
		while (iterator.hasNext()) {
			Order order = iterator.next();
			if (order.getOrderNo() == orderNo) {
				iterator.remove();
				System.out.println("Order deleted.");
				return;
			}
		}
		System.out.println("Order not found.");
	}

	//================================= Add/View/Delete Queue =================================
	//add new queue
	public static void addQueue(ArrayList<Stall> stallList, ArrayList<Queue> queueList, ArrayList<Order> orderList) {
		String name = Helper.readString("Enter name of stall > ");

		int totalOrders = 0;
		for (Order order : orderList) {
			if (order.getName().equalsIgnoreCase(name)) {
				totalOrders++;
			}
		}

		for (Stall stall : stallList) {
			if (stall.getStallName().equalsIgnoreCase(name)) {
				int time = Helper.readInt("Enter estimated time for order (in minutes) > ");
				queueList.add(new Queue(stall.getStallName(), totalOrders, time));
				System.out.println("Queue has been added successfully!");
				return; 
			}
		}

		System.out.println("Stall not found.");
	}


	//view all queues
	public static void viewAllQueues (ArrayList<Stall> stallList, ArrayList<Queue> queueList, ArrayList<Order> orderList) {

		String output = "";
		output += String.format("%-30s %-15s %-30s\n", "Stall Name", "No. of Orders", "Estimated Waiting Time");

		output += retrieveAllQueues(queueList);

		System.out.println(output);
	}

	public static String retrieveAllQueues(ArrayList<Queue> queueList) {
		// write your code here
		String output = "";

		for (int i = 0; i < queueList.size(); i++) {
			output += String.format("%-30s %-15d %-17d mins\n", queueList.get(i).getStallName(), 
					queueList.get(i).getOrders(), queueList.get(i).getEstWait());

		} 
		return output;
	}

	//delete existing queue
	public static void deleteQueue(ArrayList<Queue> queueList, String stallName) {

		if (queueList.size() <= 0) {
			System.out.println("There are no queues available for deletion!");
		}

		else if (queueList.size() > 0) {
			stallName = Helper.readString("Enter stall name for queue to be deleted > ");

			if (queueList.size() >= 1) {
				for (int i = 0; i < queueList.size(); i++) {
					if (queueList.get(i).getStallName().equalsIgnoreCase(stallName)) {

						String confirm = Helper.readString("Please enter confirmation for deletion (y/n) > ");

						if (confirm.equalsIgnoreCase("y")) {
							queueList.remove(i);
							System.out.println("Queue has been removed successfully!");
						}
						else {
							System.out.println("Deletion cancelled!");

						}
					}
					else if (queueList.get(i).getStallName() != stallName) {
						System.out.println("Queue does not exist!");
					}
				}
			}
		}
	}
}