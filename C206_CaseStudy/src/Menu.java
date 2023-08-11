import java.util.ArrayList;

public class Menu {
    private ArrayList<MenuItem> menuItems;

    public Menu() {
        this.menuItems = new ArrayList<>();
    }

    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }
}
