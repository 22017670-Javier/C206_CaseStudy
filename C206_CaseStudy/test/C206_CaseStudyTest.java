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



	@Test
	public void c206_test() {
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
	
	public void testViewAll() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid queue arraylist to retrieve item", queueList);
		
		//test if the list of camcorders retrieved from the SourceCentre is empty - boundary
		String allCamcorder= C206_CaseStudy.viewAllQueues(stallList, queueList, orderList);
		String testOutput = "";
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		ResourceCentre.addCamcorder(camcorderList, cc1);
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test that Camcorder arraylist size is 2", 2, camcorderList.size());
		
		//test if the expected output string same as the list of camcorders retrieved from the SourceCentre	
		allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);
		testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n","CC0011", "Nikon HDSLR", "Yes", "", "40");
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n","CC0012", "Sony DSC-RX100M7", "Yes", "", "20" );
	
		assertEquals("Test that ViewAllCamcorderlist", testOutput, allCamcorder);
		
	}

	@After
	public void tearDown() throws Exception {
		s1 = null;
		s2 = null;
		stallList = null;
	}

}
