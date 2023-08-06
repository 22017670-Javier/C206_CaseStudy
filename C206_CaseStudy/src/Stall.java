
public class Stall {
    private String stallName;
    private int stallNo;
    private String category;

    private static int currentStallNo = 1;

    public Stall(String stallName, String category) {
        this.stallName = stallName;
        this.stallNo = currentStallNo++;
        this.category = category;
    }

    public String getStallName() {
        return stallName;
    }

    public void setStallName(String stallName) {
        this.stallName = stallName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStallNo() {
        return stallNo;
    }
}

