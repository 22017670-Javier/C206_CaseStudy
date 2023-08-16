public class MenuItem {
    private String menuName;
    private String itemName;

    public MenuItem(String menuName, String itemName) {
        this.menuName = menuName;
        this.itemName = itemName;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
