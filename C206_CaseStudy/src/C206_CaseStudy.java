import java.util.ArrayList;


public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Stall> stallList = new ArrayList<Stall>();
		
		stallList.add(new Stall("frozen yogurt", "dessert"));
		
		int option = 0;
		
		while (option != -1) {
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");
			if (option == 1) {
				
			}
			else if(option == 2) {
				C206_CaseStudy.viewAllStall(stallList);
				int addOrDelete = Helper.readInt("Do you want to add (1) or delete (2) a stall? Enter your choice > ");
	            if (addOrDelete == 1) {
	                Stall s = inputStall();
	                C206_CaseStudy.addStall(stallList, s);
	                System.out.println("Stall added");
	            } else if (addOrDelete == 2) {
	                String stallName = Helper.readString("Enter the stall name to delete: ");
	                C206_CaseStudy.deleteStall(stallList, stallName);
	            }
				
			}
			
		}
		
	}
	public static void menu() {
		C206_CaseStudy.setHeader("Canteen Ordering and Queuing System");
		System.out.println("1) Display User Information");
		System.out.println("2) Display Stall Information");
		System.out.println("Enter '-1' to Quit");
		Helper.line(80, "-");

	}
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	//option 1 - view all stall
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
	//option 2 - add new stall 
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
	// Option 3 - delete stall by it's name
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

}
