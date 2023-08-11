public class Menu {
    private String itemName;
    private double itemPrice;
  private int menuNo;

    private static int currentMenuNo = 1;

    public Menu(String itemName, double itemPrice) {
        this.itemName = itemName;
        this.itemPrice= itemPrice;
    }

    public String getItemName() {
        return itemName;
    }
 
    public void setItemName(String ItemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double ItemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getMenuNo() {
        return menuNo;
    }
}
