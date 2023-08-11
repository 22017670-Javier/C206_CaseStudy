import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Stall s1;
	private Stall s2;
	private ArrayList<Stall> stallList;
	private ArrayList<Queue> queueList;
	private ArrayList<Order> orderList;

	public C206_CaseStudyTest() {
		super();
	}
	@Before
	public void setUp() throws Exception {
		// prepare test data
		s1 = new Stall("Pi Li Hong", "Chinese lok lok");
		s2 = new Stall("7-Eleven", "Snack & Drinks");
		stallList= new ArrayList<Stall>();
		queueList = new ArrayList<Queue>();
		orderList = new ArrayList<Order>();
	}


	//----------Add, View, Delete Stall----------
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

		// Add an item
		C206_CaseStudy.addStall(stallList, s2);
		assertEquals("Test that the Stall arraylist size is now 2.", 2, stallList.size());
		//The item just added is as same as the last item in the list
		assertSame("Test that Stall is added to the end of the list.", s2, stallList.get(1));

		// Add an item that already exists in the list
		C206_CaseStudy.addStall(stallList, s2);
		assertEquals("Test that the Stall arraylist size is unchange.", 2, stallList.size());

		// Add an item that has missing detail
		Stall stall_missing = new Stall("", "Drinks");
		C206_CaseStudy.addStall(stallList, stall_missing);
		assertEquals("Test that the Stall arraylist size is unchange.", 2, stallList.size());
	}
	
	@Test
	public void testViewAllStall() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid stall arraylist to retrieve item", stallList);

		//test if the list of stall retrieved from the C206_CaseStudy is empty - boundary
		String allStall = C206_CaseStudy.retrieveAllStall(stallList);
		String testOutput = "";
		assertEquals("Check that ViewAllStalllist", testOutput, allStall);

		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addStall(stallList, s1);
		C206_CaseStudy.addStall(stallList, s2);
		assertEquals("Test that Camcorder arraylist size is 2", 2, stallList.size());

		//test if the expected output string same as the list of stall retrieved from the SourceCentre	
		allStall= C206_CaseStudy.retrieveAllStall(stallList);
		testOutput = String.format("%-10s %-30s %-20s\n", 1, "Pi Li Hong", "Chinese lok lok");
		testOutput = String.format("%-10s %-30s %-20s\n", 2, "7-Eleven", "Snack & Drinks");

		assertEquals("Test that ViewAllStalllist", testOutput, allStall);

	}

	//----------Add, View, Delete Queue----------
	@Test
	public void testViewAllQueue() {

		assertNotNull("Test if there is a valid queue arraylist to retrieve items", queueList);

		// Given a list of queues
		queueList.add(new Queue("Stall A", 5, 20));
		queueList.add(new Queue("Stall B", 3, 12));

		// Expected output
		String expectedOutput = String.format("%-30s %-15s %-30s\n", "Stall Name", "No. of Orders", "Estimated Waiting Time");
		expectedOutput += String.format("%-30s %-15d %-30d mins\n", "Stall A", 5, 20);
		expectedOutput += String.format("%-30s %-15d %-30d mins\n", "Stall B", 3, 12);

		// Call the method to retrieve all queues
		String allQueues = C206_CaseStudy.retrieveAllQueues(queueList);

		// Check if the expected output matches the actual output
		assertEquals(expectedOutput, allQueues);
	}

	@Test
	public void testAddQueue() {
		// Ensure that the queueList is not null
		assertNotNull("Test if there is a valid queue arraylist to add to", queueList);

		// Given a list of stalls, orders, and a queue
		stallList.add(new Stall("Stall A", "Food"));
		orderList.add(new Order("Stall A", 5, false)); // Assume orders are initialized with quantities

		// Add a new queue
		C206_CaseStudy.addQueue(stallList, queueList, orderList);

		// Ensure that the queue was added successfully
		assertEquals("Test that the queueList size is 1.", 1, queueList.size());
		assertEquals("Test that the stallName of the added queue is correct.", "Stall A", queueList.get(0).getStallName());
		assertEquals("Test that the orders of the added queue are correct.", 5, queueList.get(0).getOrders());
		// Assuming that the estimated wait time is 4 minutes per order
		assertEquals("Test that the estimated waiting time of the added queue is correct.", 20, queueList.get(0).getEstWait());
	}


	@Test
	public void testDeleteQueue() {
	    // Ensure that the queueList is not null
	    assertNotNull("Test if there is a valid queue arraylist to delete from", queueList);

	    // Given a list of queues
	    Queue queue1 = new Queue("Stall A", 5, 20);
	    Queue queue2 = new Queue("Stall B", 3, 12);
	    queueList.add(queue1);
	    queueList.add(queue2);

	    // Ensure that the queueList size is 2
	    assertEquals("Test that the queueList size is 2 before deletion.", 2, queueList.size());

	    // Delete a queue
	    boolean isDeleted = C206_CaseStudy.deleteQueue(queueList, "Stall A");

	    // Ensure that the queue was deleted successfully
	    assertTrue("Test that a queue was successfully deleted.", isDeleted);
	    assertEquals("Test that the queueList size is 1 after deletion.", 1, queueList.size());
	    assertEquals("Test that the remaining queue's stallName is correct.", "Stall B", queueList.get(0).getStallName());
	}



	@After
	public void tearDown() throws Exception {
		s1 = null;
		s2 = null;
		stallList = null;
		queueList = null;
	}

}
