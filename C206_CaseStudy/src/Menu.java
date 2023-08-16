import java.util.ArrayList;

public class Menu {
    private String menuName;
    private ArrayList<String> itemNames;

    public Menu(String menuName, ArrayList<String> itemNames) {
        this.menuName = menuName;
        this.itemNames = itemNames;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public ArrayList<String> getItemNames() {
        return itemNames;
    }

    public void setItemNames(ArrayList<String> itemNames) {
        this.itemNames = itemNames;
    }
}
