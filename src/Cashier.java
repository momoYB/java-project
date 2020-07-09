public class Cashier {
    private static int cnt;
    private final int ID;
    private String name;

    public Cashier(String name) {
        cnt++;
        this.ID = cnt;
        this.name = name;

    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cashier{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                '}';
    }
}
