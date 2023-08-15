
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 22017670, 9 Aug 2023 4:01:17 pm
 */

public class Order {
	private int orderNo;
	private String orderDescription;
	private double orderPrice;
	private boolean isCollected;
	
	private static int currentNo = 001;
	
	public Order(String orderDescription, double orderPrice, boolean isCollected) {
		this.orderNo = currentNo++;
		this.orderDescription = orderDescription;
		this.orderPrice = orderPrice;
		this.isCollected = isCollected;
	}

	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	public boolean isCollected() {
		return isCollected;
	}

	public void setCollected(boolean isCollected) {
		this.isCollected = isCollected;
	}

	public static int getCurrentNo() {
		return currentNo;
	}

	public static void setCurrentNo(int currentNo) {
		Order.currentNo = currentNo;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public double getOrderPrice() {
		return orderPrice;
	}
	

}
