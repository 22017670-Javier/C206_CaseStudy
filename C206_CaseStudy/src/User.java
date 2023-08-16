import java.util.ArrayList;

public class User {

	private String userName;
	private int userID;
	private String acct;

	public User(String userName, int userID, String acct) {
		this.userName = userName;
		this.userID = userID;
		this.acct = acct;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAcct() {
		return acct;
	}

	public void setAcct(String acct) {
		this.acct = acct;
	}

	public int getUserID() {
		return userID;
	}

	public static void addUser(ArrayList<User> userList, User u1) {
		
	}

	public static void viewAllUser(ArrayList<User> userList) {
		
	}

	public static void deleteUser(ArrayList<User> userList, String string) {
		
	}


}