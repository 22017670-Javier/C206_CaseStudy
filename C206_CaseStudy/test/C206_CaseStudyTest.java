import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class C206_CaseStudyTest {
	private Stall s1;
	private Stall s2;
	private Stall s3;
	private ArrayList<Stall> stallList;
	private ArrayList<Queue> queueList;
	private ArrayList<Order> orderList;
	private ArrayList<User> userList;

	public C206_CaseStudyTest() {
		super();
	}
	@Before
	public void setUp() throws Exception {
		// prepare test data
		s1 = new Stall("frozen yogurt", "dessert");
		s2 = new Stall("seasons", "dessert");
		

		stallList= new ArrayList<Stall>();
		queueList = new ArrayList<Queue>();
		orderList = new ArrayList<Order>();
		userList = new ArrayList<User>();

	}

	//----------Add, View, Delete User-----------
	@Test
	public void testAddUser() {
		ArrayList<User> userList = new ArrayList<>();
		User u1 = new User("Alice", 1, "User");

		// Adding a new user
		User.addUser(userList, u1);

		// Assert that the user was added correctly
		assertEquals(1, userList.size());  // Check if the size of the userList is 1
		User addedUser = userList.get(0);
		assertEquals("Alice", addedUser.getUserName());  // Check if the added user's name is "Alice"
		assertEquals(1, addedUser.getUserID());  // Check if the added user's ID is 1
		assertEquals("User", addedUser.getAcct());  // Check if the added user's account type is "User"
	}

	@Test
	public void testViewAllUser() {
		ArrayList<User> userList = new ArrayList<>();
		User u1 = new User("Alice", 1, "User");
		User u2 = new User("Bob", 2, "Stall Staff");
		userList.add(u1);
		userList.add(u2);

		// Testing viewAllUser
		User.viewAllUser(userList);
		// Add assertions to check the output or verify expected behavior
	}

	@Test
	public void testDeleteUser() {
		ArrayList<User> userList = new ArrayList<>();
		User u1 = new User("Alice", 1, "User");
		User u2 = new User("Bob", 2, "Stall Staff");
		userList.add(u1);
		userList.add(u2);

		// Deleting an existing user
		User.deleteUser(userList, "Alice");
		// Add assertions to check if the user was deleted correctly
	}



	//----------Add, View, Delete Stall----------
	@Test
	public void testViewAllStall() {
		C206_CaseStudy.addStall(stallList, s1);
		C206_CaseStudy.addStall(stallList, s2);

		assertEquals(1,stallList.size());
		assertTrue(stallList.contains(s1));
		assertFalse(stallList.isEmpty());
	}

	@Test
	public void testAddStall() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
		// Item list is not null and it is empty
		assertNotNull("Test if there is valid Stall arraylist to add to", stallList);
		assertEquals("Test that the Stall arraylist is empty.", 0, stallList.size());
		//Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addStall(stallList, s1);  
		assertEquals("Test that the Stall arraylist size is 1.", 1, stallList.size());

		//Given an empty list, after adding 1 item, the size of the list is 2
		C206_CaseStudy.addStall(stallList, s2);  
		stallList.add(s2);
		assertEquals("Test that the Stall arraylist size is 2.", 2, stallList.size());

		// Add an item
		s3 = new Stall("Mcd", "Fast-food");
		C206_CaseStudy.addStall(stallList, s3);
		stallList.add(s3);
		assertEquals("Test that the Stall arraylist size is now 3.", 3, stallList.size());
		//The item just added is as same as the last item in the list
		assertSame("Test that Stall is added to the end of the list.", s3, stallList.get(2));

		// Add an item that already exists in the list
		C206_CaseStudy.addStall(stallList, s2);
		assertEquals("Test that the Stall arraylist size is unchange.", 3, stallList.size());

		// Add an item that has missing detail
		Stall stall_missing = new Stall("", "Chinese lok lok");
		C206_CaseStudy.addStall(stallList, stall_missing);
		assertEquals("Test that the Stall arraylist size is unchange.", 3, stallList.size());
	}



	@Test
	public void testDeleteStall() {
		// Create a list of stalls for testing
		ArrayList<Stall> stallList = new ArrayList<>();
		stallList.add(new Stall("Subway", "Fast food"));
		stallList.add(new Stall("KFC", "Fast Food"));

		// Test case: Deleting an existing stall
		C206_CaseStudy.deleteStall(stallList, "Subway");
		assertEquals("Expected 1 stall after deletion", 1, stallList.size());
		assertNotEquals("Expected 2 stall after deletion", 2, stallList.size());

		// Test case: Deleting a non-existing stall (no change in size)
		C206_CaseStudy.deleteStall(stallList, "Mcd");
		assertEquals("Expected 1 stall after attempting to delete a non-existing stall", 1, stallList.size());
	}
	//----------Add, View, Delete Menu----------

	private ArrayList<Menu> menuList;
	private ArrayList<MenuItem> menuItemList;

	@Before
	public void setUp1() {
		menuList = new ArrayList<>();
		menuItemList = new ArrayList<>();
	}

	@Test
	public void testViewAllMenu() {
		Menu menu1 = new Menu("Menu 1", new ArrayList<>(Arrays.asList("Item A", "Item B")));
		menuList.add(menu1);

		String expectedOutput = "Menu Name: Menu 1\nItems:\n- Item A\n- Item B\n\n";
		assertEquals(expectedOutput, C206_CaseStudy.retrieveAllMenus(menuList, menuItemList));
	}

	@Test
	public void testAddMenu() {
		Menu newMenu = new Menu("New Menu", new ArrayList<>(Arrays.asList("Item X", "Item Y")));
		C206_CaseStudy.addMenu(menuList, newMenu);

		assertEquals(1, menuList.size());
		assertEquals("New Menu", menuList.get(0).getMenuName());
		assertEquals("Item X", menuList.get(0).getItemNames().get(0));
		assertEquals("Item Y", menuList.get(0).getItemNames().get(1));
	}

	//Delete Menus

	@Test
	public void testDeleteItemMenu() {
		Menu menuToDelete = new Menu("Menu to Delete", new ArrayList<>(Arrays.asList("Item C", "Item D")));
		menuList.add(menuToDelete);
		menuItemList.add(new MenuItem("Menu to Delete", "Item C"));
		menuItemList.add(new MenuItem("Menu to Delete", "Item D"));

		C206_CaseStudy.deleteItemMenu(menuList, "Menu to Delete", menuItemList);

		assertEquals(0, menuList.size());
		assertEquals(0, menuItemList.size());
	}

	@Test
	public void testDeleteMenuItems() {
		menuItemList.add(new MenuItem("Menu 1", "Item A"));
		menuItemList.add(new MenuItem("Menu 1", "Item B"));

		C206_CaseStudy.deleteMenuItems(menuItemList, "Menu 1");

		assertEquals(0, menuItemList.size());}

	//----------Add, View, Delete Orders----------

	@Test
	public void testAddOrder() { 
		ArrayList<Order> orderList = new ArrayList<>();
		Order o1 = new Order("Western", "Burger", 5.99, false);

		assertTrue("C206_CaseStudy_SampleTest", true);

		assertNotNull("Test if there is a valid Order arraylist to add to", orderList);
		assertEquals("Test that the Order arraylist is empty.", 0, orderList.size());

		C206_CaseStudy.addOrder(orderList, null, null, 0, false );

		assertEquals("Test that the Order arraylist size is 1 after adding an order.", 1, orderList.size());
		assertTrue("Test that Order arraylist contains the added order.", orderList.contains(o1));
	}

	@Test
	public void testDeleteOrder() {
		ArrayList<Order> orderList = new ArrayList<>();
		Order o1 = new Order("Western", "Burger", 5.99, false);
		orderList.add(o1);

		assertEquals("Test that the Order arraylist size is 1 before deleting.", 1, orderList.size());

		C206_CaseStudy.deleteOrder(orderList, 1);

		assertEquals("Test that the Order arraylist size is 0 after deleting an order.", 0, orderList.size());
	}

	@Test
	public void testViewAllOrder() {
		ArrayList<Order> orderList = new ArrayList<>();
		Order o1 = new Order("Western", "Burger", 5.99, false);
		Order o2 = new Order("Western", "Pizza", 10.99, true);
		orderList.add(o1);
		orderList.add(o2);

		String expectedOutput = "Order List:\n" +
				"Order No.\tDescription\tPrice\tCollected\n" +
				"1\tBurger\t5.99\tNo\n" +
				"2\tPizza\t10.99\tYes\n";

		String actualOutput = C206_CaseStudy.retrieveAllOrders(orderList);

		assertEquals("Expected output should match the printed output", expectedOutput, actualOutput);
	}


	//----------Add, View, Delete Queue----------
	@Test
	public void testViewAllQueue() {
	    // Ensure that the queueList is not null
	    assertNotNull("Test if there is a valid queue arraylist to retrieve items", queueList);

	    // Given a list of queues
	    queueList.add(new Queue("Stall A", 5, 20));
	    queueList.add(new Queue("Stall B", 3, 12));

	    // Expected output
	    String expectedOutput = String.format("%-30s %-15s %-30s\n", "Stall Name", "No. of Orders", "Estimated Waiting Time");
	    expectedOutput += String.format("%-30s %-15d %-17d mins\n", "Stall A", 5, 20);
	    expectedOutput += String.format("%-30s %-15d %-17d mins\n", "Stall B", 3, 12);

	    // Call the method to retrieve all queues
	    String allQueues = C206_CaseStudy.retrieveAllQueues(queueList);

	    // Check if the expected output matches the actual output
	    assertEquals(expectedOutput, allQueues);
	}

	@Test
	public void testAddQueue() {

		// Ensure that the queueList is not null
		assertNotNull("Test if there is a valid queue arraylist to add to", queueList);

		// Given a list of stalls and orders
		stallList.add(new Stall("Stall A", "Food"));
		orderList.add(new Order("Stall A", "Burger", 5, false)); 

		// Test normal condition: Adding a new queue
		C206_CaseStudy.addQueue(stallList, queueList, orderList);

		// Ensure that the queue was added successfully
		assertEquals("Test that the queueList size is 1.", 1, queueList.size());
		assertEquals("Test that the stallName of the added queue is correct.", "Stall A", queueList.get(0).getStallName());
		assertEquals("Test that the estimated waiting time of the added queue is correct.", 20, queueList.get(0).getEstWait());

		// Test boundary condition: Adding a new queue with zero orders
		orderList.add(new Order("Stall A", "Pizza", 0, false));
		C206_CaseStudy.addQueue(stallList, queueList, orderList);
		assertEquals("Test that the queueList size is 2.", 2, queueList.size());
		assertEquals("Test that the orders of the added queue are correct.", 0, queueList.get(1).getOrders());
		assertEquals("Test that the estimated waiting time of the added queue is correct.", 0, queueList.get(1).getEstWait());

		// Test error condition: Adding a queue for a non-existent stall
		C206_CaseStudy.addQueue(stallList, queueList, orderList);
		assertEquals("Test that the queueList size is still 2.", 2, queueList.size());
	}

	@Test
	public void testDeleteQueue() {

		// Create a list of queues for testing
		ArrayList<Queue> queueList = new ArrayList<>();
		queueList.add(new Queue("Chicken Rice", 2, 30));
		queueList.add(new Queue("Nasi Lemak", 2, 30));

		// Test case: Deleting an existing queue
		C206_CaseStudy.deleteQueue(queueList, "Chicken Rice");
		assertEquals("Expected 1 queue left after deletion", 1, queueList.size());

		// Test case: Deleting a non-existing queue 
		C206_CaseStudy.deleteQueue(queueList, "Mcd");
		assertEquals("Expected 1 queue remianing with no size change after attempting to delete a non-existing stall", 
				1, queueList.size());

		// Test case: Delete final queue to reach 0 queues remaining
		C206_CaseStudy.deleteQueue(queueList, "Nasi Lemak");
		assertEquals("Expected 0 queues remianing after deleting all stalls", 0, queueList.size());
	}



	@After
	public void tearDown() throws Exception {
		s1 = null;
		s2 = null;
		stallList = null;
		queueList = null;
	}

}
