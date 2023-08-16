
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 22017670, 6 Aug 2023 2:41:01 pm
 */

public class Queue {

	private String stallName;
	private int orders;
	private int estWait;

	public Queue(String stallName, int orders, int estWait) {
		this.stallName = stallName;
		this.orders = orders;
		this.estWait = estWait;
	}

	public String getStallName() {
		return stallName;
	}

	public int getOrders() {
		return orders;
	}

	public void setOrders(int orders) {
		this.orders = orders;
	}

	public int getEstWait() {
		return estWait;
	}
}

